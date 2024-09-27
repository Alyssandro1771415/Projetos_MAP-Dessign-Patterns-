package com.example;

import java.util.ArrayList;
import java.util.List;

public class Fachada {
    private List<Pessoa> alunos;
    private List<Pessoa> professores;
    private Almoxarifado almoxarifado;
    private Infraestrutura infraestrutura;
    private Administrativo administrativo;
    private Financeiro financeiro;

    public Fachada() {
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
        almoxarifado = new Almoxarifado();
        infraestrutura = new Infraestrutura();
        administrativo = new Administrativo();
        financeiro = new Financeiro();
    }

    // Métodos para o subsistema Aluno
    public void adicionarAluno(String id, String nome, String curso) {
        if (verificaSeExisteNaLista(id, alunos)) {
            throw new IllegalArgumentException("Aluno com ID " + id + " já existe.");
        }
        alunos.add(new Aluno(id, nome, curso));
        System.out.println("Aluno adicionado com sucesso.");
    }

    private boolean verificaSeExisteNaLista(String valor, List<Pessoa> lista) {
        for (Pessoa pessoa : lista) {
            if (pessoa.getId().equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public void adicionarNoHistorico(Aluno aluno, String idTurma, String nomeDisciplina, String nomeProfessor, double nota, int faltas) {
        aluno.adicionarHistorico(idTurma, nomeDisciplina, nomeProfessor, nota, faltas);
    }

    public void mostrarHistorico(Aluno aluno) {
        System.out.println(aluno.mostrarHistorico());
    }

    public void mostrarRDM(Aluno aluno) {
        System.out.println(aluno.gerarRDM());
    }

    // Métodos para o subsistema Professor
    public void adicionarProfessor(String id, String nome, String tempoDeCasa) {
        professores.add(new Professor(id, nome, tempoDeCasa));
    }

    public void alocarDisciplina(Professor professor, String disciplina) {
        professor.alocarDisciplina(disciplina);
    }

    public void mostrarTempoDeCasa(Professor professor) {
        System.out.println(professor.getTempoDeCasa());
    }

    // Métodos para o subsistema Almoxarifado
    public void adicionarItemEstoque(String nomeItem, int quantidade) {
        almoxarifado.adicionarItem(nomeItem, quantidade);
    }

    public void mostrarEstoque() {
        System.out.println(almoxarifado.mostrarEstoque());
    }

    public void pedidoDeCompra(String nomeItem, int quantidade) {
        almoxarifado.pedidoDeCompra(nomeItem, quantidade);
    }

    // Métodos para o subsistema Infraestrutura
    public void adicionarSala(String idSala, String descricao) {
        infraestrutura.adicionarSala(idSala, descricao);
    }

    public void alocarSala(String idSala) {
        infraestrutura.alocarSala(idSala);
    }

    public String mostrarSalasDisponiveis() {
        return infraestrutura.mostrarSalasDisponiveis();
    }

    // Métodos para o subsistema Administrativo
    public void agendarReuniao(String departamento, String nome, String data, String horario) {
        administrativo.agendarReuniao(departamento, nome, data, horario);
    }

    public void marcarEntrevista(String departamento, String nomeChefeReuniao, String data, String horario) {
        administrativo.marcarEntrevista(departamento, nomeChefeReuniao, data, horario);
    }

    // Métodos para o subsistema Financeiro
    public void registrarConta(float valor, String titulo, String data, String departamento) {
        financeiro.adicionarConta(valor, titulo, data, departamento);
    }

    public void gerarRelatorioFinanceiro() {
        financeiro.gerarFolhaDePagamento();
        financeiro.mostrarBalanco();
    }
}
