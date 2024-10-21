import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.presunto.Presunto;
import com.example.presunto.PresuntoPeru;


public class TestePresuntoPeru {
 
    Presunto presuntoPeru;

    @BeforeEach
    public void setUp(){

        presuntoPeru = new PresuntoPeru();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Presunto de Peru";
        String stringUnexpected = "Presunto de Frango";

        String tipoPresunto = presuntoPeru.getTipo();

        assertEquals(stringExpected, tipoPresunto);
        assertNotEquals(stringUnexpected, tipoPresunto);

    }

}
