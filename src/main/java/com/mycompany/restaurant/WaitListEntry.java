package com.mycompany.restaurant;

import java.time.LocalDateTime;

public class WaitListEntry {
    private final String name;
    private final int partySize;
    private final LocalDateTime arrivalTime;

    public WaitListEntry(String name, int partySize, LocalDateTime arrivalTime) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (partySize <= 0) throw new IllegalArgumentException("Party size must be positive");

        this.name = name;
        this.partySize = partySize;
        this.arrivalTime = arrivalTime != null ? arrivalTime : LocalDateTime.now();
    }

    public String getName() { return name; }
    public int getPartySize() { return partySize; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }

    
    public long getWaitTimeMinutes() {
        return java.time.Duration.between(arrivalTime, LocalDateTime.now()).toMinutes();
    }

    @Override
    public String toString() {
        return name + " (party of " + partySize + ") – waiting for " +
               getWaitTimeMinutes() + " min";
    }
}
