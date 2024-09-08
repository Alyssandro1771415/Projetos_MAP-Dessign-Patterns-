import java.util.HashMap;
import java.util.Map;

public class ControleDeAcesso {
    private Map<String, Filme> filmes; // Mapa para filmes usando o código do filme
    private Map<String, Funcionario> funcionarios; // Mapa para funcionários usando o CPF
    int ATOR = 1; int DIRETOR = 2; int ROTEIRISTA = 3; int PRODUTOR = 4;int CINEGRAFISTA = 5;int CAMERA = 6;
    
    public ControleDeAcesso() {
        this.filmes = new HashMap<>();
        this.funcionarios = new HashMap<>();
    }

    public Funcionario cadastrarFuncionario(String nomeFuncionario, String funcionarioCPF) {
        
        Funcionario novoFuncionario = new Funcionario(nomeFuncionario, funcionarioCPF);
        funcionarios.put(funcionarioCPF, novoFuncionario); 
        System.out.println("Funcionario cadastrado com sucesso!");

        return novoFuncionario;
    }

    public void adicionarEmElenco(String filmeId, String funcionarioCpf) {
        Filme filme = filmes.get(filmeId);
        Funcionario funcionario = getFuncionario(funcionarioCpf);
    
        // Adiciona o funcionário ao elenco do filme
        filme.adicionarAoElenco(funcionario);
    
        // Verifica se o filme já está na filmografia do funcionário
        if (funcionario.getFilmografia().contains(filme)) {
            funcionario.getFilmografia().remove(filme); // Remove o filme existente
        }
        // Adiciona o filme atualizado à filmografia
        funcionario.adicionarFilme(filme);
    }
    
    public void adicionarNaProducao(String filmeId, String funcionarioCpf) {
        Filme filme = filmes.get(filmeId);
        Funcionario funcionario = getFuncionario(funcionarioCpf);
    
        // Adiciona o funcionário à produção do filme
        filme.adicionarNaProducao(funcionario);
    
        // Verifica se o filme já está na filmografia do funcionário
        if (funcionario.getFilmografia().contains(filme)) {
            funcionario.getFilmografia().remove(filme); // Remove o filme existente
        }
        // Adiciona o filme atualizado à filmografia
        funcionario.adicionarFilme(filme);
    }
    
    public Filme cadastrarFilme(String nomeFilme, int anoFilme, String filmeId) {
        Filme novoFilme = new Filme(nomeFilme, anoFilme, filmeId);
        filmes.put(filmeId, novoFilme); 
        System.out.println("\nFilme cadastrado com sucesso!\n");
        return novoFilme;
    }

    public void obterFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            System.out.println("\nFilmes cadastrados:");
            for (Filme filme : filmes.values()) {
                System.out.println(filme);
            }
        }
    }

    public Funcionario getFuncionario(String cpf) {
        return funcionarios.get(cpf);
    }

    public Filme getFilme(String filmeId) {
        return filmes.get(filmeId);
    }
}
