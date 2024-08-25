package com.example;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        ControleAcademico controleAcademico = new ControleAcademico();
                
            // Cria disciplinas
            controleAcademico.addDisciplina("Compiladores", "DISC001");
            controleAcademico.addDisciplina("Algoritmos", "DISC002");           

            //Criando matrícula do professor
            controleAcademico.criarMatriculaProfessor("Kezia", "PROF001");

            // Cria turmas com o respectivo professor e adiciona o horário
            controleAcademico.criarTurma("TURMA001",controleAcademico.getDisciplinaPorCodigo("DISC001"), controleAcademico.getProfessorPorCodigo("PROF001"));
            controleAcademico.criarTurma("TURMA002",controleAcademico.getDisciplinaPorCodigo("DISC002"), controleAcademico.getProfessorPorCodigo("PROF001"));
            

            List<Turma> turmas = controleAcademico.getTurmasPorProfessor(controleAcademico.getProfessorPorCodigo("PROF001"));
            System.out.println("Número de turmas: "+ turmas.size());
    
    }
}