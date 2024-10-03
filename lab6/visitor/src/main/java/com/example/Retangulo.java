package com.example;

// Elemento concreto
public class Retangulo implements Figura {
    private double largura, altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String aceitar(Visitante visitante) {
        return visitante.visitarRetangulo(this);
    }
}
