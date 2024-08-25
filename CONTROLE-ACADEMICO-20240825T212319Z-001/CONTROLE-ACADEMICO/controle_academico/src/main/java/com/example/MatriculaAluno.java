package com.example;

import java.util.ArrayList;
import java.util.List;

public class MatriculaAluno {
    
    private Aluno aluno;
    private List<Turma> turmas;

    public MatriculaAluno(String nome, String matricula) {
        this.aluno = new Aluno(nome, matricula);
        this.turmas = new ArrayList<>();
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public List<Turma> getTurmas() {
        return this.turmas;
    }

    public void matricularEmTurma(Turma turma) {
        if (!turmas.contains(turma)) {
            turmas.add(turma);
            turma.adicionarAluno(aluno); // Adiciona o aluno na turma correspondente
        }
    }

    public int getNumeroDeTurmas() {
        return this.turmas.size();
    }
}
