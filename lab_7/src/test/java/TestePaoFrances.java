import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.paes.Pao;
import com.example.paes.PaoFrances;

public class TestePaoFrances {
 
    Pao paoFrances;

    @BeforeEach
    public void setUp(){

        paoFrances = new PaoFrances();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Pão Francês";
        String stringUnexpected1 = "Pão Integral";
        String stringUnexpected2 = "Pão Bola";

        String tipoPao = paoFrances.getTipo();

        assertEquals(stringExpected, tipoPao);
        assertNotEquals(stringUnexpected1, tipoPao);
        assertNotEquals(stringUnexpected2, tipoPao);

    }

}
