package com.example;

public class Retangulo implements Figura{
    private double largura, altura;

    public Retangulo(double largura, double altura) throws Exception {
        if (largura < 0 || altura < 0){
            throw new Exception("Dados negativos não são aceitáveis!");
        }
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String aceitar(Visitante visitante) {
        return visitante.visitarRetangulo(this);
    }
}
