package com.example.model;

public class SeatStatusChangeEvent {
    private int seatNumber;
    private SeatStatus newStatus;

    public SeatStatusChangeEvent(int seatNumber, SeatStatus newStatus) {
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

