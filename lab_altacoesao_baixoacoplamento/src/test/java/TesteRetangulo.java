import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.Retangulo;

public class TesteRetangulo {
        @Test
    void testCalcularArea() {
        Retangulo retangulo = new Retangulo(2.0, 3.0);
        assertEquals(6.0, retangulo.calcularArea());
    }

    @Test
    void testCalcularPerimetro() {
        Retangulo retangulo = new Retangulo(2.0, 3.0);
        assertEquals(10.0, retangulo.calcularPerimetro());
    }

    @Test
    void testLarguraNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo(-2.0, 3.0);
        });
        assertEquals("Valores negativos inválidos.", exception.getMessage());
    }

    @Test
    void testAlturaNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo(2.0, -3.0);
        });
        assertEquals("Valores negativos inválidos.", exception.getMessage());
    }
}
