package com.example.view;

import com.example.model.SeatStatusChangeEvent;
import com.example.model.SeatStatusChangeListener;
import com.example.model.Bus;
import com.example.model.Seat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KioskView extends JFrame implements SeatStatusChangeListener {
    private JTextArea textArea;
    private Bus bus;

    public KioskView(Bus bus) {

        if(bus == null){
            throw new IllegalArgumentException("The bus can`t be a null argument!");
        }
        if(bus.getSeats().size() < 0){
            throw new IllegalArgumentException("Seat number invalid, it must be a positive integer!");
        }

        this.bus = bus;

        setTitle("Quiosque");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(closeButton, BorderLayout.SOUTH);

        setVisible(true);

        updateSeatList();
    }

    @Override
    public void seatStatusChanged(SeatStatusChangeEvent event) {
        if(event == null){
            throw new IllegalArgumentException("The event of the update seat status ca`t be null!");
        }
        updateSeatList();
    }

    private void updateSeatList() {
        StringBuilder availableSeats = new StringBuilder("Disponíveis:\n");
        StringBuilder reservedSeats = new StringBuilder("Reservadas:\n");
        StringBuilder unavailableSeats = new StringBuilder("Indisponíveis:\n");

        for (Seat seat : bus.getSeats()) {

            if(seat == null){
                throw new IllegalArgumentException("The seat can`t be a null argument!");
            }

            switch (seat.getStatus()) {
                case AVAILABLE:
                    availableSeats.append("Assento ").append(seat.getNumber()).append("\n");
                    break;
                case RESERVED:
                    reservedSeats.append("Assento ").append(seat.getNumber()).append("\n");
                    break;
                case UNAVAILABLE:
                    unavailableSeats.append("Assento ").append(seat.getNumber()).append("\n");
                    break;
            }
        }

        textArea.setText("");
        textArea.append(availableSeats.toString());
        textArea.append("\n");
        textArea.append(reservedSeats.toString());
        textArea.append("\n");
        textArea.append(unavailableSeats.toString());
    }
}
