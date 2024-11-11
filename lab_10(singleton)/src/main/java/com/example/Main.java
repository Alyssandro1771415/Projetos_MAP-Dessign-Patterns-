package com.example;
import com.example.factory.*;

public class Main {
    public static void main(String[] args) {

        try {
            FiguraFactory factory = FiguraFactory.getInstance();

            Figura circulo = factory.criarCirculo();
            circulo.desenhar();
    
            Figura circulo2 = factory.criarCirculo();
            circulo2.desenhar();
    
            System.out.println(circulo2 == circulo);
    
            Figura trianguloIsosceles = factory.criarTriangulo("isosceles");
            Figura trianguloEquilatero = factory.criarTriangulo("equilatero");
            Figura trianguloRetangulo = factory.criarTriangulo("retangulo");
    
            trianguloIsosceles.desenhar();
            trianguloEquilatero.desenhar();
            trianguloRetangulo.desenhar();
    
            Figura quadrado1 = factory.criarQuadrado();
            Figura quadrado2 = factory.criarQuadrado();
    
            quadrado1.desenhar();
            quadrado2.desenhar();
            System.out.println(quadrado1==quadrado2);
        } catch (Exception e) {
           System.out.println("An error has occured: " + e);
        }

    }
}
