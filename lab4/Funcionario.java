import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funcionario {
    private String nome;
    private String cpf;
    private List<Funcao> funcoes;
    private Map<Filme, List<Funcao>> filmografia;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.funcoes = new ArrayList<>();
        this.filmografia = new HashMap<>();
    }

    public void adicionarFilme(Funcao funcao, Filme filme) {
        // Verifica se o filme já está na filmografia
        List<Funcao> funcoesNoFilme = this.filmografia.get(filme);

        // Se o filme não estiver na filmografia, cria uma nova lista de funcoes e
        // adiciona o filme
        if (funcoesNoFilme == null) {
            funcoesNoFilme = new ArrayList<>();
            this.filmografia.put(filme, funcoesNoFilme);
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


    public void adicionarFuncao(Filme filme, Funcao novaFuncao) {
        // Verifica se a função já está na lista de funções do funcionário
        if (this.funcoes.contains(novaFuncao)) {
            System.out.println("Erro: A função já está atribuída ao funcionário.");
            return;
        }
        
        // Adiciona a função à lista de funções do funcionário
        this.funcoes.add(novaFuncao);
        
        // Atualiza a filmografia
        List<Funcao> funcoesNoFilme = this.filmografia.get(filme);
    
        if (funcoesNoFilme == null) {
            // Se o filme não estiver na filmografia, cria uma nova lista de funções e adiciona o filme
            funcoesNoFilme = new ArrayList<>();
            this.filmografia.put(filme, funcoesNoFilme);
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

    public Map<Filme, List<Funcao>> getFilmografia() {
        return this.filmografia;
    }

    public String toStringFilmografia() {
        if (this.filmografia.isEmpty()) {
            return "\n\nFilmografia: Nenhum filme associado.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Filmografia de ").append(this.nome).append(":\n");

        // Percorre cada entrada no mapa filmografia
        for (Map.Entry<Filme, List<Funcao>> entry : this.filmografia.entrySet()) {
            Filme filme = entry.getKey();
            List<Funcao> funcoesNoFilme = entry.getValue();

            // Adiciona o nome e ano do filme
            sb.append("- ").append(filme.getNome()).append(" (").append(filme.getAno()).append(")\n");

            // Adiciona as funcoes desempenhadas pelo funcionário no filme
            sb.append("  Funcoes desempenhadas: ");
            if (funcoesNoFilme.isEmpty()) {
                sb.append("Nenhuma funcao atribuída neste filme.\n");
            } else {
                sb.append(funcoesNoFilme.stream()
                        .map(Funcao::getDescricao)
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("Nenhuma funcao atribuída neste filme.")).append("\n");
            }
        }

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
