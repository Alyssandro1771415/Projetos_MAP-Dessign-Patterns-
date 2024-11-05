package com.example.model;

import java.util.EventListener;

public interface SeatStatusChangeListener extends EventListener {
    void seatStatusChanged(SeatStatusChangeEvent event);
}
