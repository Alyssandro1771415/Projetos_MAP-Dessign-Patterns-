package com.example.model;

import java.util.ArrayList;
import java.util.List;


public class Bus {
    private List<Seat> seats;
    private List<SeatStatusChangeListener> listeners = new ArrayList<>();

    public Bus(int numberOfSeats) {

        if(numberOfSeats <= 0){
            throw new IllegalArgumentException("Seat number invalid, it must be a positive integer!");
        }
        seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(i, SeatStatus.AVAILABLE));
        }
    }

    public void addSeatStatusChangeListener(SeatStatusChangeListener listener) {
    
        if(listener == null || listeners.contains(listener)){
            throw new IllegalArgumentException("The listener can't null or be added before!");
        }
    
        listeners.add(listener);
    }

    public void removeSeatStatusChangeListener(SeatStatusChangeListener listener) {

        if(listener == null || !listeners.contains(listener)){
            throw new IllegalArgumentException("The listener can't null or be added before!");
        }

        listeners.remove(listener);
    }

    public void updateSeatStatus(int seatNumber, SeatStatus newStatus) {
        if (seatNumber < 1 || seatNumber > seats.size()) {
            throw new IllegalArgumentException("Seats number invalid: " + seatNumber);
        }
        if (newStatus == null) {
            throw new IllegalArgumentException("Seat status can't be null.");
        }

        Seat seat = seats.get(seatNumber - 1);

        if (seat.getStatus() == newStatus) {
            throw new IllegalStateException("Seat already in status: " + newStatus);
        }
        seat.setStatus(newStatus);
        notifySeatStatusChange(seatNumber, newStatus);
    }

    private void notifySeatStatusChange(int seatNumber, SeatStatus newStatus) {

        if(seatNumber <= 0 ){
            throw new IllegalArgumentException("seatNumber invalid, it must be a positive integer!");
        }
        if(newStatus == null ){
            throw new IllegalArgumentException("Status can't be null!");
        }

        SeatStatusChangeEvent event = new SeatStatusChangeEvent(seatNumber, newStatus);
        for (SeatStatusChangeListener listener : listeners) {
            listener.seatStatusChanged(event);
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
