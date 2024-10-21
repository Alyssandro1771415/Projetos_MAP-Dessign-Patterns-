import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ovos.Ovo;
import com.example.ovos.OvoCapoeira;

public class TesteOvoCapoeira {
 
    Ovo ovoCapoeira;

    @BeforeEach
    public void setUp(){

        ovoCapoeira = new OvoCapoeira();

    }

    @Test
    public void testGetTipo(){

        String stringExpected = "Ovo de Capoeira";
        String stringUnexpected = "Ovo de Granja";

        String tipoOvo = ovoCapoeira.getTipo();

        assertEquals(stringExpected, tipoOvo);
        assertNotEquals(stringUnexpected, tipoOvo);

    }

}
