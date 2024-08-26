package com.example;

public class Retangulo implements Figura {
    private double largura;
    private double altura;

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if(largura < 0){
            throw new IllegalArgumentException("Valores negativos inválidos para largura.");
        }
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if(largura < 0){
            throw new IllegalArgumentException("Valores negativos inválidos para altura.");
        }
        this.altura = altura;
    }

    public Retangulo(double largura, double altura) {
        if(largura < 0 || altura < 0){
            throw new IllegalArgumentException("Valores negativos inválidos.");
        }
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }
    
    public String toString(){
        return ("O retangulo criado tem altura de tamanho: " + this.altura + 
			"e largura de tamanho: " + this.largura);
    }
}
