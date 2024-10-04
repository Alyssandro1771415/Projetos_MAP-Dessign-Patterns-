package com.example;

public class VisitanteMaximizacao implements Visitante {
    @Override
    public String visitarCirculo(Circulo c) {
        double raioBefore = c.getRaio();
        c.setRaio(c.getRaio() * 2);
        return "Raio antigo do circulo: " + raioBefore + "\nNovo raio do círculo: " + c.getRaio() + "\n";
    }

    @Override
    public String visitarTriangulo(Triangulo t) {
        String resultado = "Triângulo antes: base " + t.getBase() + ", altura " + t.getAltura();
        try {
            t = new Triangulo(t.getBase() * 2, t.getAltura() * 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado + "\nTriângulo maximizado: base " + t.getBase() + ", altura " + t.getAltura() + "\n";
    }

    @Override
    public String visitarRetangulo(Retangulo r) {
        String resultado = "Retângulo antes: largura " + r.getLargura() + ", altura " + r.getAltura();
        try {
            r = new Retangulo(r.getLargura() * 2, r.getAltura() * 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado + "\nRetângulo maximizado: largura " + r.getLargura() + ", altura " + r.getAltura() + "\n";
    }

    @Override
    public String visitarTrapezio(Trapezio t) {
        String resultado = "Trapézio antes: base maior " + t.getBaseMaior() + ", base menor " + t.getBaseMenor() + ", altura " + t.getAltura();
        try {
            t = new Trapezio(t.getBaseMaior() * 2, t.getBaseMenor() * 2, t.getAltura() * 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado + "\nTrapézio maximizado: base maior " + t.getBaseMaior() + ", base menor " + t.getBaseMenor() + ", altura " + t.getAltura() + "\n";
    }
}

