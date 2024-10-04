import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Trapezio;
import com.example.VisitanteArea;
import com.example.VisitanteDesenho;
import com.example.VisitanteInfo;
import com.example.VisitanteMaximizacao;

public class testeTrapezio {

    Trapezio trapezio;
    VisitanteArea visitanteArea;
    VisitanteDesenho visitanteDesenho;
    VisitanteInfo visitanteInfo;
    VisitanteMaximizacao visitanteMaximizacao;

    @BeforeEach
    public void setup() throws Exception {
        trapezio = new Trapezio(10, 5, 4);
        visitanteArea = new VisitanteArea();
        visitanteDesenho = new VisitanteDesenho();
        visitanteInfo = new VisitanteInfo();
        visitanteMaximizacao = new VisitanteMaximizacao();
    }

    @Test
    public void testeGetBaseMaior() {
        double baseMaior = trapezio.getBaseMaior();
        assertEquals(10, baseMaior);
        assertNotEquals(8, baseMaior);
    }

    @Test
    public void testeGetBaseMenor() {
        double baseMenor = trapezio.getBaseMenor();
        assertEquals(5, baseMenor);
        assertNotEquals(6, baseMenor);
    }

    @Test
    public void testeGetAltura() {
        double altura = trapezio.getAltura();
        assertEquals(4, altura);
        assertNotEquals(5, altura);
    }

    @Test
    public void testeAceitarVisitanteArea() {
        // Cálculo da área do trapézio
        double area = ((trapezio.getBaseMaior() + trapezio.getBaseMenor()) * trapezio.getAltura()) / 2;
        assertEquals("Área do trapézio: " + area, trapezio.aceitar(visitanteArea));
    }

    @Test
    public void testeAceitarVisitanteDesenho() {
        // O método de desenho pode variar; aqui está um exemplo simples
        assertEquals("Desenhando um trapézio com base maior " + trapezio.getBaseMaior() + 
                     ", base menor " + trapezio.getBaseMenor() + 
                     " e altura " + trapezio.getAltura(), 
                     trapezio.aceitar(visitanteDesenho));
    }

    @Test
    public void testeAceitarVisitanteInfo() {
        assertEquals("Trapézio com base maior " + trapezio.getBaseMaior() + 
                     ", base menor " + trapezio.getBaseMenor() + 
                     " e altura " + trapezio.getAltura(), 
                     trapezio.aceitar(visitanteInfo));
    }

    @Test
    public void testeAceitarVisitanteMaximizacao() {
        double firstBaseMaior = trapezio.getBaseMaior();
        double firstBaseMenor = trapezio.getBaseMenor();
        double firstAltura = trapezio.getAltura();
        double newBaseMaior = firstBaseMaior * 2;
        double newBaseMenor = firstBaseMenor * 2;
        double newAltura = firstAltura * 2;

        assertEquals(String.format(Locale.US, "Trapézio antes: base maior %.1f, base menor %.1f, altura %.1f\n" +
                        "Trapézio maximizado: base maior %.1f, base menor %.1f, altura %.1f\n", 
                        firstBaseMaior, firstBaseMenor, firstAltura, 
                        newBaseMaior, newBaseMenor, newAltura), 
                        trapezio.aceitar(visitanteMaximizacao));
    }
}
