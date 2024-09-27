package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Infraestrutura {
    private Set<String> salasDisponiveis; 
    private Map<String, String> descricaoSalas; 

    public Infraestrutura() {
        salasDisponiveis = new HashSet<>(); 
        descricaoSalas = new HashMap<>(); 
    }

    public void adicionarSala(String idSala, String descricao) {
        if (idSala == null || descricao == null) {
            throw new IllegalArgumentException("Erro: Dados inválidos para adicionar sala.");
        }
        salasDisponiveis.add(idSala);
        descricaoSalas.put(idSala, descricao); 
    }

    public String alocarSala(String idSala) {
        if (idSala == null) {
            throw new IllegalArgumentException("Erro: ID da sala não pode ser nulo.");
        }
        if (salasDisponiveis.contains(idSala)) {
            String descricao = descricaoSalas.get(idSala);
            salasDisponiveis.remove(idSala); 
            return "Sala " + idSala + " alocada: " + descricao;
        } else {
            return "Erro: Sala " + idSala + " não disponível.";
        }
    }

    public String desalocarSala(String idSala) {
        if (idSala == null) {
            throw new IllegalArgumentException("Erro: ID da sala não pode ser nulo.");
        }
        if (descricaoSalas.containsKey(idSala)) {
            salasDisponiveis.add(idSala);
            return "Sala " + idSala + " desalocada com sucesso.";
        } else {
            return "Erro: Sala " + idSala + " não existe.";
        }
    }

    public String mostrarSalasDisponiveis() {
        if (salasDisponiveis.isEmpty()) {
            return "Nenhuma sala disponível.";
        }
        StringBuilder resultado = new StringBuilder();
        resultado.append("Salas Disponíveis:\n");
        for (String idSala : salasDisponiveis) {
            resultado.append(idSala).append(": ").append(descricaoSalas.get(idSala)).append("\n");
        }
        return resultado.toString();
    }
}
