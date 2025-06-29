/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurant;
import java.time.LocalDateTime;

/**
 *
 * @author Java
 */
 class Table{
            private int tableId, capacity;
            private boolean occupied = false;
            private Reservation currentReservation;
            
            Table(int tableId, int capacity, boolean occupied, Reservation currentReservation){
            
                this.currentReservation = currentReservation;
                this.capacity = capacity;
                this.tableId = tableId;
                this.occupied = occupied;
                
            }

    public int getTableId() {
        return tableId;
    }
              
          

            public boolean isAvailable(int partySize) {
             return !occupied && capacity >= partySize;
            }
 // method to assign a table to a customer
            public void assign(Reservation res){
                
              currentReservation = res;
              occupied = true;
              res.setReservation(Reservation.ReservationStatus.SEATED);
              res.setAssignedTable(this);
              res.setSeatTime(LocalDateTime.now());
                System.out.println("Seated " + res.getName()  + " (party of " + res.getPartySize() + ") at table " + tableId);
             
                
            }
            public void clear(){
            if(occupied && currentReservation != null){
                currentReservation.setReservation(Reservation.ReservationStatus.COMPLETED);
                currentReservation = null;
            }
            this.occupied = false;  
            }
        }


