package com.example;

public class Disciplina {
    private String nome;
    private String codigoDisciplina;
    

    public Disciplina(String nome, String codigoDisciplina) {
        this.nome = nome;
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }
}
