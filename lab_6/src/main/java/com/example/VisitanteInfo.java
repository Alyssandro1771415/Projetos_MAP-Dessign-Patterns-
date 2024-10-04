package com.example;

public class VisitanteInfo implements Visitante {
    @Override
    public String visitarCirculo(Circulo c) {
        return "Circulo de raio " + c.getRaio();
    }

    @Override
    public String visitarTriangulo(Triangulo t) {
        return "Triângulo com base " + t.getBase() + " e altura " + t.getAltura();
    }

    @Override
    public String visitarRetangulo(Retangulo r) {
        return "Retângulo com largura " + r.getLargura() + " e altura " + r.getAltura();
    }

    @Override
    public String visitarTrapezio(Trapezio t) {
        return "Trapézio com base maior " + t.getBaseMaior() + ", base menor " + t.getBaseMenor() + " e altura " + t.getAltura();
    }
}
