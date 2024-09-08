import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private String cpf;
    private List<Funcao> funcoes;
    private List<Filme> filmografia;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.funcoes = new ArrayList<>();
        this.filmografia = new ArrayList<>();
    }

    public void adicionarFuncao(Funcao funcao) {
        this.funcoes.add(funcao);
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

    public List<Filme> getFilmografia() {
        return this.filmografia;
    }

    public List<Filme> adicionarFilme(Filme filme) {
        this.filmografia.add(filme);
        return this.filmografia;
    }

    // Método para imprimir a filmografia de forma organizada
    public String toStringFilmografia() {
        if (this.filmografia.isEmpty()) {
            return "\n\nFilmografia: Nenhum filme associado.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Filmografia de ").append(this.nome).append(":\n");

        for (Filme filme : this.filmografia) {
            sb.append("- ").append(filme.getNome()).append(" (").append(filme.getAno()).append(")\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder funcoesDescricao = new StringBuilder();

        // Construindo a descrição das funções com um formato mais amigável
        for (Funcao funcao : this.funcoes) {
            funcoesDescricao.append("- ").append(funcao.getDescricao()).append("\n");
        }

        // Se não houver funções, adicionar uma mensagem padrão
        String descricaoFuncoes = funcoesDescricao.length() > 0 ? funcoesDescricao.toString() : "Nenhuma funcao atribuída";

        return
            "___________________________________________\n" +
            "Funcionario:\n" +
            "-----------------------------------\n" +
            "Nome: " + this.nome + "\n" +
            "CPF: " + this.cpf + "\n" +
            "Funcoes:\n" + descricaoFuncoes +
            "-----------------------------------";
    }

}
