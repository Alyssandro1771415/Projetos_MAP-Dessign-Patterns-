import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Circulo;
import com.example.Retangulo;
import com.example.Trapezio;
import com.example.Triangulo;
import com.example.VisitanteInfo;

public class testeVisitanteInfo {

    private VisitanteInfo visitanteInfo;
    private Circulo circulo;
    private Triangulo triangulo;
    private Retangulo retangulo;
    private Trapezio trapezio;

    @BeforeEach
    public void setUp() throws Exception {
        visitanteInfo = new VisitanteInfo();
        circulo = new Circulo(5);
        triangulo = new Triangulo(6, 4);
        retangulo = new Retangulo(4, 3);
        trapezio = new Trapezio(7, 5, 4);
    }

    @Test
    public void testVisitarCirculo() {
        String resultadoEsperado = "Circulo de raio 5.0";
        assertEquals(resultadoEsperado, visitanteInfo.visitarCirculo(circulo));
    }

    @Test
    public void testVisitarTriangulo() {
        String resultadoEsperado = "Triângulo com base 6.0 e altura 4.0";
        assertEquals(resultadoEsperado, visitanteInfo.visitarTriangulo(triangulo));
    }

    @Test
    public void testVisitarRetangulo() {
        String resultadoEsperado = "Retângulo com largura 4.0 e altura 3.0";
        assertEquals(resultadoEsperado, visitanteInfo.visitarRetangulo(retangulo));
    }

    @Test
    public void testVisitarTrapezio() {
        String resultadoEsperado = "Trapézio com base maior 7.0, base menor 5.0 e altura 4.0";
        assertEquals(resultadoEsperado, visitanteInfo.visitarTrapezio(trapezio));
    }
}
