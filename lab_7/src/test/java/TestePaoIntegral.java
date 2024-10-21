import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.paes.Pao;
import com.example.paes.PaoIntegral;

public class TestePaoIntegral {
 
    Pao paoIntegral;

    @BeforeEach
    public void setUp(){

        paoIntegral = new PaoIntegral();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Pão Integral";
        String stringUnexpected1 = "Pão Bola";
        String stringUnexpected2 = "Pão Francês";

        String tipoPao = paoIntegral.getTipo();

        assertEquals(stringExpected, tipoPao);
        assertNotEquals(stringUnexpected1, tipoPao);
        assertNotEquals(stringUnexpected2, tipoPao);

    }

}
