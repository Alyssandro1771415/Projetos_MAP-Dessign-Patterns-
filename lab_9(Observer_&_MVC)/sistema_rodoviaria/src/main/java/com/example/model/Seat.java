package com.example.model;

public class Seat {
    private int number;
    private SeatStatus status;

    public Seat(int number, SeatStatus status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
