import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControleDeAcesso {
    private Map<String, Filme> filmes; // Mapa para filmes usando o código do filme
    private Map<String, Funcionario> funcionarios; // Mapa para funcionários usando o CPF
    public static final Funcao ATOR = new Ator();
    public static final Funcao DIRETOR = new Diretor();
    public static final Funcao ROTEIRISTA = new Roteirista();
    public static final Funcao PRODUTOR = new Produtor();
    public static final Funcao CINEGRAFISTA = new Cinegrafista();
    public static final Funcao CAMERA = new Camera();

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

    public void adicionarAoFilme(String filmeId, String funcionarioCpf, Funcao funcao) {
        Filme filme = filmes.get(filmeId);
        Funcionario funcionario = getFuncionario(funcionarioCpf);

        // Adiciona o funcionário ao elenco geral do filme na classe FILME
        filme.adicionarNoFilme(funcionario, funcao);
        // Adiciona o filme na filmografia do usuario junto de sua funcao especifica neste filme
        funcionario.adicionarFilme(funcao, filme);
    }

    public void atualizarFuncaoEmFilme(String filmeId, String funcionarioCpf, Funcao funcao){
        Filme filme = filmes.get(filmeId);
        Funcionario funcionario = getFuncionario(funcionarioCpf);

        // Adiciona o funcionário ao elenco geral do filme na classe FILME
        filme.atualizarFuncoes(funcionario, funcao);
        // Adiciona o filme na filmografia do usuario junto de sua funcao especifica neste filme
        funcionario.adicionarFuncao(filme, funcao);
    }

    public Filme cadastrarFilme(String nomeFilme, int anoFilme, String filmeId) {
        Filme novoFilme = new Filme(nomeFilme, anoFilme, filmeId);
        filmes.put(filmeId, novoFilme);
        System.out.println("\nFilme '" + nomeFilme + "' cadastrado com sucesso!\n");
        return novoFilme;
    }

    public void obterFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            System.out.print("----------------------------------------------\nFilmes cadastrados:\n");
            for (Filme filme : filmes.values()) {
                System.out.println(filme.toString());
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
