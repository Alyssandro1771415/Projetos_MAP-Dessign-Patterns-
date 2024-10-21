import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.queijos.Queijo;
import com.example.queijos.QueijoCheddar;


public class TesteQueijoCheddar {
 
    Queijo queijoCheddar;

    @BeforeEach
    public void setUp(){

        queijoCheddar = new QueijoCheddar();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Queijo Cheddar";
        String stringUnexpected1 = "Queijo Mussarela";
        String stringUnexpected2 = "Queijo Prato";

        String tipoQueijo = queijoCheddar.getTipo();

        assertEquals(stringExpected, tipoQueijo);
        assertNotEquals(stringUnexpected1, tipoQueijo);
        assertNotEquals(stringUnexpected2, tipoQueijo);

    }

}
