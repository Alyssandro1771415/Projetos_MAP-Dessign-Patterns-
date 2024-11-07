import com.example.model.*;
import com.example.view.KioskView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TesteKioskeView {

    public Bus bus;
    public KioskView kioskView;

    @BeforeEach
    void setUp() {
        bus = Mockito.mock(Bus.class);
        kioskView = new KioskView(bus);
    }

    @Test
    void testSeatStatusChangedUpdatesView() {
        Seat seat1 = new Seat(1, SeatStatus.AVAILABLE);
        Seat seat2 = new Seat(2, SeatStatus.RESERVED);
        Seat seat3 = new Seat(3, SeatStatus.UNAVAILABLE);

        when(bus.getSeats()).thenReturn(Arrays.asList(seat1, seat2, seat3));

        SeatStatusChangeEvent event = new SeatStatusChangeEvent(1, SeatStatus.RESERVED);
        kioskView.seatStatusChanged(event);

        JTextArea textArea = getTextArea(kioskView);
        assertNotNull(textArea, "O componente JTextArea não deve ser nulo");

        String textContent = textArea.getText();
        System.out.println(textContent);

        assertTrue(textContent.contains("Disponíveis:\nAssento 1\n"));
        assertTrue(textContent.contains("Reservadas:\nAssento 2\n"));
        assertTrue(textContent.contains("Indisponíveis:\nAssento 3\n"));
    }

    // Método auxiliar para acessar o JTextArea, pois ele é privado
    private JTextArea getTextArea(KioskView view) {
        for (Component component : view.getContentPane().getComponents()) {
            if (component instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) component;
                if (scrollPane.getViewport().getView() instanceof JTextArea) {
                    return (JTextArea) scrollPane.getViewport().getView();
                }
            }
        }
        return null;
    }

    @Test
    void testCloseButtonDisposesWindow() {
        JButton closeButton = getCloseButton(kioskView);
        assertNotNull(closeButton);

        closeButton.doClick();

        assertFalse(kioskView.isDisplayable());
    }

    // Método auxiliar para acessar o JButton de fechar
    private JButton getCloseButton(KioskView view) {
        for (Component component : view.getContentPane().getComponents()) {
            if (component instanceof JButton) {
                return (JButton) component;
            }
        }
        return null;
    }
}
