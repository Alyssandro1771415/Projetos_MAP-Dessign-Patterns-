import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Circulo;
import com.example.Retangulo;
import com.example.Trapezio;
import com.example.Triangulo;
import com.example.VisitanteMaximizacao;

public class testeVisitanteMaximizar {

    private VisitanteMaximizacao visitanteMaximizacao;
    private Circulo circulo;
    private Triangulo triangulo;
    private Retangulo retangulo;
    private Trapezio trapezio;

    @BeforeEach
    public void setUp() throws Exception {
        visitanteMaximizacao = new VisitanteMaximizacao();
        circulo = new Circulo(5.0);
        triangulo = new Triangulo(6.0, 4.0);
        retangulo = new Retangulo(4.0, 3.0);
        trapezio = new Trapezio(7.0, 5.0, 4.0);
    }

    @Test
    public void testVisitarCirculo() {
        String resultadoEsperado = "Raio antigo do circulo: 5.0\nNovo raio do círculo: 10.0\n";
        assertEquals(resultadoEsperado, visitanteMaximizacao.visitarCirculo(circulo));
    }

    @Test
    public void testVisitarTriangulo() {
        String resultadoEsperado = "Triângulo antes: base 6.0, altura 4.0\nTriângulo maximizado: base 12.0, altura 8.0\n";
        assertEquals(resultadoEsperado, visitanteMaximizacao.visitarTriangulo(triangulo));
    }

    @Test
    public void testVisitarRetangulo() {
        String resultadoEsperado = "Retângulo antes: largura 4.0, altura 3.0\nRetângulo maximizado: largura 8.0, altura 6.0\n";
        assertEquals(resultadoEsperado, visitanteMaximizacao.visitarRetangulo(retangulo));
    }

    @Test
    public void testVisitarTrapezio() {
        String resultadoEsperado = "Trapézio antes: base maior 7.0, base menor 5.0, altura 4.0\nTrapézio maximizado: base maior 14.0, base menor 10.0, altura 8.0\n";
        assertEquals(resultadoEsperado, visitanteMaximizacao.visitarTrapezio(trapezio));
    }
}
