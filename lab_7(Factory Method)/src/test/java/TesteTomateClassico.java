import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.tomate.Tomate;
import com.example.tomate.TomateTradicional;

public class TesteTomateClassico {
 
    Tomate tomateTradicional;

    @BeforeEach
    public void setUp(){

        tomateTradicional = new TomateTradicional();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Tomate Tradicional";
        String stringUnexpected = "Tomate";

        String tipoTomate = tomateTradicional.getTipo();

        assertEquals(stringExpected, tipoTomate);
        assertNotEquals(stringUnexpected, tipoTomate);

    }

}
