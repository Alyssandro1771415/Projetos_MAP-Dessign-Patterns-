package com.example;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina;
    private List<Aluno> listaDeAlunos;
    private Professor professor;
    private String horario;

    
    public Turma(Disciplina disciplina, Professor professor) {
        this.disciplina = disciplina;
        this.listaDeAlunos = new ArrayList<>();
        this.professor = professor;
    }
    
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!listaDeAlunos.contains(aluno)) {
            listaDeAlunos.add(aluno);
        }
    }

    public int getNumeroDeAlunos() {
        return listaDeAlunos.size();
    }
}
