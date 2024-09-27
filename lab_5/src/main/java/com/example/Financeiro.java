package com.example;

import java.util.HashMap;
import java.util.Map;

public class Financeiro {
    
    HashMap<String, Float> contas;
    HashMap<String, Float> pagamentosServidores;

    public HashMap<String, Float> getContas() {
        return contas;
    }

    public HashMap<String, Float> getPagamentosServidores() {
        return pagamentosServidores;
    }

    public Financeiro() {
        contas = new HashMap<>();
        pagamentosServidores = new HashMap<>();
    }

    public void gerarFolhaDePagamento() {
        System.out.println("Folha de pagamento:");
        for (Map.Entry<String, Float> entry : pagamentosServidores.entrySet()) {
            System.out.println("Servidor: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
    }

    public void mostrarBalanco() {
        System.out.println("Balanço de contas:");
        for (Map.Entry<String, Float> entry : contas.entrySet()) {
            System.out.println("Conta: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
    }

    public String adicionarConta(float valor, String titulo, String data, String departamento) {
        if (valor <= 0 || titulo == null || data == null || departamento == null) {
            throw new IllegalArgumentException("Erro: Dados inválidos para adicionar conta.");
        }
        String descricao = titulo + " - " + data + " - " + departamento;
        contas.put(descricao, valor);
        System.out.println("Conta adicionada: " + descricao + " com valor " + valor);
        return "Conta adicionada: " + descricao + " com valor " + valor;
    }

    public String deletarConta(String titulo, String data, String departamento) {
        String descricao = titulo + " - " + data + " - " + departamento;
        if (contas.containsKey(descricao)) {
            contas.remove(descricao);
            return "Conta deletada: " + descricao;
        } else {
            return "Conta não encontrada: " + descricao;
        }
    }

    public void adicionarPagamentoServidor(float valor, String nome, String data, String departamento) {
        if (valor <= 0 || nome == null || data == null || departamento == null) {
            throw new IllegalArgumentException("Erro: Dados inválidos para adicionar pagamento.");
        }
        String descricao = nome + " - " + data + " - " + departamento;
        pagamentosServidores.put(descricao, valor);
        System.out.println("Pagamento de servidor adicionado: " + descricao + " com valor " + valor);
    }

    public String deletarPagamentoServidor(String nome, String data, String departamento) {
        String descricao = nome + " - " + data + " - " + departamento;
        if (pagamentosServidores.containsKey(descricao)) {
            pagamentosServidores.remove(descricao);
            return "Pagamento de servidor deletado: " + descricao;
        } else {
            return "Pagamento de servidor não encontrado: " + descricao;
        }
    }
}
