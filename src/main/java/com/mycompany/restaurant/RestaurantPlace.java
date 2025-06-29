package com.mycompany.restaurant;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

public class RestaurantPlace {
    private final List<Table> tables = new ArrayList<>();
    private final Queue<WaitListEntry> waitList = new LinkedList<>();
    private final List<Reservation> reservations = new ArrayList<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private final Duration seatingDuration = Duration.ofMinutes(90);

    public void addReservation(Reservation res) {
        res.setReservation(Reservation.ReservationStatus.WAITING);
        reservations.add(res);
        System.out.println("Added reservation for " + res.getName() + " at " + res.getTime());
    }

    public long addToWaitList(WaitListEntry entry) {
        waitList.offer(entry);
        long estimated = estimateWaitTime(entry.getPartySize());
        System.out.println("Added to waitlist: " + entry + ". Estimated wait: " + estimated + " min");
        return estimated;
    }

    public void tick() {
        LocalDateTime now = LocalDateTime.now();

        // Clear due tables
        for (Table t : tables) {
            Reservation cr = t.getCurrentReservation();
            if (t.isOccupied() && cr != null && cr.getSeatTime() != null) {
                Duration elapsed = Duration.between(cr.getSeatTime(), now);
                if (elapsed.compareTo(seatingDuration) > 0) {
                    t.clear();
                    reservations.remove(cr);
                }
            }
        }

        // Seat waiting entries
        while (!waitList.isEmpty()) {
            WaitListEntry e = waitList.peek();
            Table t = findBestFitTable(e.getPartySize());
            if (t == null) break;

            Reservation res = new Reservation(LocalDateTime.now());
            res.setPartySize(e.getPartySize());
            res.setName(e.getName());

            t.assign(res);
            reservations.add(res);
            waitList.poll();

            scheduler.schedule(() -> {
                if (t.isOccupied()) {
                    t.clear();
                    reservations.remove(res);
                    System.out.println("Auto-cleared table " + t.getTableId());
                }
            }, seatingDuration.toMinutes(), TimeUnit.MINUTES);
        }
    }

    public long estimateWaitTime(int partySize) {
        int ahead = waitList.stream().filter(e -> e.getPartySize() <= partySize).toList().size();
        long countTables = tables.stream().filter(t -> t.getCapacity() >= partySize).count();
        if (countTables == 0) return -1;

        long groupsPerCycle = countTables;
        long cycles = (ahead + groupsPerCycle - 1) / groupsPerCycle;
        return cycles * seatingDuration.toMinutes();
    }

    public void completeMeal(Reservation res) {
        Table t = res.getAssignedTable();
        if (t != null) {
            t.clear();
            reservations.remove(res);
            System.out.println("Manually cleared table " + t.getTableId() + " for reservation " + res.getName());
        }
    }

    public void sendNotification(Object entry, String msg) {
        String name = (entry instanceof Reservation r) ? r.getName()
                     : (entry instanceof WaitListEntry w) ? w.getName()
                     : "Unknown";
        System.out.println("Notify " + name + ": " + msg);
    }

    private Table findBestFitTable(int partySize) {
        return tables.stream()
            .filter(t -> t.isAvailable(partySize))
            .min(Comparator.comparingInt(Table::getCapacity))
            .orElse(null);
    }
}
