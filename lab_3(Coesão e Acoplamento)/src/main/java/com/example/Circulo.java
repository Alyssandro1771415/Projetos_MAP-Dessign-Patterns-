package com.example;

public class Circulo implements Figura {
    
    private double raio;

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio não pode ser negativo.");
        }
        this.raio = raio;
    }

    public Circulo(double raio) {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio não pode ser negativo.");
        }
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
    
    @Override
    public String toString() {
        return "O círculo criado tem raio de: " + getRaio();
    }
}
