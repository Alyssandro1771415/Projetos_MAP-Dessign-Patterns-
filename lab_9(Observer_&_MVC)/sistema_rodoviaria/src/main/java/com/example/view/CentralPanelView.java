package com.example.view;

import com.example.model.SeatStatusChangeEvent;
import com.example.model.SeatStatusChangeListener;
import com.example.model.Seat;
import com.example.model.Bus;
import com.example.model.SeatStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CentralPanelView extends JFrame implements SeatStatusChangeListener {
    private JTextPane textPane;
    private Bus bus;

    public CentralPanelView(Bus bus) {
        this.bus = bus;

        setTitle("Painel Central");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);

        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setContentType("text/html");
        textPane.setBackground(Color.BLACK);
        add(new JScrollPane(textPane), BorderLayout.CENTER);

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(closeButton, BorderLayout.SOUTH);

        setVisible(true);

        // Atualiza a exibição inicial
        updateSeatList();
    }

    @Override
    public void seatStatusChanged(SeatStatusChangeEvent event) {
        updateSeatList();
    }

    private void updateSeatList() {
        StringBuilder seatList = new StringBuilder();

        for (Seat seat : bus.getSeats()) {
            switch (seat.getStatus()) {
                case AVAILABLE:
                    seatList.append("<font color='green'>Assento ").append(seat.getNumber()).append(": Disponível</font><br>");
                    break;
                case RESERVED:
                    seatList.append("<font color='yellow'>Assento ").append(seat.getNumber()).append(": Reservado</font><br>");
                    break;
                case UNAVAILABLE:
                    seatList.append("<font color='red'>Assento ").append(seat.getNumber()).append(": Indisponível</font><br>");
                    break;
            }
        }

        textPane.setText("<html>" + seatList.toString() + "</html>");
    }
}
