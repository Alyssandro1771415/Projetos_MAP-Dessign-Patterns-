import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Filme {
    private String nome;
    private int ano;
    private String id;
    private Map<Funcionario, List<Funcao>> funcionarios; // Mapeia funcionarios para listas de funcoes
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

    public Map<Funcionario, List<Funcao>> getFuncionarios() {
        return funcionarios;
    }

    public void adicionarNoFilme(Funcionario funcionario, Funcao funcao) {
        funcionarios.computeIfAbsent(funcionario, k -> new ArrayList<>()).add(funcao);
    }

    public void atualizarFuncoes(Funcionario funcionario, Funcao novaFuncao) {
        List<Funcao> funcoes = funcionarios.get(funcionario);
        if (funcoes != null) {
            // Verifica se a função já existe
            for (Funcao funcao : funcoes) {
                if (funcao.equals(novaFuncao)) {
                    System.out.println("A função já está associada ao funcionário.");
                    return;
                }
            }
            // Adiciona a nova função se não estiver presente
            funcoes.add(novaFuncao);
        } else {
            System.out.println("Funcionário não encontrado. Primeiro adicione-o ao filme desejado.");
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
        sb.append(String.format("%-30s %-20s\n", "Funcionario", "Funcao"));
        sb.append("--------------------------------------------\n");

        // Adiciona as informacoes dos funcionarios e suas funcoes
        Set<Map.Entry<Funcionario, List<Funcao>>> entries = funcionarios.entrySet();
        for (Map.Entry<Funcionario, List<Funcao>> entry : entries) {
            Funcionario funcionario = entry.getKey();
            List<Funcao> funcoes = entry.getValue();
            for (Funcao funcao : funcoes) {
                sb.append(String.format("%-30s %-20s\n", funcionario.getNome(), funcao.getDescricao()));
            }
        }
        sb.append("_____________________________________________________________________\n");
        return sb.toString();
    }
}
