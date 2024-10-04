import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Triangulo;
import com.example.VisitanteArea;
import com.example.VisitanteDesenho;
import com.example.VisitanteInfo;
import com.example.VisitanteMaximizacao;

public class testeTriangulo {

    Triangulo triangulo;
    VisitanteArea visitanteArea;
    VisitanteDesenho visitanteDesenho;
    VisitanteInfo visitanteInfo;
    VisitanteMaximizacao visitanteMaximizacao;

    @BeforeEach
    public void setup() throws Exception {
        triangulo = new Triangulo(10, 5);
        visitanteArea = new VisitanteArea();
        visitanteDesenho = new VisitanteDesenho();
        visitanteInfo = new VisitanteInfo();
        visitanteMaximizacao = new VisitanteMaximizacao();
    }

    @Test
    public void testeGetBase() {
        double base = triangulo.getBase();
        assertEquals(10, base);
        assertNotEquals(8, base);
    }

    @Test
    public void testeGetAltura() {
        double altura = triangulo.getAltura();
        assertEquals(5, altura);
        assertNotEquals(6, altura);
    }

    @Test
    public void testeAceitarVisitanteArea() {
        // Cálculo da área do triângulo
        double area = (triangulo.getBase() * triangulo.getAltura()) / 2;
        assertEquals("Área do triângulo: " + area, triangulo.aceitar(visitanteArea));
    }

    @Test
    public void testeAceitarVisitanteDesenho() {
        // O método de desenho pode variar; aqui está um exemplo simples
        assertEquals("Desenhando um triângulo com base " + triangulo.getBase() + 
                     " e altura " + triangulo.getAltura(), 
                     triangulo.aceitar(visitanteDesenho));
    }

    @Test
    public void testeAceitarVisitanteInfo() {
        assertEquals("Triângulo com base " + triangulo.getBase() + 
                     " e altura " + triangulo.getAltura(), 
                     triangulo.aceitar(visitanteInfo));
    }

    @Test
    public void testeAceitarVisitanteMaximizacao() {
        double firstBase = triangulo.getBase();
        double firstAltura = triangulo.getAltura();
        double newBase = firstBase * 2;
        double newAltura = firstAltura * 2;

        assertEquals(String.format(Locale.US, "Triângulo antes: base %.1f, altura %.1f\n" +
                        "Triângulo maximizado: base %.1f, altura %.1f\n", 
                        firstBase, firstAltura, 
                        newBase, newAltura), 
                        triangulo.aceitar(visitanteMaximizacao));
    }
}
