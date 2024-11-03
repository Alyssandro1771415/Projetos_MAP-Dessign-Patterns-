package com.example;

import java.util.ArrayList;
import java.util.List;

public class MatriculaProfessor {
    private Professor professor;
    private List<Turma> turmas;

    public MatriculaProfessor(String nome, String codigoProf) {
        this.professor = new Professor(nome, codigoProf);
        this.turmas = new ArrayList<>();
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void adicionarTurma(Turma turma) {
        if (!turmas.contains(turma)) {
            turmas.add(turma);
            turma.setProfessor(professor); // Define o professor para a turma
        }
    }

    public int getNumeroDeTurmas() {
        return turmas.size();
    }
}
