import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.presunto.Presunto;
import com.example.presunto.PresuntoFrango;


public class TestePresuntoFrango {
 
    Presunto presuntoFrango;

    @BeforeEach
    public void setUp(){

        presuntoFrango = new PresuntoFrango();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Presunto de Frango";
        String stringUnexpected = "Presunto de Peru";

        String tipoPresunto = presuntoFrango.getTipo();

        assertEquals(stringExpected, tipoPresunto);
        assertNotEquals(stringUnexpected, tipoPresunto);

    }

}
