import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.Bus;
import com.example.model.SeatStatus;
import com.example.model.SeatStatusChangeEvent;
import com.example.model.SeatStatusChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TesteBus {

    private Bus bus;
    private SeatStatusChangeListener listenerMock;

    @BeforeEach
    void setUp() {
        bus = new Bus(5); // criando um ônibus com 5 assentos para o teste
        listenerMock = mock(SeatStatusChangeListener.class); // criando um mock do listener
    }

    @Test
    void testAddSeatStatusChangeListener() {
        bus.addSeatStatusChangeListener(listenerMock);
        assertTrue(bus.getListeners().contains(listenerMock), "O listener deve estar na lista após ser adicionado");
    }

    @Test
    void testRemoveSeatStatusChangeListener() {
        bus.addSeatStatusChangeListener(listenerMock);
        bus.removeSeatStatusChangeListener(listenerMock);
        assertFalse(bus.getListeners().contains(listenerMock), "O listener não deve estar na lista após ser removido");
    }

    @Test
    void testUpdateSeatStatus() {
        bus.addSeatStatusChangeListener(listenerMock);

        int seatNumber = 1;
        SeatStatus newStatus = SeatStatus.RESERVED;
        
        bus.updateSeatStatus(seatNumber, newStatus);

        assertEquals(newStatus, bus.getSeats().get(seatNumber - 1).getStatus(), "O status do assento deve ser atualizado para o novo status");

        verify(listenerMock, times(1)).seatStatusChanged(any(SeatStatusChangeEvent.class));
    }
}
