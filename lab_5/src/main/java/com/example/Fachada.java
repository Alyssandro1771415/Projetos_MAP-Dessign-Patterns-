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
    public void adicionarAluno(String id, String nome, String curso, int periodo) {
        if (verificaSeExisteNaLista(id, alunos)) {
            throw new IllegalArgumentException("Aluno com ID " + id + " já existe.\n");
        }
        alunos.add(new Aluno(id, nome, curso, periodo));
        System.out.println("Aluno de ID "+id +" de nome " + nome + " do curso '" + curso +"' "+ "adicionado com sucesso.\n");
    }

    public Aluno buscarAlunoPorId(String id) {
        for (Pessoa pessoa : alunos) {
            if (pessoa.getId().equals(id) && pessoa instanceof Aluno) {
                return (Aluno) pessoa;
            }
        }
        throw new IllegalArgumentException("Aluno com ID " + id + " não encontrado.");
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
    
    public Professor buscarProfessorPorId(String id) {
        for (Pessoa pessoa : professores) {
            if (pessoa.getId().equals(id) && pessoa instanceof Professor) {
                return (Professor) pessoa;
            }
        }
        throw new IllegalArgumentException("Professor com ID " + id + " não encontrado.");
    }

    public String getNomeProfessorPorId(String id) {
        for (Pessoa pessoa : professores) {
            if (pessoa.getId().equals(id) && pessoa instanceof Professor) {
                return pessoa.getNome();
            }
        }
        throw new IllegalArgumentException("Professor com ID " + id + " não encontrado.");
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

    public String mostrarEstoque() {
        System.out.println(almoxarifado.mostrarEstoque());
        return almoxarifado.mostrarEstoque();
    }

    public String pedidoDeCompra(String nomeItem, int quantidade) {
        String string = almoxarifado.pedidoDeCompra(nomeItem, quantidade);
        return string;
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
    public String agendarReuniao(String departamento, String nome, String data, String horario) {
        String string = administrativo.agendarReuniao(departamento, nome, data, horario);
        return string;
    }

    public void marcarEntrevista(String departamento, String nomeChefeReuniao, String data, String horario) {
        administrativo.marcarEntrevista(departamento, nomeChefeReuniao, data, horario);
    }

    // Métodos para o subsistema Financeiro
    public String registrarConta(float valor, String titulo, String data, String departamento) {
        String string = financeiro.adicionarConta(valor, titulo, data, departamento);
        return string;
    }

    public void gerarRelatorioFinanceiro() {
        financeiro.gerarFolhaDePagamento();
        financeiro.mostrarBalanco();
    }

    // - Métodos adicionais

    private boolean verificaSeExisteNaLista(String valor, List<Pessoa> lista) {
        for (Pessoa pessoa : lista) {
            if (pessoa.getId().equals(valor)) {
                return true;
            }
        }
        return false;
    }
    
}
