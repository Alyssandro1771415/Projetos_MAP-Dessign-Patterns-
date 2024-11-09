package com.example.model;

public class SeatStatusChangeEvent {
    private int seatNumber;
    private SeatStatus newStatus;

    public SeatStatusChangeEvent(int seatNumber, SeatStatus newStatus) {
        if(seatNumber <= 0){
            throw new IllegalArgumentException("Seat number invalid, it must be a positive integer!");
        } 
        if(newStatus == null){
            throw new IllegalArgumentException("Seat status can`t be null");
        }
        this.seatNumber = seatNumber;
        this.newStatus = newStatus;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getNewStatus() {
        return newStatus;
    }
}
