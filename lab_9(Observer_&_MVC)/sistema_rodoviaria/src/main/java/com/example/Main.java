package com.example;

import com.example.controller.TicketController;
import com.example.model.Bus;
import com.example.view.CentralPanelView;
import com.example.view.KioskView;

import java.awt.Toolkit;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(10);
        CentralPanelView centralPanelView = new CentralPanelView(bus);
        KioskView kioskView = new KioskView(bus);

        // Coloca as janelas lado a lado
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        centralPanelView.setLocation(0, 0);
        kioskView.setLocation(centralPanelView.getWidth(), 0);

        bus.addSeatStatusChangeListener(centralPanelView);
        bus.addSeatStatusChangeListener(kioskView);

        TicketController controller = new TicketController(bus);

        try {
            Thread.sleep(5000);
            controller.reserveSeat(1);

            Thread.sleep(5000);
            controller.buySeat(2);

            Thread.sleep(5000);
            controller.reserveSeat(3);

            Thread.sleep(5000);
            controller.buySeat(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
