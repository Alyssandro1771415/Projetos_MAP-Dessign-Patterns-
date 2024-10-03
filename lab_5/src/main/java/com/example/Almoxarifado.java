package com.example;

import java.util.HashMap;

public class Almoxarifado {
    private HashMap<String, Integer> estoque;

    public Almoxarifado() {
        estoque = new HashMap<>(); 
    }

    public void adicionarItem(String nomeItem, int quantidade) {
        if (nomeItem == null || quantidade <= 0) {
            throw new IllegalArgumentException("Erro: Dados inválidos para adicionar item ao estoque.");
        }
        estoque.put(nomeItem, estoque.getOrDefault(nomeItem, 0) + quantidade);
        System.out.println("\nItem adicionado ao estoque: " + nomeItem + ", Quantidade: " + quantidade);
    }

    public String mostrarEstoque() {
        if (estoque.isEmpty()) {
            return "Estoque vazio. Nenhum item disponível.";
        }
        StringBuilder resultado = new StringBuilder();
        resultado.append("\nEstoque Atual:\n");
        for (String item : estoque.keySet()) {
            resultado.append(item).append(": ").append(estoque.get(item)).append(" unidades\n");
        }
        return resultado.toString();
    }

    public String pedidoDeCompra(String nomeItem, int quantidade) {
        if (nomeItem == null || quantidade <= 0) {
            throw new IllegalArgumentException("Erro: Dados inválidos para pedido de compra.");
        }
        if (estoque.containsKey(nomeItem)) {
            return "Pedido de compra não necessário. Item disponível: " + nomeItem + ".";
        } else {
            return "Pedido de compra registrado para " + nomeItem + " com quantidade " + quantidade + ".";
        }
    }
}
