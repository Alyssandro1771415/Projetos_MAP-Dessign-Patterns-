import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.queijos.Queijo;
import com.example.queijos.QueijoMussarela;;


public class TesteQueijoMussarela {
 
    Queijo queijoMussarela;

    @BeforeEach
    public void setUp(){

        queijoMussarela = new QueijoMussarela();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Queijo Mussarela";
        String stringUnexpected1 = "Queijo Prato";
        String stringUnexpected2 = "Queijo Cheddar";

        String tipoQueijo = queijoMussarela.getTipo();

        assertEquals(stringExpected, tipoQueijo);
        assertNotEquals(stringUnexpected1, tipoQueijo);
        assertNotEquals(stringUnexpected2, tipoQueijo);

    }

}
