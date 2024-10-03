package com.example;
//ConcreteVisitors
public class VisitanteMaximizacao implements Visitante {
    @Override
    public String visitarCirculo(Circulo c) {
        c.setRaio(c.getRaio() * 2);
        return "Raio antigo do circulo: " + c.getRaio() + "\nNovo raio do círculo: " + c.getRaio() + "\n";
    }

    @Override
    public String visitarTriangulo(Triangulo t) {
        String resultado = "Triângulo antes: base " + t.getBase() + ", altura " + t.getAltura();
        t = new Triangulo(t.getBase() * 2, t.getAltura() * 2);
        return resultado + "\nTriângulo maximizado: base " + t.getBase() + ", altura " + t.getAltura() + "\n";
    }

    @Override
    public String visitarRetangulo(Retangulo r) {
        String resultado = "Retângulo antes: largura " + r.getLargura() + ", altura " + r.getAltura();
        r = new Retangulo(r.getLargura() * 2, r.getAltura() * 2);
        return resultado + "\nRetângulo maximizado: largura " + r.getLargura() + ", altura " + r.getAltura() + "\n";
    }

    @Override
    public String visitarTrapezio(Trapezio t) {
        String resultado = "Trapézio antes: base maior " + t.getBaseMaior() + ", base menor " + t.getBaseMenor() + ", altura " + t.getAltura();
        t = new Trapezio(t.getBaseMaior() * 2, t.getBaseMenor() * 2, t.getAltura() * 2);
        return resultado + "\nTrapézio maximizado: base maior " + t.getBaseMaior() + ", base menor " + t.getBaseMenor() + ", altura " + t.getAltura() + "\n";
    }
}

