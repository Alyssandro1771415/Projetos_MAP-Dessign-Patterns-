import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ovos.Ovo;
import com.example.ovos.OvoGranja;

public class TesteOvoGranja {
 
    Ovo ovoGranja;

    @BeforeEach
    public void setUp(){

        ovoGranja = new OvoGranja();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Ovo de Granja";
        String stringUnexpected = "Ovo de Capoeira";

        String tipoOvo = ovoGranja.getTipo();

        assertEquals(stringExpected, tipoOvo);
        assertNotEquals(stringUnexpected, tipoOvo);

    }

}
