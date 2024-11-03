import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Sanduiche;
import com.example.Sanduiche1;
import com.example.ovos.Ovo;
import com.example.ovos.OvoCapoeira;
import com.example.paes.Pao;
import com.example.paes.PaoIntegral;
import com.example.presunto.Presunto;
import com.example.presunto.PresuntoFrango;
import com.example.queijos.Queijo;
import com.example.queijos.QueijoPrato;
import com.example.tomate.Tomate;
import com.example.tomate.TomateTradicional;

public class TesteSanduiche1 {
    
    Sanduiche sanduiche_tipo1;
    Pao pao_sanduiche;
    Presunto presunto_sanduiche;
    Queijo queijo_sanduiche;
    Ovo ovo_sanduiche;
    Tomate tomate_sanduiche;

    @BeforeEach
    public void setUp(){

        sanduiche_tipo1 = new Sanduiche1();
        pao_sanduiche = new PaoIntegral();
        presunto_sanduiche = new PresuntoFrango();
        queijo_sanduiche = new QueijoPrato();
        ovo_sanduiche = new OvoCapoeira();
        tomate_sanduiche = new TomateTradicional();

    }

    @Test
    public void TesteCriarPao(){

        Pao pao_sanduiche1 = sanduiche_tipo1.criaPao();

        String tipo_pao_sanduiche = pao_sanduiche1.getTipo();
        String tipo_pao_expected = pao_sanduiche.getTipo();

        assertEquals(tipo_pao_expected, tipo_pao_sanduiche);

    }
    @Test
    public void TesteCriarOvo(){

        Ovo ovo_sanduiche1 = sanduiche_tipo1.criaOvo();

        String tipo_ovo_sanduiche = ovo_sanduiche1.getTipo();
        String tipo_pao_expected = ovo_sanduiche.getTipo();

        assertEquals(tipo_pao_expected, tipo_ovo_sanduiche);

    }
    @Test
    public void TesteCriarPresunto(){
        Presunto presunto_sanduiche1 = sanduiche_tipo1.criaPresunto();

        String tipo_presunto_sanduiche = presunto_sanduiche1.getTipo();
        String tipo_presunto_expected = presunto_sanduiche.getTipo();

        assertEquals(tipo_presunto_expected, tipo_presunto_sanduiche);
    }
    @Test
    public void TesteCriarQueijo(){
        Queijo queijo_sanduiche1 = sanduiche_tipo1.criaQueijo();

        String tipo_queijo_sanduiche = queijo_sanduiche1.getTipo();
        String tipo_queijo_expected = queijo_sanduiche.getTipo();

        assertEquals(tipo_queijo_expected, tipo_queijo_sanduiche);
    }

    @Test
    public void TesteCriarTomate(){
        Tomate tomate_sanduiche1 = sanduiche_tipo1.criarTomate();

        String tipo_tomate_sanduiche = tomate_sanduiche1.getTipo();
        String tipo_tomate_expected = tomate_sanduiche.getTipo();

        assertEquals(tipo_tomate_expected, tipo_tomate_sanduiche);
    }
    
    @Test
    public void TesteMontarSanduiche(){
        String sanduiche_montado = sanduiche_tipo1.montaSanduiche();

        String sanduiche_expected = String.format("Sanduíche com: %s, %s, %s, %s e %s.", pao_sanduiche.getTipo(), queijo_sanduiche.getTipo(), presunto_sanduiche.getTipo(), ovo_sanduiche.getTipo(), tomate_sanduiche.getTipo());

        assertEquals(sanduiche_expected, sanduiche_montado);

    }

}
