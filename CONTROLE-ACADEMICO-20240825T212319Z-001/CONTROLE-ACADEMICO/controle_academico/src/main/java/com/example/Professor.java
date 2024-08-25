package com.example;

public class Professor {
    private String nome;
    private String codigoProf;

    public Professor(String nome, String codigoProf) {
        this.nome = nome;
        this.codigoProf = codigoProf;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoProf() {
        return codigoProf;
    }
}
