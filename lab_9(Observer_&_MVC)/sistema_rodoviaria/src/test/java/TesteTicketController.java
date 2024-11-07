import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.controller.TicketController;
import com.example.model.Bus;
import com.example.model.Seat;
import com.example.model.SeatStatus;

public class TesteTicketController {

    Bus onibus;
    TicketController controleDePassagem;

    @BeforeEach
    public void setUp(){

        onibus = new Bus(5);    
        controleDePassagem = new TicketController(onibus);

    }


    @Test
    public void TestReserveSeat(){

        List<Seat> assentos = onibus.getSeats();

        // Verifico se todos começam liberados
        for(Seat s : assentos){

            assertEquals(SeatStatus.AVAILABLE, s.getStatus());

        }

        controleDePassagem.reserveSeat(assentos.get(0).getNumber());
        controleDePassagem.reserveSeat(assentos.get(3).getNumber());
        
        // Verifico se foram devidamente reservados
        assertEquals(SeatStatus.RESERVED, assentos.get(0).getStatus());
        assertEquals(SeatStatus.RESERVED, assentos.get(3).getStatus());
        
        // Verifico se não estão nos demais estados
        assertNotEquals(SeatStatus.AVAILABLE, assentos.get(0).getStatus());
        assertNotEquals(SeatStatus.AVAILABLE, assentos.get(3).getStatus());
        assertNotEquals(SeatStatus.UNAVAILABLE, assentos.get(0).getStatus());
        assertNotEquals(SeatStatus.UNAVAILABLE, assentos.get(3).getStatus());

        // Verifico o status dos demais
        assertEquals(SeatStatus.AVAILABLE, assentos.get(1).getStatus());
        assertEquals(SeatStatus.AVAILABLE, assentos.get(2).getStatus());
        assertEquals(SeatStatus.AVAILABLE, assentos.get(4).getStatus());

    }

    @Test
    public void TestBuySeat(){

        List<Seat> assentos = onibus.getSeats();

        // Verifico se todos começam liberados
        for(Seat s : assentos){

            assertEquals(SeatStatus.AVAILABLE, s.getStatus());

        }

        controleDePassagem.buySeat(assentos.get(0).getNumber());
        controleDePassagem.buySeat(assentos.get(3).getNumber());
        
        // Verifico se foram devidamente comprados
        assertEquals(SeatStatus.UNAVAILABLE, assentos.get(0).getStatus());
        assertEquals(SeatStatus.UNAVAILABLE, assentos.get(3).getStatus());
        
        // Verifico se não estão nos demais estados
        assertNotEquals(SeatStatus.AVAILABLE, assentos.get(0).getStatus());
        assertNotEquals(SeatStatus.AVAILABLE, assentos.get(3).getStatus());
        assertNotEquals(SeatStatus.RESERVED, assentos.get(0).getStatus());
        assertNotEquals(SeatStatus.RESERVED, assentos.get(3).getStatus());

        // Verifico o status dos demais
        assertEquals(SeatStatus.AVAILABLE, assentos.get(1).getStatus());
        assertEquals(SeatStatus.AVAILABLE, assentos.get(2).getStatus());
        assertEquals(SeatStatus.AVAILABLE, assentos.get(4).getStatus()); 

    }

}
