package com.example;

public class Triangulo implements Figura {
    private double base, altura;

    public Triangulo(double base, double altura) throws Exception {
        if (base < 0 || altura < 0){
            throw new Exception("Dados negativos não são válidos!");
        }
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
