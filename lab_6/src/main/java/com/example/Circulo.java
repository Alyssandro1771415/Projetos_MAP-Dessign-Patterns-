package com.example;

public class Circulo implements Figura {
    private double raio;

    public Circulo(double raio) {
        if (raio < 0){
            throw new IllegalArgumentException("Valores negativos não são permitidos!");
        }
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio < 0){
            throw new IllegalArgumentException("Valores negativos não são permitidos!");
        }
        this.raio = raio;
    }

    @Override
    public String aceitar(Visitante visitante) {
        return visitante.visitarCirculo(this);
    }
}
