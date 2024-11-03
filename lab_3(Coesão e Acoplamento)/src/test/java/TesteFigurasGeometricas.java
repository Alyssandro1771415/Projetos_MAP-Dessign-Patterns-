import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.FigurasGeometricas;

public class TesteFigurasGeometricas {
    
    @Test
    void testFigurasGeometricas() {
        FigurasGeometricas figuras = new FigurasGeometricas(2, 3, 4, 5);

        assertEquals(2.0, figuras.getRetangulo().getAltura());
        assertEquals(3.0, figuras.getRetangulo().getLargura());

        assertEquals(4.0, figuras.getQuadrado().getLargura());
        assertEquals(5.0, figuras.getCirculo().getRaio());
    }

    @Test
    void testFigurasGeometricasNegativas() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FigurasGeometricas(-2, 3, 4, 5);
        });
        assertEquals("Valores negativos inválidos.", exception.getMessage());
    }

}
