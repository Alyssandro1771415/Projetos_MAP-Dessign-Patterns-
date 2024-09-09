package lab_4;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Filme {
    private String nome, id;
    private int ano;
    private Map<String, Map<String, List<String>>> funcionarios; // CPF -> Nome -> Lista de funções
    private String trilhaSonora;

    public Filme(String nome, int ano, String id) {
        this.nome = nome;
        this.ano = ano;
        this.id = id;
        this.funcionarios = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public String getId() {
        return id;
    }

    public Map<String, Map<String, List<String>>> getFuncionarios() {
        return funcionarios;
    }

    public boolean adicionarNoFilme(String cpf, String nome, String funcao) {
        // Adiciona um novo mapa se o CPF ainda não estiver presente
        Map<String, List<String>> mapaNomeFuncoes = funcionarios.computeIfAbsent(cpf, k -> new HashMap<>());

        // Adiciona uma nova lista de funções se o nome ainda não estiver presente
        List<String> listaFuncoes = mapaNomeFuncoes.computeIfAbsent(nome, k -> new ArrayList<>());

        // Adiciona a função se não estiver presente
        if (!listaFuncoes.contains(funcao)) {
            listaFuncoes.add(funcao);
            return true;
        } else {
            System.out.println("A função já está associada ao funcionário.");
            return false;
        }
    }

    public void atualizarFuncoes(String cpf, String nome, String novaFuncao) {
        Map<String, List<String>> mapaNomeFuncoes = funcionarios.get(cpf);
        if (mapaNomeFuncoes != null) {
            List<String> listaFuncoes = mapaNomeFuncoes.get(nome);
            if (listaFuncoes != null) {
                if (!listaFuncoes.contains(novaFuncao)) {
                    listaFuncoes.add(novaFuncao);
                } else {
                    System.out.println("A função já está associada ao funcionário.");
                }
            } else {
                System.out.println("Nome do funcionário não encontrado.");
            }
        } else {
            System.out.println("CPF não encontrado.");
        }
    }

    public void setTrilhaSonora(String trilhaSonora) {
        this.trilhaSonora = trilhaSonora;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("_____________________________________________________________________\n");
        sb.append(String.format("Filme: %s (%d)\n", nome, ano));
        sb.append(String.format("Trilha sonora: %s\n", trilhaSonora));
        sb.append("\nFuncionarios e Funcoes:\n");
        sb.append(String.format("%-30s %-30s %-20s\n", "CPF", "Funcionario", "Funcao"));
        sb.append("--------------------------------------------------------------------\n");

        // Adiciona as informações dos funcionários e suas funções
        for (Map.Entry<String, Map<String, List<String>>> entryCpf : funcionarios.entrySet()) {
            String cpf = entryCpf.getKey();
            Map<String, List<String>> mapaNomeFuncoes = entryCpf.getValue();
            for (Map.Entry<String, List<String>> entryNome : mapaNomeFuncoes.entrySet()) {
                String nome = entryNome.getKey();
                List<String> funcoes = entryNome.getValue();
                for (String funcao : funcoes) {
                    sb.append(String.format("%-30s %-30s %-20s\n", cpf, nome, funcao));
                }
            }
        }
        sb.append("_____________________________________________________________________\n");
        return sb.toString();
    }
}
