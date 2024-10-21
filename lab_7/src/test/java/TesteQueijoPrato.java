import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.queijos.Queijo;
import com.example.queijos.QueijoPrato;;


public class TesteQueijoPrato {
 
    Queijo queijoPrato;

    @BeforeEach
    public void setUp(){

        queijoPrato = new QueijoPrato();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Queijo Prato";
        String stringUnexpected1 = "Queijo Mussarela";
        String stringUnexpected2 = "Queijo Cheddar";

        String tipoQueijo = queijoPrato.getTipo();

        assertEquals(stringExpected, tipoQueijo);
        assertNotEquals(stringUnexpected1, tipoQueijo);
        assertNotEquals(stringUnexpected2, tipoQueijo);

    }

}
