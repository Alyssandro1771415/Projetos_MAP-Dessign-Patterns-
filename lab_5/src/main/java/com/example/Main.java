package com.example;

public class Main {
    public static void main(String[] args) {
        Fachada fachada = new Fachada();

        // Adicionando alunos
        fachada.adicionarAluno("A001", "Valerio", "Computacao", 5);
        fachada.adicionarAluno("A002", "Danilo", "Odontologia", 2);
        fachada.adicionarAluno("A003", "Alyssandro", "Computacao", 1);

        // Adicionando professor
        fachada.adicionarProfessor("P003", "Guanabara", "20 anos");
        fachada.alocarDisciplina(fachada.buscarProfessorPorId("P003"), "Programacao");

        fachada.adicionarNoHistorico(fachada.buscarAlunoPorId("A001"), "T001", "Programacao V",
                fachada.buscarProfessorPorId("P003").getNome(), 9.5, 2);
        fachada.adicionarNoHistorico(fachada.buscarAlunoPorId("A001"), "T002", "Banco de Dados",
                fachada.buscarProfessorPorId("P003").getNome(), 9.5, 2);
        fachada.mostrarHistorico(fachada.buscarAlunoPorId("A001"));
        fachada.mostrarRDM(fachada.buscarAlunoPorId("A001"));

        // Mostrando tempo de casa do professor
        fachada.mostrarTempoDeCasa(fachada.buscarProfessorPorId("P003"));

    }
}
