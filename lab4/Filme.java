import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Filme {
    private String filmeId;
    private String nome;
    private Funcionario diretor;
    private Funcionario roteirista;
    private List<String> listaTrilhaSonora;
    private int ano;
    private Map<String, Funcionario> elenco;
    private Map<String, Funcionario> produtores;

    public Filme(String nome, int ano, String filmeId) {
        this.nome = nome;
        this.ano = ano;
        this.filmeId = filmeId;
        this.elenco = new HashMap<>();
        this.produtores = new HashMap<>();
        this.listaTrilhaSonora = new ArrayList<>();
    }

    public void setProdutores(Map<String, Funcionario> produtores) {
        this.produtores = produtores;
    }

    public List<Funcao> atribuirFuncaoFuncionario(String cpf, int opcao) {
        
        Funcionario funcionario = elenco.get(cpf);
        if (funcionario == null) {
            System.out.println("Funcionario não encontrado no elenco.");
            return null;
        }

        try {
            System.out.print("Nome do funcionario: "+funcionario.getNome() + " , ");
            switch (opcao) {
                case 1:
                    System.out.println("Funcao escolhida: Ator");
                    funcionario.adicionarFuncao(new Ator());
                    break;
                case 2:
                    System.out.println("Funcao escolhida: Diretor");
                    funcionario.adicionarFuncao(new Diretor());
                    setDiretor(funcionario); 
                    break;
                case 3:
                    System.out.println("Funcao escolhida: Roteirista");
                    funcionario.adicionarFuncao(new Roteirista());
                    setRoteirista(funcionario); 
                    break;
                case 4:
                    System.out.println("Funcao escolhida: Produtor");
                    if (produtores.containsKey(cpf)) {
                        System.out.println("O funcionario ja esta como produtor.");
                    } else {
                        funcionario.adicionarFuncao(new Produtor());
                        adicionarNaProducao(funcionario);
                    }
                    break;
                case 5:
                    System.out.println("Funcao escolhida: Cinegrafista");
                    funcionario.adicionarFuncao(new Cinegrafista());
                    break;
                case 6:
                    System.out.println("Funcao escolhida: Camera");
                    funcionario.adicionarFuncao(new Camera());
                    break;
                case 0:
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Entrada invalida.");
            return null;
        }
        
        return funcionario.getFuncoes();
    }

    public String getFilmeId() {
        return this.filmeId;
    }

    public void setDiretor(Funcionario diretor) {
        this.diretor = diretor;
    }

    public void setRoteirista(Funcionario roteirista) {
        this.roteirista = roteirista;
    }

    public void setTrilhaSonora(String trilhaSonora) {
        this.listaTrilhaSonora.add(trilhaSonora);
    }

    public void adicionarAoElenco(Funcionario funcionario) {
        if (!elenco.containsKey(funcionario.getCpf())) {
            elenco.put(funcionario.getCpf(), funcionario);
        }
    }

    public void adicionarNaProducao(Funcionario funcionario) {
        if (!produtores.containsKey(funcionario.getCpf())) {
            produtores.put(funcionario.getCpf(), funcionario);
        }
    }

    public String getNome() {
        return this.nome;
    }

    public int getAno() {
        return this.ano;
    }

    public Funcionario getDiretor() {
        return this.diretor;
    }

    public Funcionario getRoteirista() {
        return this.roteirista;
    }

    public List<String> getTrilhaSonora() {
        return this.listaTrilhaSonora;
    }

    public Map<String, Funcionario> getElenco() {
        return this.elenco;
    }

    public Map<String, Funcionario> getProdutores() {
        return this.produtores;
    }

    @Override
    public String toString() {
        String elencoNomes = elenco.values().stream()
                .map(Funcionario::getNome)
                .reduce((a, b) -> a + ", " + b)
                .orElse("Nenhum");

        String produtoresNomes = produtores.values().stream()
                .map(Funcionario::getNome)
                .reduce((a, b) -> a + ", " + b)
                .orElse("Nenhum");

        String trilhaSonoraNomes = listaTrilhaSonora.stream()
                .reduce((a, b) -> a + ", " + b)
                .orElse("Nenhum");

        return "\n\n\nFilme: " + nome + "\n" + "Numero Identificador: " + this.filmeId + "\n" +
               "Diretor: " + (diretor != null ? diretor.getNome() : "Nao informado") + "\n" +
               "Roteirista: " + (roteirista != null ? roteirista.getNome() : "Nao informado") + "\n" +
               "Trilha Sonora: " + trilhaSonoraNomes + "\n" +
               "Ano: " + ano + "\n" +
               "Elenco: " + elencoNomes + "\n" +
               "Producao: " + produtoresNomes;
    }
}
