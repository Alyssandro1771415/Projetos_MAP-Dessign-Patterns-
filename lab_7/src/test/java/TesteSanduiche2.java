import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Sanduiche;
import com.example.Sanduiche2;
import com.example.ovos.Ovo;
import com.example.ovos.OvoGranja;
import com.example.paes.Pao;
import com.example.paes.PaoFrances;
import com.example.presunto.Presunto;
import com.example.presunto.PresuntoPeru;
import com.example.queijos.Queijo;
import com.example.queijos.QueijoMussarela;
import com.example.tomate.Tomate;
import com.example.tomate.TomateTradicional;

public class TesteSanduiche2 {
    
    Sanduiche sanduiche_tipo2;
    Pao pao_sanduiche;
    Presunto presunto_sanduiche;
    Queijo queijo_sanduiche;
    Ovo ovo_sanduiche;
    Tomate tomate_sanduiche;

    @BeforeEach
    public void setUp(){

        sanduiche_tipo2 = new Sanduiche2();
        pao_sanduiche = new PaoFrances();
        presunto_sanduiche = new PresuntoPeru();
        queijo_sanduiche = new QueijoMussarela();
        ovo_sanduiche = new OvoGranja();
        tomate_sanduiche = new TomateTradicional();

    }

    @Test
    public void TesteCriarPao(){

        Pao pao_sanduiche2 = sanduiche_tipo2.criaPao();

        String tipo_pao_sanduiche = pao_sanduiche2.getTipo();
        String tipo_pao_expected = pao_sanduiche.getTipo();

        assertEquals(tipo_pao_expected, tipo_pao_sanduiche);

    }
    @Test
    public void TesteCriarOvo(){

        Ovo ovo_sanduiche2 = sanduiche_tipo2.criaOvo();

        String tipo_ovo_sanduiche = ovo_sanduiche2.getTipo();
        String tipo_pao_expected = ovo_sanduiche.getTipo();

        assertEquals(tipo_pao_expected, tipo_ovo_sanduiche);

    }
    @Test
    public void TesteCriarPresunto(){
        Presunto presunto_sanduiche2 = sanduiche_tipo2.criaPresunto();

        String tipo_presunto_sanduiche = presunto_sanduiche2.getTipo();
        String tipo_presunto_expected = presunto_sanduiche.getTipo();

        assertEquals(tipo_presunto_expected, tipo_presunto_sanduiche);
    }
    @Test
    public void TesteCriarQueijo(){
        Queijo queijo_sanduiche2 = sanduiche_tipo2.criaQueijo();

        String tipo_queijo_sanduiche = queijo_sanduiche2.getTipo();
        String tipo_queijo_expected = queijo_sanduiche.getTipo();

        assertEquals(tipo_queijo_expected, tipo_queijo_sanduiche);
    }

    @Test
    public void TesteCriarTomate(){
        Tomate tomate_sanduiche2 = sanduiche_tipo2.criarTomate();

        String tipo_tomate_sanduiche = tomate_sanduiche2.getTipo();
        String tipo_tomate_expected = tomate_sanduiche.getTipo();

        assertEquals(tipo_tomate_expected, tipo_tomate_sanduiche);
    }
 
    @Test
    public void TesteMontarSanduiche(){
        String sanduiche_montado = sanduiche_tipo2.montaSanduiche();

        String sanduiche_expected = String.format("Sanduíche com: %s, %s, %s, %s e %s.", pao_sanduiche.getTipo(), queijo_sanduiche.getTipo(), presunto_sanduiche.getTipo(), ovo_sanduiche.getTipo(), tomate_sanduiche.getTipo());

        assertEquals(sanduiche_expected, sanduiche_montado);

    }

}