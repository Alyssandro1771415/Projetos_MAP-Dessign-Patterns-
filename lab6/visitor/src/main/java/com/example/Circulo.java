package com.example;

// Elemento concreto
public class Circulo implements Figura {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public String aceitar(Visitante visitante) {
        return visitante.visitarCirculo(this);
    }
}
