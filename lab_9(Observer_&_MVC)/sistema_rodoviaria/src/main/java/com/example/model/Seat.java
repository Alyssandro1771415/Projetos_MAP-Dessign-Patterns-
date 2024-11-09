package com.example.model;

public class Seat {
    private int number;
    private SeatStatus status;

    public Seat(int number, SeatStatus status) {
        if(number <= 0){
            throw new IllegalArgumentException("Seat number invalid, it must be a positive integer!");
        } 
        if(status == null){
            throw new IllegalArgumentException("Seat status can`t be null");
        }
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
