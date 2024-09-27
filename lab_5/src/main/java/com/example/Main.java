package com.example;

public class Main {
    public static void main(String[] args) {
        Fachada fachada = new Fachada();

        fachada.adicionarAluno("A001", "Valerio", "Computacao");
        fachada.adicionarAluno("A002", "Danilo", "Odontologia");
        fachada.adicionarAluno("A003", "Alyssandro", "Computacao");
    }
}
