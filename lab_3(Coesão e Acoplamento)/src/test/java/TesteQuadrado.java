import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.Quadrado;

public class TesteQuadrado {
        @Test
    void testCalcularArea() {
        Quadrado quadrado = new Quadrado(2.0);
        assertEquals(4.0, quadrado.calcularArea());
    }

    @Test
    void testCalcularPerimetro() {
        Quadrado quadrado = new Quadrado(2.0);
        assertEquals(8.0, quadrado.calcularPerimetro());
    }

    @Test
    void testLadoNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Quadrado(-2.0);
        });
        assertEquals("Valores negativos inválidos.", exception.getMessage());
    }
}
