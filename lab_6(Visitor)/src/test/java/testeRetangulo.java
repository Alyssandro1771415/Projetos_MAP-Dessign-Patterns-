import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Retangulo;
import com.example.VisitanteArea;
import com.example.VisitanteDesenho;
import com.example.VisitanteInfo;
import com.example.VisitanteMaximizacao;

public class testeRetangulo {

    Retangulo retangulo;
    VisitanteArea visitanteArea;
    VisitanteDesenho visitanteDesenho;
    VisitanteInfo visitanteInfo;
    VisitanteMaximizacao visitanteMaximizacao;

    @BeforeEach
    public void setup() throws Exception {

        retangulo = new Retangulo(5, 3);

        visitanteArea = new VisitanteArea();
        visitanteDesenho = new VisitanteDesenho();
        visitanteInfo = new VisitanteInfo();
        visitanteMaximizacao = new VisitanteMaximizacao();
    }

    @Test
    public void testeGetLargura() {

        double largura = retangulo.getLargura();

        assertEquals(5, largura);
        assertNotEquals(4, largura);
    }

    @Test
    public void testeGetAltura() {

        double altura = retangulo.getAltura();

        assertEquals(3, altura);
        assertNotEquals(2, altura);
    }

    @Test
    public void testeAceitarVisitanteArea() {

        double area = retangulo.getLargura() * retangulo.getAltura();

        assertEquals("Área do retângulo: " + area, retangulo.aceitar(visitanteArea));
    }

    @Test
    public void testeAceitarVisitanteDesenho() {

        double largura = retangulo.getLargura();
        double altura = retangulo.getAltura();

        assertEquals("Desenhando um retângulo com largura " + largura + " e altura " + altura, retangulo.aceitar(visitanteDesenho));
    }

    @Test
    public void testeAceitarVisitanteInfo() {

        double largura = retangulo.getLargura();
        double altura = retangulo.getAltura();

        assertEquals("Retângulo com largura " + largura + " e altura " + altura, retangulo.aceitar(visitanteInfo));
    }

    @Test
    public void testeAceitarVisitanteMaximizacao() {

        double firstLargura = retangulo.getLargura();
        double firstAltura = retangulo.getAltura();
        double newLargura = firstLargura * 2;
        double newAltura = firstAltura * 2;

        assertEquals(String.format(Locale.US, "Retângulo antes: largura %.1f, altura %.1f\nRetângulo maximizado: largura %.1f, altura %.1f\n", firstLargura, firstAltura, newLargura, newAltura), retangulo.aceitar(visitanteMaximizacao));
    }
}
