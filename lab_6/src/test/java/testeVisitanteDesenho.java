import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Circulo;
import com.example.Retangulo;
import com.example.Trapezio;
import com.example.Triangulo;
import com.example.VisitanteDesenho;

public class testeVisitanteDesenho {

    private VisitanteDesenho visitanteDesenho;
    private Circulo circulo;
    private Triangulo triangulo;
    private Retangulo retangulo;
    private Trapezio trapezio;

    @BeforeEach
    public void setUp() throws Exception {
        visitanteDesenho = new VisitanteDesenho();
        circulo = new Circulo(5);
        triangulo = new Triangulo(6, 4);
        retangulo = new Retangulo(4, 3);
        trapezio = new Trapezio(7, 5, 4);
    }

    @Test
    public void testVisitarCirculo() {
        String resultadoEsperado = "Desenhando um círculo com raio 5.0";
        assertEquals(resultadoEsperado, visitanteDesenho.visitarCirculo(circulo));
    }

    @Test
    public void testVisitarTriangulo() {
        String resultadoEsperado = "Desenhando um triângulo com base 6.0 e altura 4.0";
        assertEquals(resultadoEsperado, visitanteDesenho.visitarTriangulo(triangulo));
    }

    @Test
    public void testVisitarRetangulo() {
        String resultadoEsperado = "Desenhando um retângulo com largura 4.0 e altura 3.0";
        assertEquals(resultadoEsperado, visitanteDesenho.visitarRetangulo(retangulo));
    }

    @Test
    public void testVisitarTrapezio() {
        String resultadoEsperado = "Desenhando um trapézio com base maior 7.0, base menor 5.0 e altura 4.0";
        assertEquals(resultadoEsperado, visitanteDesenho.visitarTrapezio(trapezio));
    }
}
