package com.example;

public class Main {
        public static void main(String[] args) {
            // Cria uma instância do controle acadêmico
            ControleAcademico controleAcademico = new ControleAcademico();
                
            // Cria disciplinas
            controleAcademico.addDisciplina("Compiladores", "DISC001");
            controleAcademico.addDisciplina("Algoritmos", "DISC002");           

            //Criando matrícula do professor
            controleAcademico.criarMatriculaProfessor("Kezia", "PROF001");
            controleAcademico.criarMatriculaProfessor("Leona", "PROF002");

            // Cria turmas com o respectivo professor e adiciona o horário
            controleAcademico.criarTurma("TURMA001",controleAcademico.getDisciplinaPorCodigo("DISC001"), controleAcademico.getProfessorPorCodigo("PROF001"));
            controleAcademico.getTurmaPorCodigo("TURMA001").setHorario("Segunda -> 14:00h-16:00h");

            controleAcademico.criarTurma("TURMA002",controleAcademico.getDisciplinaPorCodigo("DISC002"), controleAcademico.getProfessorPorCodigo("PROF002"));
            controleAcademico.getTurmaPorCodigo("TURMA002").setHorario("Quarta -> 18:00h-20:00h");
            
    
            // Cria alunos e suas matrículas
            controleAcademico.criarMatriculaAluno("Danilo", "ALUNO001");
            controleAcademico.criarMatriculaAluno("Alyssandro", "ALUNO002");
    
            // Matricula alunos em turmas
            controleAcademico.matricularAlunoEmTurma(controleAcademico.getMatriculaPorCodigo("ALUNO002"), controleAcademico.getTurmaPorCodigo("TURMA001"));
            controleAcademico.matricularAlunoEmTurma(controleAcademico.getMatriculaPorCodigo("ALUNO002"), controleAcademico.getTurmaPorCodigo("TURMA002"));
            controleAcademico.matricularAlunoEmTurma(controleAcademico.getMatriculaPorCodigo("ALUNO001"), controleAcademico.getTurmaPorCodigo("TURMA001"));
    
            
            // Exibindo informações
            controleAcademico.exibirInformacoesProfessores();
            controleAcademico.exibirInformacoesDisciplinas();
            controleAcademico.exibirInformacoesAlunos();
    
            System.out.println("Finalizando...");
        }
    }
    