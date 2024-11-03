import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.paes.Pao;
import com.example.paes.PaoBola;

public class testePaoBola {
 
    Pao paoBola;

    @BeforeEach
    public void setUp(){

        paoBola = new PaoBola();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Pão Bola";
        String stringUnexpected1 = "Pão Integral";
        String stringUnexpected2 = "Pão Francês";

        String tipoPao = paoBola.getTipo();

        assertEquals(stringExpected, tipoPao);
        assertNotEquals(stringUnexpected1, tipoPao);
        assertNotEquals(stringUnexpected2, tipoPao);

    }

}
