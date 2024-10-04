package com.example;

public class VisitanteArea implements Visitante {
    @Override
    public String visitarCirculo(Circulo c) {
        double area = Math.PI * Math.pow(c.getRaio(), 2);
        return "Área do círculo: " + area;
    }

    @Override
    public String visitarTriangulo(Triangulo t) {
        double area = (t.getBase() * t.getAltura()) / 2;
        return "Área do triângulo: " + area;
    }

    @Override
    public String visitarRetangulo(Retangulo r) {
        double area = r.getLargura() * r.getAltura();
        return "Área do retângulo: " + area;
    }

    @Override
    public String visitarTrapezio(Trapezio t) {
        double area = ((t.getBaseMaior() + t.getBaseMenor()) * t.getAltura()) / 2;
        return "Área do trapézio: " + area;
    }
}


