package com.example;

public class VisitanteDesenho implements Visitante {
    @Override
    public String visitarCirculo(Circulo c) {
        return "Desenhando um círculo com raio " + c.getRaio();
    }

    @Override
    public String visitarTriangulo(Triangulo t) {
        return "Desenhando um triângulo com base " + t.getBase() + " e altura " + t.getAltura();
    }

    @Override
    public String visitarRetangulo(Retangulo r) {
        return "Desenhando um retângulo com largura " + r.getLargura() + " e altura " + r.getAltura();
    }

    @Override
    public String visitarTrapezio(Trapezio t) {
        return "Desenhando um trapézio com base maior " + t.getBaseMaior() + ", base menor " + t.getBaseMenor() + " e altura " + t.getAltura();
    }
}
