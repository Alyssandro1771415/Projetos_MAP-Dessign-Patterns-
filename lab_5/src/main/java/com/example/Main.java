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

        // Adicionando histórico para o aluno
        fachada.adicionarNoHistorico(fachada.buscarAlunoPorId("A001"), "T001", "Programacao V",
                fachada.buscarProfessorPorId("P003").getNome(), 9.5, 2);
        fachada.adicionarNoHistorico(fachada.buscarAlunoPorId("A001"), "T002", "Banco de Dados",
                fachada.buscarProfessorPorId("P003").getNome(), 9.5, 2);

        // Mostrar histórico e RDM do aluno
        fachada.mostrarHistorico(fachada.buscarAlunoPorId("A001"));
        fachada.mostrarRDM(fachada.buscarAlunoPorId("A001"));

        // Mostrando tempo de casa do professor
        fachada.mostrarTempoDeCasa(fachada.buscarProfessorPorId("P003"));

        // Adicionar itens ao Almoxarifado
        fachada.adicionarItemEstoque("Projetor", 5);
        fachada.adicionarItemEstoque("Computador", 10);

        // Mostrar estoque atual
        fachada.mostrarEstoque();

        // Adicionando uma sala
        fachada.adicionarSala("C101", "Sala de Reuniões Administrativas");
        fachada.adicionarSala("C102", "Sala de Reuniões Administrativas");

        // Alocando sala
        fachada.alocarSala("C101");

        // Apresentando salas disponíveis
        System.out.println(fachada.mostrarSalasDisponiveis());

        // Agendar Reunião Administrativa
        fachada.agendarReuniao("Treinamento", "Reunião de treinamento de estagiários", "14/05/2024", "18:00");

        // Marcando Entrevista
        fachada.marcarEntrevista("Treinamento", "José Klaudio", "30/09/2024", "07:30");

        // Registro de Conta Financeira
        fachada.registrarConta(1000000,"Conta Principal", "27/09/2024", "Finanças");

        // Registro Financeiro
        fachada.gerarRelatorioFinanceiro();
    }
}
