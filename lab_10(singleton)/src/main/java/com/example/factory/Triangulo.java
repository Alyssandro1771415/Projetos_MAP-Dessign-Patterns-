package com.example.factory;

public class Triangulo implements Figura {
    private final String tipo;

    protected Triangulo(String tipo) {
        if(tipo == null){
            throw new IllegalArgumentException("Type can`t be a null argument!");
        }
        this.tipo = tipo;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando um Triângulo " + tipo + ".");
    }
}
