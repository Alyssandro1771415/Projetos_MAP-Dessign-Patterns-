import org.junit.jupiter.api.Test;

import com.example.model.Seat;
import com.example.model.SeatStatus;

import static org.junit.jupiter.api.Assertions.*;

class TesteSeat {

    @Test
    void testSeatInitialization() {
        int seatNumber = 1;
        SeatStatus initialStatus = SeatStatus.AVAILABLE;

        Seat seat = new Seat(seatNumber, initialStatus);

        assertEquals(seatNumber, seat.getNumber());
        assertEquals(initialStatus, seat.getStatus());
    }

    @Test
    void testSetStatus() {
        Seat seat = new Seat(1, SeatStatus.AVAILABLE);

        seat.setStatus(SeatStatus.RESERVED);
        assertEquals(SeatStatus.RESERVED, seat.getStatus());

        seat.setStatus(SeatStatus.UNAVAILABLE);
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());
    }
}
