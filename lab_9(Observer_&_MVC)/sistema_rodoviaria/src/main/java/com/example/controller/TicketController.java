package com.example.controller;

import com.example.model.Bus;
import com.example.model.SeatStatus;

public class TicketController {
    private Bus bus;

    public TicketController(Bus bus) {
        this.bus = bus;
    }

    public void reserveSeat(int seatNumber) {
        bus.updateSeatStatus(seatNumber, SeatStatus.RESERVED);
    }

    public void buySeat(int seatNumber) {
        bus.updateSeatStatus(seatNumber, SeatStatus.UNAVAILABLE);
    }
}
