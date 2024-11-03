import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Circulo;
import com.example.FacadeManipuladorFiguras;
import com.example.Trapezio;
import com.example.Triangulo;
import com.example.Visitante;
import com.example.VisitanteArea;
import com.example.VisitanteDesenho;
import com.example.VisitanteInfo;
import com.example.VisitanteMaximizacao;

public class testeFacadeManipuladorFigura {

    FacadeManipuladorFiguras facade;

    Circulo circulo;
    Triangulo triangulo;
    Trapezio trapezio;

    Visitante visitanteArea;
    Visitante visitanteDesenho;
    Visitante visitanteInfo;
    Visitante visitanteMaximizar;

    @BeforeEach
    public void setup() throws Exception {
        facade = new FacadeManipuladorFiguras();

        circulo = new Circulo(5);
        triangulo = new Triangulo(5, 2);
        trapezio = new Trapezio(10, 5, 3);

        visitanteArea = new VisitanteArea();
        visitanteDesenho = new VisitanteDesenho();
        visitanteInfo = new VisitanteInfo();
        visitanteMaximizar = new VisitanteMaximizacao();
    }

    @Test
    public void testeAdicionarFigura() throws Exception {
        String mensagem_circulo = facade.adicionarFigura(circulo);
        String mensagem_triangulo = facade.adicionarFigura(triangulo);
        String mensagem_trapezio = facade.adicionarFigura(trapezio);

        assertEquals("Adicionado: Circulo de raio " + circulo.getRaio() + ".\n", mensagem_circulo);
        assertEquals("Adicionado: Triângulo com base " + triangulo.getBase() + " e altura " + triangulo.getAltura() + ".\n", mensagem_triangulo);
        assertEquals("Adicionado: Trapézio com base maior " + trapezio.getBaseMaior() + ", base menor " + trapezio.getBaseMenor() + " e altura " + trapezio.getAltura() + ".\n", mensagem_trapezio);
    }

    @Test
    public void testeDesenharFigura() throws Exception {
        facade.adicionarFigura(circulo);
        facade.adicionarFigura(triangulo);
        facade.adicionarFigura(trapezio);

        String mensagem = facade.desenharFiguras();

        assertEquals("Desenho:\n" +
                "Desenhando um círculo com raio " + circulo.getRaio() + "\n" +
                "Desenhando um triângulo com base " + triangulo.getBase() + " e altura " + triangulo.getAltura() + "\n" +
                "Desenhando um trapézio com base maior " + trapezio.getBaseMaior() + ", base menor " + trapezio.getBaseMenor() + " e altura " + trapezio.getAltura() + "\n", mensagem);
    }

    @Test
    public void testeCalcularAreas() throws Exception {
        facade.adicionarFigura(circulo);
        facade.adicionarFigura(triangulo);
        facade.adicionarFigura(trapezio);

        String mensagem = facade.calcularAreas();

        assertEquals("\nÁrea:\n" +
                "Área do círculo: 78.53981633974483\n" +
                "Área do triângulo: 5.0\n" +
                "Área do trapézio: 22.5\n", mensagem);
    }

    @Test
    public void testeMaximizarFiguras() throws Exception {
    
        double raio_circulo = circulo.getRaio();
        double triangulo_base = triangulo.getBase();
        double triangulo_altura = triangulo.getAltura();
        double trapezio_base_maior = trapezio.getBaseMaior();
        double trapezio_base_menor = trapezio.getBaseMenor();
        double trapezio_altura = trapezio.getAltura();
    
        facade.adicionarFigura(circulo);
        facade.adicionarFigura(triangulo);
        facade.adicionarFigura(trapezio);
    
        String mensagem = facade.maximizarFiguras();
    
        assertEquals("\nMaximização:\n" +
                "Raio antigo do circulo: " + raio_circulo + "\n" +
                "Novo raio do círculo: " + circulo.getRaio() + "\n\n" +
                "Triângulo antes: base " + triangulo_base + ", altura " + triangulo_altura + "\n" +
                "Triângulo maximizado: base " + (triangulo_base * 2) + ", altura " + (triangulo_altura * 2) + "\n\n" +
                "Trapézio antes: base maior " + trapezio_base_maior + ", base menor " + trapezio_base_menor + ", altura " + trapezio_altura + "\n" +
                "Trapézio maximizado: base maior " + (trapezio_base_maior * 2) + ", base menor " + (trapezio_base_menor * 2) + ", altura " + (trapezio_altura * 2) + "\n\n", 
                mensagem);
    }
    
}
