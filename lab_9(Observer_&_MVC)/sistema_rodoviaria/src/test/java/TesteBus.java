import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.controller.TicketController;
import com.example.model.Bus;
import com.example.view.CentralPanelView;
import com.example.view.KioskView;

public class TesteBus {
    
    Bus onibus;
    TicketController controlePassagens;
    CentralPanelView painel;
    KioskView kiosk;

    @BeforeEach
    public void setUp(){

        onibus = new Bus(5);
        controlePassagens = new TicketController(onibus);
        painel = new CentralPanelView(onibus);
        kiosk = new KioskView(onibus);

    }

    @Test
    public void testAddSeatStatusChangeListener(){



    }

    @Test
    public void testRemoveSeatStatusEventListener(){



    }

    @Test
    public void testUpdateStatus(){



    }

    @Test 
    public void testNotifySeatStatusChange(){



    }

    @Test
    public void testGetSeats(){



    }

}
