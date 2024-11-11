package com.example.factory;

import java.util.HashMap;
import java.util.Map;

public class FiguraFactory {
    private static FiguraFactory instance;

    private Circulo circulo;
    private final Map<String, Triangulo> triangulos = new HashMap<>();

    private FiguraFactory() {
        triangulos.put("isosceles", new Triangulo("Isósceles"));
        triangulos.put("equilatero", new Triangulo("Equilátero"));
        triangulos.put("retangulo", new Triangulo("Retângulo"));
    }

    public static synchronized FiguraFactory getInstance() {
        if (instance == null) {
            instance = new FiguraFactory();
        }
        return instance;
    }

    public Circulo criarCirculo() {
        if (circulo == null) {
            circulo = new Circulo();
        }
        return circulo;
    }

    public Triangulo criarTriangulo(String tipo) {
        Triangulo triangulo = triangulos.get(tipo.toLowerCase());
        if (triangulo == null) {
            throw new IllegalArgumentException("Tipo de triângulo inválido: " + tipo);
        }
        return triangulo;
    }

    public Quadrado criarQuadrado() {
        return new Quadrado();
    }
}
