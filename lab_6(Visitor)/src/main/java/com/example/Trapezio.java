package com.example;

// Elemento concreto
public class Trapezio implements Figura {
    private double baseMaior, baseMenor, altura;

    public Trapezio(double baseMaior, double baseMenor, double altura) throws Exception {
        if (baseMaior < 0 || baseMenor < 0 || altura < 0){
            throw new Exception("Dados negativos não são aceitáveis");
        }
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    public double getBaseMaior() {
        return baseMaior;
    }

    public double getBaseMenor() {
        return baseMenor;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String aceitar(Visitante visitante) {
        return visitante.visitarTrapezio(this);
    }
}
