import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Circulo;
import com.example.VisitanteArea;
import com.example.VisitanteDesenho;
import com.example.VisitanteInfo;
import com.example.VisitanteMaximizacao;

public class testeCirculo {

    Circulo circulo;
    VisitanteArea visitanteArea;
    VisitanteDesenho visitanteDesenho;
    VisitanteInfo visitanteInfo;
    VisitanteMaximizacao visitanteMaximizacao;

    @BeforeEach
    public void setup(){

        circulo = new Circulo(5);

        visitanteArea = new VisitanteArea();
        visitanteDesenho = new VisitanteDesenho();
        visitanteInfo = new VisitanteInfo();
        visitanteMaximizacao = new VisitanteMaximizacao();

    }

    @Test
    public void testeGetRaio(){

        double raio = circulo.getRaio();

        assertEquals(5, raio);
        assertNotEquals(3, raio);

    }

    @Test
    public void testSetRaio(){

        double raio = 15;
        circulo.setRaio(raio);
        
        assertEquals(circulo.getRaio(), raio);

    }

    @Test
    public void testeAceitarVisitanteArea(){

        double area = Math.PI * Math.pow(circulo.getRaio(), 2);

        assertEquals("Área do círculo: " + area, circulo.aceitar(visitanteArea));

    }

    @Test
    public void testeAceitarVisitanteDesenho(){

        double raio = circulo.getRaio();

        assertEquals("Desenhando um círculo com raio " + raio, circulo.aceitar(visitanteDesenho));

    }

    @Test
    public void testeAceitarVisitanteInfo(){

        double raio = circulo.getRaio();

        assertEquals("Circulo de raio " + raio, circulo.aceitar(visitanteInfo));

    }

    @Test
    public void testeAceitarVisitanteMaximizacao(){

        double firstRaio = circulo.getRaio();
        double newRaio = 5 * 2;
        
        assertEquals("Raio antigo do circulo: " + firstRaio + "\n" + 
                        "Novo raio do círculo: " + newRaio + "\n", circulo.aceitar(visitanteMaximizacao));

    }

}
