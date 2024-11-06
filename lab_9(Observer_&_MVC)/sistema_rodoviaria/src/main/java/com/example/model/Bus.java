package com.example.model;

import java.util.ArrayList;
import java.util.List;


public class Bus {
    private List<Seat> seats;
    private List<SeatStatusChangeListener> listeners = new ArrayList<>();

    public Bus(int numberOfSeats) {
        seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(i, SeatStatus.AVAILABLE));
        }
    }

    public void addSeatStatusChangeListener(SeatStatusChangeListener listener) {
        listeners.add(listener);
    }

    public void removeSeatStatusChangeListener(SeatStatusChangeListener listener) {
        listeners.remove(listener);
    }

    public void updateSeatStatus(int seatNumber, SeatStatus newStatus) {
        Seat seat = seats.get(seatNumber - 1);
        seat.setStatus(newStatus);
        notifySeatStatusChange(seatNumber, newStatus);
    }

    private void notifySeatStatusChange(int seatNumber, SeatStatus newStatus) {
        SeatStatusChangeEvent event = new SeatStatusChangeEvent(seatNumber, newStatus);
        for (SeatStatusChangeListener listener : listeners) {
            listener.seatStatusChanged(event);
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<SeatStatusChangeListener> getListeners(){

        return this.listeners;

    }
}
