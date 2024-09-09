import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab_4.ControleDeAcesso;
import lab_4.Filme;
import lab_4.Funcao;
import lab_4.Funcionario;

import java.util.List;
import java.util.Map;

public class TesteControleDeAcesso {

    private ControleDeAcesso controleDeAcesso;
    private Funcionario Danilo;
    private Filme somosTaoJovens;

    @BeforeEach
    public void setup() {
        controleDeAcesso = new ControleDeAcesso();
        Danilo = controleDeAcesso.cadastrarFuncionario("Danilo", "123.645.265-87");
        somosTaoJovens = controleDeAcesso.cadastrarFilme("Somos Tão Jovens", 2013, "596");
    }

    @Test
    public void testeCadastrarFuncionario() {
        Funcionario funcionario = controleDeAcesso.cadastrarFuncionario("João", "987.654.321-00");
        assertNotNull(funcionario);
        assertEquals("João", funcionario.getNome());
        assertEquals("987.654.321-00", funcionario.getCpf());
    }

    @Test
    public void testeCadastrarFilme() {
        Filme filme = controleDeAcesso.cadastrarFilme("Cidade de Deus", 2002, "987");
        assertNotNull(filme);
        assertEquals("Cidade de Deus", filme.getNome());
        assertEquals(2002, filme.getAno());
        assertEquals("987", filme.getId());
    }

    @Test
    public void testeAdicionarAoFilme() {
        controleDeAcesso.adicionarAoFilme("596", "123.645.265-87", ControleDeAcesso.ATOR);

        Map<String, Map<String, List<String>>> funcionarios = somosTaoJovens.getFuncionarios();
        assertTrue(funcionarios.containsKey("123.645.265-87")); 
        assertTrue(funcionarios.get("123.645.265-87").containsKey("Danilo")); 
        assertTrue(funcionarios.get("123.645.265-87").get("Danilo").contains("Ator"));
    }

    @Test
    public void testeAtualizarFuncaoEmFilme() {
        controleDeAcesso.adicionarAoFilme("596", "123.645.265-87", ControleDeAcesso.ATOR);
        
        controleDeAcesso.atualizarFuncaoEmFilme("596", "123.645.265-87", ControleDeAcesso.DIRETOR);

        Map<String, Map<String, List<String>>> funcionarios = somosTaoJovens.getFuncionarios();
        assertTrue(funcionarios.containsKey("123.645.265-87"));
        assertTrue(funcionarios.get("123.645.265-87").get("Danilo").contains("Ator"));
        assertTrue(funcionarios.get("123.645.265-87").get("Danilo").contains("Diretor"));
    }

    @Test
    public void testeObterFilmes() {
        controleDeAcesso.cadastrarFilme("Cidade de Deus", 2002, "987");

        controleDeAcesso.obterFilmes();
    }

    @Test
    public void testeGetFuncionario() {
        Funcionario funcionario = controleDeAcesso.getFuncionario("123.645.265-87");
        assertNotNull(funcionario);
        assertEquals("Danilo", funcionario.getNome());
    }

    @Test
    public void testeGetFilme() {
        Filme filme = controleDeAcesso.getFilme("596");
        assertNotNull(filme);
        assertEquals("Somos Tão Jovens", filme.getNome());
        assertEquals(2013, filme.getAno());
    }
}
