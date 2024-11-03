import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab_4.Ator;
import lab_4.Camera;
import lab_4.Cinegrafista;
import lab_4.Diretor;
import lab_4.Produtor;
import lab_4.Roteirista;

public class TesteFuncoes {

    Ator Matheus_Nachtergaele;
    Camera Daniel_Andrade;
    Cinegrafista Santaninha;
    Diretor Carlos_Henrique;
    Produtor Denis_Castro;
    Roteirista Rosane_Svartman;

    @BeforeEach
    public void setup(){
        
        Matheus_Nachtergaele = new Ator();
        Daniel_Andrade = new Camera();
        Santaninha = new Cinegrafista();
        Carlos_Henrique = new Diretor();
        Denis_Castro = new Produtor();
        Rosane_Svartman = new Roteirista();

    }

    @Test
    void testGetDescricaoAssertTrue(){

        assertEquals("Ator", Matheus_Nachtergaele.getDescricao());
        assertEquals("Camera", Daniel_Andrade.getDescricao());
        assertEquals("Cinegrafista", Santaninha.getDescricao());
        assertEquals("Diretor", Carlos_Henrique.getDescricao());
        assertEquals("Produtor", Denis_Castro.getDescricao());
        assertEquals("Roteirista", Rosane_Svartman.getDescricao());

    }

    @Test 
    public void testGetDescricaoAsserFalse(){

        assertNotEquals("Camera", Matheus_Nachtergaele.getDescricao());
        assertNotEquals("Cinegrafista", Matheus_Nachtergaele.getDescricao());
        assertNotEquals("Diretor", Matheus_Nachtergaele.getDescricao());
        assertNotEquals("Produtor", Matheus_Nachtergaele.getDescricao());
        assertNotEquals("Roteirista", Matheus_Nachtergaele.getDescricao());

        assertNotEquals("Ator", Daniel_Andrade.getDescricao());
        assertNotEquals("Cinegrafista", Daniel_Andrade.getDescricao());
        assertNotEquals("Diretor", Daniel_Andrade.getDescricao());
        assertNotEquals("Produtor", Daniel_Andrade.getDescricao());
        assertNotEquals("Roteirista", Daniel_Andrade.getDescricao());        

        assertNotEquals("Ator", Santaninha.getDescricao());
        assertNotEquals("Diretor", Santaninha.getDescricao());
        assertNotEquals("Camera", Santaninha.getDescricao());
        assertNotEquals("Produtor", Santaninha.getDescricao());
        assertNotEquals("Roteirista", Santaninha.getDescricao());

        assertNotEquals("Ator", Carlos_Henrique.getDescricao());
        assertNotEquals("Cinegrafista", Carlos_Henrique.getDescricao());
        assertNotEquals("Camera", Carlos_Henrique.getDescricao());
        assertNotEquals("Produtor", Carlos_Henrique.getDescricao());
        assertNotEquals("Roteirista", Carlos_Henrique.getDescricao());

        assertNotEquals("Ator", Denis_Castro.getDescricao());
        assertNotEquals("Diretor", Denis_Castro.getDescricao());
        assertNotEquals("Camera", Denis_Castro.getDescricao());
        assertNotEquals("Cinegrafista", Denis_Castro.getDescricao());
        assertNotEquals("Roteirista", Denis_Castro.getDescricao());

        assertNotEquals("Ator", Rosane_Svartman.getDescricao());
        assertNotEquals("Diretor", Rosane_Svartman.getDescricao());
        assertNotEquals("Camera", Rosane_Svartman.getDescricao());
        assertNotEquals("Produtor", Rosane_Svartman.getDescricao());
        assertNotEquals("Cinegrafista", Rosane_Svartman.getDescricao());

    }

}
