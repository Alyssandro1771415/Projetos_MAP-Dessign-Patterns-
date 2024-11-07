import org.junit.jupiter.api.Test;

import com.example.model.SeatStatus;
import com.example.model.SeatStatusChangeEvent;

import static org.junit.jupiter.api.Assertions.*;

class TesteSeatStatusChangeEvent {

    @Test
    void testSeatStatusChangeEventInitialization() {
        int seatNumber = 5;
        SeatStatus newStatus = SeatStatus.RESERVED;

        SeatStatusChangeEvent event = new SeatStatusChangeEvent(seatNumber, newStatus);

        assertEquals(seatNumber, event.getSeatNumber());
        assertEquals(newStatus, event.getNewStatus());
    }
}
