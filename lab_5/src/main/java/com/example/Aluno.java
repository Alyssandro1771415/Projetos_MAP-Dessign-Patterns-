package com.example;

import java.util.HashMap;

public class Aluno implements Pessoa{
    private String nome;
    private String id;
    
    private String curso;
    private HashMap<String, String> turmaHistorico; 
    private int contador; // Contador para gerar chaves únicas
    private int periodo;
    
    public Aluno(String id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.turmaHistorico = new HashMap<>();
        this.contador = 1; 
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(int periodo) {
        if (periodo < 1) {
            throw new IllegalArgumentException("O período deve ser maior ou igual a 1.");
        }
        this.periodo = periodo;
    }

    public String adicionarHistorico(String idTurma, String nomeDisciplina, String nomeProfessor, double nota, int faltas) {
        if (idTurma == null || idTurma.isEmpty()) {
            throw new IllegalArgumentException("ID da turma não pode ser nulo ou vazio.");
        }
        if (nomeDisciplina == null || nomeDisciplina.isEmpty()) {
            throw new IllegalArgumentException("Nome da disciplina não pode ser nulo ou vazio.");
        }
        if (nomeProfessor == null || nomeProfessor.isEmpty()) {
            throw new IllegalArgumentException("Nome do professor não pode ser nulo ou vazio.");
        }
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        if (faltas < 0) {
            throw new IllegalArgumentException("O número de faltas não pode ser negativo.");
        }

        String chave = idTurma + "_t" + String.format("%04d", this.contador++);
        String valor = "Disciplina: " + nomeDisciplina + ", Professor: " + nomeProfessor + 
                       ", Nota: " + nota + ", Faltas: " + faltas + ", Período: " + this.periodo;

        if (turmaHistorico.containsKey(chave)) {
            return "Erro: A chave " + chave + " já está em uso."; 
        }
        
        turmaHistorico.put(chave, valor); 
        return "Histórico adicionado para " + nome + " (" + curso + "): " + valor + " com chave " + chave;
    }

    public String mostrarHistorico() {
        if (turmaHistorico.isEmpty()) {
            return "Erro: Nenhum histórico encontrado para o aluno (ID: " + id + ").\n";
        }
        
        StringBuilder historico = new StringBuilder();
        historico.append("Histórico do aluno (ID: ").append(id).append("):\n");
    
        for (String chave : turmaHistorico.keySet()) {
            historico.append(chave).append(" => ").append(turmaHistorico.get(chave)).append("\n");
        }
    
        return historico.toString(); 
    }

    public String gerarRDM() {
        StringBuilder rdm = new StringBuilder(); 
        
        // Verifica se o mapa está vazio
        if (turmaHistorico.isEmpty()) {
            return rdm.append("Erro: Nenhum histórico encontrado para o aluno.\n").toString();
        }
    
        rdm.append("Disciplinas no período ").append(periodo).append(":\n");
    
        boolean encontrouDisciplina = false; // Flag para verificar se encontrou alguma disciplina no período
    
        for (String chave : turmaHistorico.keySet()) {
            String valor = turmaHistorico.get(chave);
            // Usando split para extrair o período do valor
            String[] partes = valor.split(", ");
            // A última parte contém o período
            String periodoDisciplina = partes[partes.length - 1].split(": ")[1];
    
            // Verificando se o período corresponde ao período atual do aluno
            if (Integer.parseInt(periodoDisciplina) == periodo) {
                rdm.append(chave).append(" => ").append(valor).append("\n");
                encontrouDisciplina = true; // Marcamos que encontramos pelo menos uma disciplina
            }
        }
    
        // Se não encontrou disciplinas no período, adiciona uma mensagem de erro
        if (!encontrouDisciplina) {
            rdm.append("Erro: Nenhuma disciplina encontrada para o período ").append(periodo).append(".\n");
        }
    
        return rdm.toString(); // Retorna a string construída
    }
}
