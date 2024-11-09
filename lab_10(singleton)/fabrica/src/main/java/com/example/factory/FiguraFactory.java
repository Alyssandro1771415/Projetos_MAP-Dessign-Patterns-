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
        return triangulos.get(tipo.toLowerCase());
    }

    public Quadrado criarQuadrado() {
        return new Quadrado();
    }
}
