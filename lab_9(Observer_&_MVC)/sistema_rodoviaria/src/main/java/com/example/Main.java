package com.example;

import com.example.controller.TicketController;
import com.example.model.Bus;
import com.example.view.CentralPanelView;
import com.example.view.KioskView;

public class Main {
    public static void main(String[] args) {
        try{
        
            Bus bus = new Bus(10);
            CentralPanelView centralPanelView = new CentralPanelView(bus);
            KioskView kioskView = new KioskView(bus);

            centralPanelView.setLocation(0, 0);
            kioskView.setLocation(centralPanelView.getWidth(), 0);

            bus.addSeatStatusChangeListener(centralPanelView);
            bus.addSeatStatusChangeListener(kioskView);

            TicketController controller = new TicketController(bus);

        
            Thread.sleep(2000);
            controller.reserveSeat(1);

            Thread.sleep(2000);
            controller.buySeat(2);

            Thread.sleep(2000);
            controller.reserveSeat(3);

            Thread.sleep(2000);
            controller.buySeat(3);


            Thread.sleep(7000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
