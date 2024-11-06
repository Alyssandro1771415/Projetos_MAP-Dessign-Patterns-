package com.example.controller;

import com.example.model.Bus;
import com.example.model.SeatStatus;

public class TicketController {
    private Bus bus;

    public TicketController(Bus bus) {
        this.bus = bus;
    }

    public void reserveSeat(int seatNumber) {
        if(seatNumber <= 0){
            throw new IllegalArgumentException("Seat number invalid, it must be a positive integer!");
        }
        if(seatNumber > bus.getSeats().size()){
            throw new IllegalArgumentException("Seat number invalid, must be within the number of seats");
        }
        
        bus.updateSeatStatus(seatNumber, SeatStatus.RESERVED);
    }

    public void buySeat(int seatNumber) {
        if(seatNumber <= 0){
            throw new IllegalArgumentException("Seat number invalid, it must be a positive integer!");
        }
        if(seatNumber > bus.getSeats().size()){
            throw new IllegalArgumentException("Seat number invalid, must be within the number of seats");
        }

        bus.updateSeatStatus(seatNumber, SeatStatus.UNAVAILABLE);
    }
}
