import com.example.model.*;
import com.example.view.CentralPanelView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TesteCentralPanelView {

    public Bus bus;
    public CentralPanelView centralPanelView;

    @BeforeEach
    void setUp() {
        bus = Mockito.mock(Bus.class);
        centralPanelView = new CentralPanelView(bus);
    }

    @Test
    void testSeatStatusChangedUpdatesView() {
        Seat seat1 = new Seat(1, SeatStatus.AVAILABLE);
        Seat seat2 = new Seat(2, SeatStatus.RESERVED);
        Seat seat3 = new Seat(3, SeatStatus.UNAVAILABLE);

        when(bus.getSeats()).thenReturn(Arrays.asList(seat1, seat2, seat3));

        SeatStatusChangeEvent event = new SeatStatusChangeEvent(1, SeatStatus.RESERVED);
        centralPanelView.seatStatusChanged(event);

        JTextPane textPane = getTextPane(centralPanelView);
        assertNotNull(textPane, "O componente JTextPane não deve ser nulo");

        // Arrays.asList(seat1, seat2, seat3)

        String textContent = textPane.getText();
        System.out.println(textContent);
        assertTrue(textContent.contains("</head>\n" + 
                        "  <body>\n" + 
                        "    <font color=\"green\">Assento 1: Dispon&#237;vel</font><br><font color=\"yellow\">Assento \n" + 
                        "    2: Reservado</font><br><font color=\"red\">Assento 3: Indispon&#237;vel</font><br>\n" + 
                        "  </body>\n" + 
                        "</html>"), textContent);
    }

    // Método auxiliar para acessar o JTextPane, pois ele é privado
    private JTextPane getTextPane(CentralPanelView view) {
        for (Component component : view.getContentPane().getComponents()) {
            if (component instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) component;
                if (scrollPane.getViewport().getView() instanceof JTextPane) {
                    return (JTextPane) scrollPane.getViewport().getView();
                }
            }
        }
        return null;
    }

    @Test
    void testCloseButtonDisposesWindow() {
        JButton closeButton = getCloseButton(centralPanelView);
        assertNotNull(closeButton);

        closeButton.doClick();

        assertFalse(centralPanelView.isDisplayable());
    }

    // Método auxiliar para acessar o JButton de fechar
    private JButton getCloseButton(CentralPanelView view) {
        for (Component component : view.getContentPane().getComponents()) {
            if (component instanceof JButton) {
                return (JButton) component;
            }
        }
        return null;
    }
}
