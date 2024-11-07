import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.example.model.Bus;
import com.example.model.Seat;
import com.example.model.SeatStatus;
import com.example.model.SeatStatusChangeEvent;
import com.example.model.SeatStatusChangeListener;

class TesteBus {
    private Bus bus;
    private SeatStatusChangeListener listener;

    @BeforeEach
    void setUp() {
        bus = new Bus(3);
        listener = Mockito.mock(SeatStatusChangeListener.class); // Usamos Mockito para criar um mock do listener
        bus.addSeatStatusChangeListener(listener);
    }

    @Test
    void testInitialSeatStatus() {
        // Verifica se todos os assentos são inicializados e se estão disponíveis disponíveis
        for (Seat seat : bus.getSeats()) {
            assertEquals(SeatStatus.AVAILABLE, seat.getStatus(), 
                         "Todos os assentos devem ser inicialmente disponíveis");
        }
    }
 
    // Quando testo esse acabo por consequencia testando o addSeatStatusChangeListener
    // já que os status serão atualizados apenas se estiverem tiverem sido adicionados
    @Test
    void testUpdateSeatStatus() {
        int seatNumber = 1;
        SeatStatus newStatus = SeatStatus.RESERVED;
    
        bus.updateSeatStatus(seatNumber, newStatus);
    
        // Captura o evento que foi enviado para o listener
        ArgumentCaptor<SeatStatusChangeEvent> eventCaptor = ArgumentCaptor.forClass(SeatStatusChangeEvent.class);
        Mockito.verify(listener).seatStatusChanged(eventCaptor.capture());
    
        // Obtém o evento capturado e verifica os atributos
        SeatStatusChangeEvent capturedEvent = eventCaptor.getValue();
        assertEquals(seatNumber, capturedEvent.getSeatNumber());
        assertEquals(newStatus, capturedEvent.getNewStatus());
    }
    

    @Test
    void testRemoveSeatStatusChangeListener() {
        // Remove o listener e verifica se ele não é notificado após a remoção
        bus.removeSeatStatusChangeListener(listener);
        
        int seatNumber = 2;
        SeatStatus newStatus = SeatStatus.UNAVAILABLE;
        
        bus.updateSeatStatus(seatNumber, newStatus);
        
        // Como o listener foi removido, ele não deve ser notificado
        Mockito.verify(listener, Mockito.never()).seatStatusChanged(Mockito.any(SeatStatusChangeEvent.class));
    }
}
