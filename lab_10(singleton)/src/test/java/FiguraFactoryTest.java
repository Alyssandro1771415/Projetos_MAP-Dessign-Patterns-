import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.factory.Circulo;
import com.example.factory.FiguraFactory;
import com.example.factory.Quadrado;
import com.example.factory.Triangulo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FiguraFactoryTest {

    private FiguraFactory factory;

    @BeforeEach
    void setUp() {
        factory = FiguraFactory.getInstance();
    }

    @Test
    void testeGetInstance() {
        FiguraFactory factory1 = FiguraFactory.getInstance();
        FiguraFactory factory2 = FiguraFactory.getInstance();
        assertSame(factory1, factory2, "As instâncias devem ser as mesmas (Singleton)");
    }

    @Test
    void testeCriarCirculo() {
        Circulo circulo1 = factory.criarCirculo();
        Circulo circulo2 = factory.criarCirculo();
        assertNotNull(circulo1, "O círculo não pode ser nulo");
        assertSame(circulo1, circulo2, "Deve retornar a mesma instância de círculo (Singleton)");
    }

    @Test
    void testeCriarTrianguloIsosceles() {
        Triangulo triangulo = spy(factory.criarTriangulo("isosceles"));
        assertNotNull(triangulo, "Triângulo Isósceles deveria ser criado.");
        triangulo.desenhar();
        verify(triangulo).desenhar();
    }

    @Test
    void testeCriarTrianguloEquilatero() {
        Triangulo triangulo = spy(factory.criarTriangulo("equilatero"));
        assertNotNull(triangulo, "Triângulo Equilátero deveria ser criado.");
        triangulo.desenhar();
        verify(triangulo).desenhar();
    }

    @Test
    void testeCriarTrianguloRetangulo() {
        Triangulo triangulo = spy(factory.criarTriangulo("retangulo"));
        assertNotNull(triangulo, "Triângulo Retângulo deveria ser criado.");
        triangulo.desenhar();
        verify(triangulo).desenhar();
    }

    @Test
    void testeCriarTrianguloInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> factory.criarTriangulo("invalido"), 
            "Deveria lançar IllegalArgumentException para tipo inválido."
        );

        assertEquals("Tipo de triângulo inválido: invalido", exception.getMessage());
    }

    @Test
    void testeCriarQuadrado() {
        Quadrado quadrado = spy(factory.criarQuadrado());
        assertNotNull(quadrado, "O quadrado não pode ser nulo");
        quadrado.desenhar();
        verify(quadrado).desenhar();
    }
}
