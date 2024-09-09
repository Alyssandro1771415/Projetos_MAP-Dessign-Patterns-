package lab_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funcionario {
    private String nome;
    private String cpf;
    private List<Funcao> funcoes;
    private Map<String, List<Funcao>> filmografia; // NomeFilme/FuncaoNoFilme

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.funcoes = new ArrayList<>();
        this.filmografia = new HashMap<>();
    }

    public void adicionarFilme(Funcao funcao, String filmeCodigo) {
        // Verifica se o filme já está na filmografia
        List<Funcao> funcoesNoFilme = this.filmografia.get(filmeCodigo);

        // Se o filme não estiver na filmografia, cria uma nova lista de funcoes e
        // adiciona o filme
        if (funcoesNoFilme == null) {
            funcoesNoFilme = new ArrayList<>();
            this.filmografia.put(filmeCodigo, funcoesNoFilme);
        }

        // Adiciona a funcao à lista de funcoes para o filme
        if (!funcoesNoFilme.contains(funcao)) {
            funcoesNoFilme.add(funcao);
        }

        /*  Adiciona a funcao à lista de funcoes do funcionário se ainda não estiver
        presente*/
        if (!this.funcoes.contains(funcao)) {
            this.funcoes.add(funcao);
        }
    }


    public void adicionarFuncao(String filmeCodigo, Funcao novaFuncao) {
        // Verifica se a função já está na lista de funções do funcionário
        if (this.funcoes.contains(novaFuncao)) {
            System.out.println("Erro: A função já está atribuída ao funcionário.");
            return;
        }
        
        // Adiciona a função à lista de funções do funcionário
        this.funcoes.add(novaFuncao);
        
        // Atualiza a filmografia
        List<Funcao> funcoesNoFilme = this.filmografia.get(filmeCodigo);
    
        if (funcoesNoFilme == null) {
            // Se o filme não estiver na filmografia, cria uma nova lista de funções e adiciona o filme
            funcoesNoFilme = new ArrayList<>();
            this.filmografia.put(filmeCodigo, funcoesNoFilme);
        }
    
        // Verifica se a função já está associada ao filme
        if (funcoesNoFilme.contains(novaFuncao)) {
            System.out.println("Erro: A função já está atribuída ao filme para este funcionário.");
        } else {
            // Adiciona a nova função à lista de funções para o filme
            funcoesNoFilme.add(novaFuncao);
        }
    }
    

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public List<Funcao> getFuncoes() {
        return this.funcoes;
    }

    public Map<String, List<Funcao>> getFilmografia() {
        return this.filmografia;
    }

    public String toStringFilmografia() {
        StringBuilder sb = new StringBuilder();
        sb.append("_____________________________________________________________________\n");
        sb.append("Filmografia de: " + this.nome + "\n");
        sb.append(String.format("%-30s %-30s\n", "Filme", "Funcao"));
        sb.append("--------------------------------------------\n");

        // Adiciona as informações da filmografia
        for (Map.Entry<String, List<Funcao>> entry : filmografia.entrySet()) {
            String filme = entry.getKey();
            List<Funcao> funcoes = entry.getValue();
            for (Funcao funcao : funcoes) {
                sb.append(String.format("%-30s %-30s\n", filme, funcao.getDescricao()));
            }
        }

        sb.append("_____________________________________________________________________\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder funcoesDescricao = new StringBuilder();

        // Construindo a descricao das funcoes com um formato mais amigável
        for (Funcao funcao : this.funcoes) {
            funcoesDescricao.append("- ").append(funcao.getDescricao()).append("\n");
        }

        // Se não houver funcoes, adicionar uma mensagem padrão
        String descricaoFuncoes = funcoesDescricao.length() > 0 ? funcoesDescricao.toString()
                : "Nenhuma funcao atribuída";

        return "___________________________________________\n" +
                "Funcionario: " + this.nome + "\n" +
                "CPF: " + this.cpf + "\n" +
                "Funcoes:\n" + descricaoFuncoes +
                "___________________________________________";
    }
}
