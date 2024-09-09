import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab_4.Filme;

public class TesteFilme {

    Filme somosTaoJovens;
    String cpfDanilo;
    String danilo;
    String ator;
    String diretor;

    @BeforeEach
    public void setup() {
        somosTaoJovens = new Filme("Somos Tão Jovens", 2013, "596");
        cpfDanilo = "123.456.789-98";
        danilo = "Danilo";
        ator = "Ator";
        diretor = "Diretor";
    }

    @Test
    public void testGetNome() {
        assertEquals("Somos Tão Jovens", somosTaoJovens.getNome());
        assertNotEquals("Somos_Tão_Jovens", somosTaoJovens.getNome());
    }

    @Test
    public void testGetAno() {
        assertEquals(2013, somosTaoJovens.getAno());
        assertNotEquals(2024, somosTaoJovens.getAno());
        assertNotEquals("2013", somosTaoJovens.getAno());
    }

    @Test
    public void testGetId() {
        assertEquals("596", somosTaoJovens.getId());
        assertNotEquals("569", somosTaoJovens.getId());
        assertNotEquals(596, somosTaoJovens.getId());
    }

    @Test
    public void testeAdicionarNoFilme() {
        boolean adicionou = somosTaoJovens.adicionarNoFilme(cpfDanilo, danilo, ator);
        assertTrue(adicionou);
    }

    @Test
    public void testeGetFuncionarios() {
        somosTaoJovens.adicionarNoFilme(cpfDanilo, danilo, ator);

        Map<String, Map<String, List<String>>> funcionarios = somosTaoJovens.getFuncionarios();
        assertTrue(funcionarios.containsKey(cpfDanilo));
        assertTrue(funcionarios.get(cpfDanilo).containsKey(danilo));
        assertTrue(funcionarios.get(cpfDanilo).get(danilo).contains(ator));
    }

    @Test
    public void testeAtualizarFuncoes() {
        somosTaoJovens.adicionarNoFilme(cpfDanilo, danilo, ator);
        somosTaoJovens.atualizarFuncoes(cpfDanilo, danilo, diretor);

        List<String> funcoesEsperadas = new ArrayList<>();
        funcoesEsperadas.add(ator);
        funcoesEsperadas.add(diretor);

        assertEquals(funcoesEsperadas, somosTaoJovens.getFuncionarios().get(cpfDanilo).get(danilo));
    }

    @Test
    public void testeAtualizarFuncoesExistente() {
        somosTaoJovens.adicionarNoFilme(cpfDanilo, danilo, ator);
        somosTaoJovens.atualizarFuncoes(cpfDanilo, danilo, ator);

        List<String> funcoesEsperadas = new ArrayList<>();
        funcoesEsperadas.add(ator);

        assertEquals(funcoesEsperadas, somosTaoJovens.getFuncionarios().get(cpfDanilo).get(danilo));
    }

    @Test
    public void testeFuncionarioNaoEncontrado() {
        somosTaoJovens.atualizarFuncoes("987.654.321-00", "Maria", diretor);

        assertFalse(somosTaoJovens.getFuncionarios().containsKey("987.654.321-00"));
    }

    @Test
    public void testeSetTrilhaSonora() {
        somosTaoJovens.setTrilhaSonora("Legião Urbana");
        assertTrue(somosTaoJovens.toString().contains("Trilha sonora: Legião Urbana"));
    }
}
