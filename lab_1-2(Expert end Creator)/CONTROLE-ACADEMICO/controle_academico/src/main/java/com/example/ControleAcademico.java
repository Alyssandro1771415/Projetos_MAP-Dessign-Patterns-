package com.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControleAcademico {
    private Map<String, Professor> mapaProfessores; // Mapeia códigos de professores para objetos Professor
    private Map<String, Aluno> mapaAlunos; // Mapeia códigos de alunos para objetos Aluno
    private Map<String, Turma> mapaTurmas; // Mapeia códigos de turmas para objetos Turma
    private Map<String, MatriculaProfessor> matriculasProfessores;
    private Map<String, MatriculaAluno> matriculasArmazenadas;
    private Map<String, Disciplina> disciplinas;

    public ControleAcademico() {
        mapaProfessores = new HashMap<>();
        mapaAlunos = new HashMap<>();
        mapaTurmas = new HashMap<>();
        disciplinas = new HashMap<>();
        matriculasArmazenadas = new HashMap<>();
        matriculasProfessores = new HashMap<>();
    }

    public Disciplina addDisciplina(String nome, String codigoDisciplina) {
        Disciplina novaDisciplina = new Disciplina(nome, codigoDisciplina);
        disciplinas.put(codigoDisciplina, novaDisciplina);
        return novaDisciplina;
    }

    public Disciplina getDisciplinaPorCodigo(String codigoDisciplina) {
        return this.disciplinas.get(codigoDisciplina);
    }

    public MatriculaAluno getMatriculaPorCodigo(String codigo) {
        return this.matriculasArmazenadas.get(codigo);
    }

    public Professor criarProfessor(String nome, String codigoProf) {
        Professor professor = new Professor(nome, codigoProf);
        mapaProfessores.put(codigoProf, professor); // Adiciona ao Map
        return professor;
    }

    public Aluno criarAluno(String nome, String matricula) {
        Aluno aluno = new Aluno(nome, matricula);
        mapaAlunos.put(matricula, aluno); // Adiciona ao Map
        return aluno;
    }

    public Turma criarTurma(String codigoTurma, Disciplina disciplina, Professor professor) {
        if (!matriculasProfessores.containsKey(professor.getCodigoProf())) {
            criarMatriculaProfessor(professor.getNome(), professor.getCodigoProf());
        }
    
        MatriculaProfessor matriculaProfessor = matriculasProfessores.get(professor.getCodigoProf());
        Turma turma = new Turma(disciplina, professor);
        
        matriculaProfessor.adicionarTurma(turma);
        mapaTurmas.put(codigoTurma, turma); // Adiciona a turma ao mapa
    
        return turma;
    }

    public MatriculaAluno criarMatriculaAluno(String nome, String matriculaAluno) {
        MatriculaAluno matricula = new MatriculaAluno(nome, matriculaAluno);
        mapaAlunos.put(matriculaAluno,matricula.getAluno());
        matriculasArmazenadas.put(matriculaAluno, matricula);
        return matricula;
    }

    public MatriculaProfessor criarMatriculaProfessor(String nome, String codigoProf) {
        MatriculaProfessor matriculaProfessor = new MatriculaProfessor(nome, codigoProf);
        mapaProfessores.put(codigoProf,matriculaProfessor.getProfessor());
        matriculasProfessores.put(codigoProf, matriculaProfessor);
        return matriculaProfessor;
    }

    public void matricularAlunoEmTurma(MatriculaAluno matricula, Turma turma) {
        matricula.matricularEmTurma(turma);
    }

    public List<Turma> getTurmasPorProfessor(Professor professor) {
        List<Turma> turmas = new ArrayList<>();
        for (MatriculaProfessor matricula : this.matriculasProfessores.values()) {
            if (matricula.getProfessor().equals(professor)) {
                turmas.addAll(matricula.getTurmas());
            }
        }
        return turmas;
    }

    public List<Aluno> getAlunosPorTurma(Turma turma) {
        return turma.getListaDeAlunos();
    }

    public Aluno getAlunoPorCodigo(String codigo) {
        return this.mapaAlunos.get(codigo); // Obtém o Aluno pelo código
    }

    public Professor getProfessorPorCodigo(String codigo) {
        return this.mapaProfessores.get(codigo); // Obtém o Professor pelo código
    }

    public Turma getTurmaPorCodigo(String codigo) {
        return this.mapaTurmas.get(codigo); // Obtém a Turma pelo código
    }

    public void exibirInformacoesProfessores() {
        System.out.println("=============== Informacoes dos Professores ===============");
        System.out.println("------------------------------------------------------------");
        for (Professor professor : mapaProfessores.values()) {
            System.out.println("Disciplinas ministradas por " + professor.getNome() + ":");
            List<Turma> turmasPorProfessor = getTurmasPorProfessor(professor);
            for (Turma turma : turmasPorProfessor) {
                System.out.println("\t- " + turma.getDisciplina().getNome());
            }
            System.out.println("Horario das aulas ministradas por " + professor.getNome() + ":");
            for (Turma turma : turmasPorProfessor) {
                System.out.println("\t- " + turma.getDisciplina().getNome() + ", " + turma.getHorario());
            }
            System.out.println("------------------------------------------------------------");
        }
    }

    public void exibirInformacoesDisciplinas() {
        System.out.println("=============== Informacoes das Disciplinas ===============");
        for (Turma turma : mapaTurmas.values()) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Disciplina: " + turma.getDisciplina().getNome());
            System.out.println("Alunos Matriculados:");
            for (Aluno aluno : turma.getListaDeAlunos()) {
                System.out.println("\t- " + aluno.getNome());
            }
            System.out.println("Numero de alunos: " + turma.getNumeroDeAlunos());
        }
        System.out.println("------------------------------------------------------------");
    }

    public void exibirInformacoesAlunos() {
        System.out.println("=============== Informacoes dos Alunos ===============");
        for (MatriculaAluno matricula : matriculasArmazenadas.values()) {
            Aluno aluno = matricula.getAluno();
            System.out.println("Aluno: " + aluno.getNome() + ":");
            System.out.println("Disciplinas de " + aluno.getNome() + ":");
            for (Turma turma : matricula.getTurmas()) {
                System.out.println("\t- " + turma.getDisciplina().getNome() +" - Professor:"+ turma.getProfessor().getNome());
            }
            System.out.println("Horario das aulas de " + aluno.getNome() + ":");
            for (Turma turma : matricula.getTurmas()) {
                System.out.println("\t- " + turma.getDisciplina().getNome() + ", " + turma.getHorario());
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
