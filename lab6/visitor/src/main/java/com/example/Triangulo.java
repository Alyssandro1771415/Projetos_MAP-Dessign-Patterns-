package com.example;

// Elemento concreto
public class Triangulo implements Figura {
    private double base, altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String aceitar(Visitante visitante) {
        return visitante.visitarTriangulo(this);
    }
}
