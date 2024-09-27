package com.example;

import java.util.HashMap;

public class Administrativo {
    HashMap<String, String> reunioes;
    HashMap<String, String> entrevistas;

    public Administrativo() {
        this.reunioes = new HashMap<>();
        this.entrevistas = new HashMap<>();
    }

    public String agendarReuniao(String departamento, String nomeChefeReuniao, String data, String horario) {
        if (departamento == null || nomeChefeReuniao == null || data == null || horario == null) {
            throw new IllegalArgumentException("Erro: Dados inválidos para agendamento.");
        }
        
        reunioes.put(data + "-" + horario, departamento + "-" + nomeChefeReuniao);
        return "Reunião com diretoria agendada. Departamento de " + departamento + " para " + nomeChefeReuniao + " em " + data + " às " + horario + ".";
    }
    
    public String marcarEntrevista(String nome, String departamento, String data, String horario) {
        if (nome == null || departamento == null || data == null || horario == null) {
            throw new IllegalArgumentException("Erro: Dados inválidos para agendamento.");
        }
        String chave = data + horario;
        entrevistas.put(chave, departamento);
        
        return "Entrevista marcada com " + nome + " do departamento de " + departamento + " em " + data + " às " + horario + ".";
    }
}
