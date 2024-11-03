import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Circulo;
import com.example.Retangulo;
import com.example.Trapezio;
import com.example.Triangulo;
import com.example.VisitanteArea;

public class testeVisitanteArea {

    private VisitanteArea visitanteArea;
    private Circulo circulo;
    private Triangulo triangulo;
    private Retangulo retangulo;
    private Trapezio trapezio;

    @BeforeEach
    public void setUp() throws Exception {
        visitanteArea = new VisitanteArea();
        circulo = new Circulo(5); 
        triangulo = new Triangulo(6, 4);
        retangulo = new Retangulo(4, 3); 
        trapezio = new Trapezio(7, 5, 4);
    }

    @Test
    public void testVisitarCirculo() {
        String resultadoEsperado = "Área do círculo: " + (Math.PI * Math.pow(circulo.getRaio(), 2));
        assertEquals(resultadoEsperado, visitanteArea.visitarCirculo(circulo));
    }

    @Test
    public void testVisitarTriangulo() {
        String resultadoEsperado = "Área do triângulo: " + ((triangulo.getBase() * triangulo.getAltura()) / 2);
        assertEquals(resultadoEsperado, visitanteArea.visitarTriangulo(triangulo));
    }

    @Test
    public void testVisitarRetangulo() {
        String resultadoEsperado = "Área do retângulo: " + (retangulo.getLargura() * retangulo.getAltura());
        assertEquals(resultadoEsperado, visitanteArea.visitarRetangulo(retangulo));
    }

    @Test
    public void testVisitarTrapezio() {
        String resultadoEsperado = "Área do trapézio: " + (((trapezio.getBaseMaior() + trapezio.getBaseMenor()) * trapezio.getAltura()) / 2);
        assertEquals(resultadoEsperado, visitanteArea.visitarTrapezio(trapezio));
    }
}
