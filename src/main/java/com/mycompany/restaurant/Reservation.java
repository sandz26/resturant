/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurant;

import java.time.LocalDateTime;
import java.time.Duration;

/**
 *
 * @author Java
 */
public class Reservation {
    private LocalDateTime time;
    private int partySize;
    private String name;
    private ReservationStatus reservation;
    private Table assignedTable;
    private LocalDateTime seatTime;
    
    
    
    
    public enum ReservationStatus {
    WAITING, SEATED, COMPLETED, CANCELLED;
  }

    public Reservation(LocalDateTime time) {
        this.time = time;
        
       
        // ... other initializations
    }

    public String getName() {
        return name;
    }

    public int getPartySize() {
        return partySize;
    }

    public ReservationStatus getReservation() {
        return reservation;
    }
    
    

    public LocalDateTime getTime() {
        return time;
    }

    public LocalDateTime getSeatTime() {
        return seatTime;
    }

    public void setSeatTime(LocalDateTime seatTime) {
        this.seatTime = seatTime;
    }

    public void setReservation(ReservationStatus status) {
        this.reservation = status;
    }
    
    
    
    public void setAssignedTable(Table table) {
        this.assignedTable = table;
    }

    public Table getAssignedTable() {
        return assignedTable;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    // ... other methods
    public void confirm() {
    if (reservation == ReservationStatus.WAITING) {
        reservation = ReservationStatus.WAITING; // maybe switch to a CONFIRMED type if you add one
        System.out.println("Reservation for " + name + " at " + time + " confirmed.");
    }
    
}
public void seat(Table table) {
    this.assignedTable = table;
    this.reservation = ReservationStatus.SEATED;
    this.seatTime = LocalDateTime.now();
    System.out.println(name + " seated at table " + table.getTableId() + " at " + seatTime);
}
public void cancel() {
    this.reservation = ReservationStatus.CANCELLED;
    if (assignedTable != null) {
        assignedTable.clear(); // frees up the table
        this.assignedTable = null;
    }
    System.out.println(name + "'s reservation at " + time + " has been cancelled.");
}

public long getWaitTime() {
    if (seatTime != null) {
        Duration elapsed = Duration.between(seatTime, LocalDateTime.now());
        return elapsed.toMinutes();
    } else {
        Duration until = Duration.between(LocalDateTime.now(), time);
        return until.isNegative() ? 0 : until.toMinutes();
    }
}

}

