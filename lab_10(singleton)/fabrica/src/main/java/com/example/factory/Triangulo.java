package com.example.factory;

public class Triangulo implements Figura {
    private final String tipo;

    public Triangulo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando um Triângulo " + tipo + ".");
    }
}
