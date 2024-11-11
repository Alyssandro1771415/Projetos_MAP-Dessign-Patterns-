package com.example.factory;

public class Quadrado implements Figura {

    protected Quadrado() {

    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando um Quadrado.");
    }
}
