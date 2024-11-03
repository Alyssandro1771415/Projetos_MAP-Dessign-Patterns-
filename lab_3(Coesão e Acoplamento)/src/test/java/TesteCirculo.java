import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.Circulo;

public class TesteCirculo {
        @Test
    void testCalcularArea() {
        Circulo circulo = new Circulo(2.0);
        assertEquals(Math.PI * 4, circulo.calcularArea());
    }

    @Test
    void testCalcularPerimetro() {
        Circulo circulo = new Circulo(2.0);
        assertEquals(2 * Math.PI * 2, circulo.calcularPerimetro());
    }

    @Test
    void testRaioNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(-1.0);
        });
        assertEquals("O raio não pode ser negativo.", exception.getMessage());
    }

    @Test
    void testSetRaioNegativo() {
        Circulo circulo = new Circulo(2.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            circulo.setRaio(-2.0);
        });
        assertEquals("O raio não pode ser negativo.", exception.getMessage());
    }
}
