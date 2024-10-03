package com.example;

public class Main {
    public static void main(String[] args) {
        try {
            Fachada fachada = new Fachada();

            // Adicionando alunos
            try {
                fachada.adicionarAluno("A001", "Valerio", "Computacao", 5);
                fachada.adicionarAluno("A002", "Danilo", "Odontologia", 2);
                fachada.adicionarAluno("A003", "Alyssandro", "Computacao", 1);
            } catch (Exception e) {
                System.out.println("Erro ao adicionar aluno: " + e.getMessage());
            }

            // Adicionando professor
            try {
                fachada.adicionarProfessor("P003", "Guanabara", "20 anos");
                fachada.alocarDisciplina(fachada.buscarProfessorPorId("P003"), "Programacao");
            } catch (Exception e) {
                System.out.println("Erro ao adicionar professor ou alocar disciplina: " + e.getMessage());
            }

            // Adicionando histórico para o aluno
            try {
                fachada.adicionarNoHistorico(fachada.buscarAlunoPorId("A001"), "T001", "Programacao V",
                        fachada.buscarProfessorPorId("P003").getNome(), 9.5, 2);
                fachada.adicionarNoHistorico(fachada.buscarAlunoPorId("A001"), "T002", "Banco de Dados",
                        fachada.buscarProfessorPorId("P003").getNome(), 9.5, 2);
            } catch (Exception e) {
                System.out.println("Erro ao adicionar histórico: " + e.getMessage());
            }

            // Mostrar histórico e RDM do aluno
            try {
                fachada.mostrarHistorico(fachada.buscarAlunoPorId("A001"));
                fachada.mostrarRDM(fachada.buscarAlunoPorId("A001"));
            } catch (Exception e) {
                System.out.println("Erro ao mostrar histórico ou RDM: " + e.getMessage());
            }

            // Mostrando tempo de casa do professor
            try {
                fachada.mostrarTempoDeCasa(fachada.buscarProfessorPorId("P003"));
            } catch (Exception e) {
                System.out.println("Erro ao mostrar tempo de casa do professor: " + e.getMessage());
            }

            // Adicionar itens ao Almoxarifado
            try {
                fachada.adicionarItemEstoque("Projetor", 5);
                fachada.adicionarItemEstoque("Computador", 10);
            } catch (Exception e) {
                System.out.println("Erro ao adicionar item ao estoque: " + e.getMessage());
            }

            // Mostrar estoque atual
            try {
                fachada.mostrarEstoque();
            } catch (Exception e) {
                System.out.println("Erro ao mostrar estoque: " + e.getMessage());
            }

            // Adicionando uma sala
            try {
                fachada.adicionarSala("C101", "Sala de Reuniões Administrativas");
                fachada.adicionarSala("C102", "Sala de Reuniões Administrativas");
            } catch (Exception e) {
                System.out.println("Erro ao adicionar sala: " + e.getMessage());
            }

            // Alocando sala
            try {
                fachada.alocarSala("C101");
            } catch (Exception e) {
                System.out.println("Erro ao alocar sala: " + e.getMessage());
            }

            // Apresentando salas disponíveis
            try {
                System.out.println(fachada.mostrarSalasDisponiveis());
            } catch (Exception e) {
                System.out.println("Erro ao mostrar salas disponíveis: " + e.getMessage());
            }

            // Agendar Reunião Administrativa
            try {
                fachada.agendarReuniao("Treinamento", "Reunião de treinamento de estagiários", "14/05/2024", "18:00");
            } catch (Exception e) {
                System.out.println("Erro ao agendar reunião: " + e.getMessage());
            }

            // Marcando Entrevista
            try {
                fachada.marcarEntrevista("Treinamento", "José Klaudio", "30/09/2024", "07:30");
            } catch (Exception e) {
                System.out.println("Erro ao marcar entrevista: " + e.getMessage());
            }

            // Adicionando pagamento para servidor ao sistema
            try {
                fachada.registrarPagamentoServidor(10000, "Antenor", "28/09/2024", "Vendas");
                fachada.registrarPagamentoServidor(20000, "Gabrielly", "31/05/2024", "T.I");
            } catch (Exception e) {
                System.out.println("Erro ao registrar pagamento do servidor: " + e.getMessage());
            }

            // Registro de Conta Financeira
            try {
                fachada.registrarConta(4000, "Conserto de computadores", "27/09/2024", "Finanças");
                fachada.registrarConta(1500, "Compra de bancadas", "01/09/2024", "Vendas");
            } catch (Exception e) {
                System.out.println("Erro ao registrar conta financeira: " + e.getMessage());
            }

            // Registro Financeiro
            try {
                fachada.gerarRelatorioFinanceiro();
            } catch (Exception e) {
                System.out.println("Erro ao gerar relatório financeiro: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Erro no sistema: " + e.getMessage());
        }
    }
}
