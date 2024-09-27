package com.example;

import java.util.HashMap;

public class Professor implements Pessoa{
    private HashMap<String, String> turma; 
    private int contador; 
    private String tempoDeCasa;
    private String id;
    private String nome;

    public Professor(String id, String nome, String tempoDeCasa) {
        if (id == null || nome == null || tempoDeCasa == null) {
            throw new IllegalArgumentException("Erro: Dados do professor não podem ser nulos.");
        }
        this.id = id;
        this.nome = nome;
        this.tempoDeCasa = tempoDeCasa;
        turma = new HashMap<>();
        contador = 1; 
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
    
    public String getTempoDeCasa() {
        return tempoDeCasa;
    }
    
    public void setTempoDeCasa(String novoTempoDeCasa) {
        this.tempoDeCasa = novoTempoDeCasa;
    }

    public void alocarDisciplina(String disciplina) {
        turma.put("Disciplina" + contador++, disciplina); 
    }

    public String mostrarTurma() {
        StringBuilder resultado = new StringBuilder("Disciplinas Alocadas:\n");
        for (String key : turma.keySet()) {
            resultado.append(key + ": " + turma.get(key) + "\n");
        }
        return resultado.toString();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
