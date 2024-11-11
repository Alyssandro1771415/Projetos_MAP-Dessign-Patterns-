package com.example.factory;

public class Circulo implements Figura {

    protected Circulo() {

    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando um Círculo.");
    }
}
