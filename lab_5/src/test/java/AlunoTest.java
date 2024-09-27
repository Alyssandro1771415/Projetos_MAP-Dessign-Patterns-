import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Aluno;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    public void setup() {

        aluno = new Aluno("A001", "Alyssandro Ramos", "Computação", 3);
    
    }

    @Test
    public void testGetNome() {
     
        assertEquals("Alyssandro Ramos", aluno.getNome());
    
    }

    @Test
    public void testGetId() {
    
        assertEquals("A001", aluno.getId());
    
    }

    @Test
    public void testSetNome() {
     
        aluno.setNome("Danilo Valério");
        assertEquals("Danilo Valério", aluno.getNome());
    
    }

    @Test
    public void testSetPeriodoValido() {
    
        aluno.setPeriodo(4);
        assertEquals(4, aluno.getPeriodo());
   
    }

    @Test
    public void testSetPeriodoInvalido() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            aluno.setPeriodo(0);
        });
    
        assertEquals("O período deve ser maior ou igual a 1.", exception.getMessage());
    
    }

    @Test
    public void testAdicionarHistorico() {
   
        String resultado = aluno.adicionarHistorico("T101", "Matemática", "Adailson Ribeiro", 9.5, 2);
        assertTrue(resultado.contains("Histórico adicionado para Alyssandro Ramos (Computação): Disciplina: Matemática, Professor: Adailson Ribeiro, Nota: 9.5, Faltas: 2, Período: 3 com chave T101_t0001"));
    
    }

    @Test
    public void testAdicionarHistoricoComDadosInvalidos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarHistorico(null, "Matemática", "Adailson Ribeiro", 9.5, 2);
        });
        assertEquals("ID da turma não pode ser nulo ou vazio.", exception.getMessage());


        exception = assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarHistorico("T101", "", "Adailson Ribeiro", 9.5, 2);
        });
        assertEquals("Nome da disciplina não pode ser nulo ou vazio.", exception.getMessage());


        exception = assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarHistorico("T101", "Matemática", null, 9.5, 2);
        });
        assertEquals("Nome do professor não pode ser nulo ou vazio.", exception.getMessage());


        exception = assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarHistorico("T101", "Matemática", "Adailson Ribeiro", 11, 2);
        });
        assertEquals("A nota deve estar entre 0 e 10.", exception.getMessage());


        exception = assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarHistorico("T101", "Matemática", "Adailson Ribeiro", 9.5, -1);
        });
        assertEquals("O número de faltas não pode ser negativo.", exception.getMessage());
    }

    @Test
    public void testMostrarHistoricoVazio() {

        String resultado = aluno.mostrarHistorico();
        assertEquals("Erro: Nenhum histórico encontrado para o aluno (ID: A001).\n", resultado);
    
    }

    @Test
    public void testMostrarHistoricoComItens() {
    
        aluno.adicionarHistorico("T101", "Matemática", "Adailson Ribeiro", 9.5, 2);
        aluno.adicionarHistorico("T102", "Física", "Dr. João", 8.0, 1);
   
        String resultado = aluno.mostrarHistorico();
    
        assertTrue(resultado.contains("T101_t0001 => Disciplina: Matemática, Professor: Adailson Ribeiro, Nota: 9.5, Faltas: 2, Período: 3"));
        assertTrue(resultado.contains("T102_t0002 => Disciplina: Física, Professor: Dr. João, Nota: 8.0, Faltas: 1, Período: 3"));
    
    }

    @Test
    public void testGerarRDMComSucesso() {
      
        aluno.adicionarHistorico("T101", "Matemática", "Adailson Ribeiro", 9.5, 2);
        aluno.adicionarHistorico("T102", "Física", "Dr. João", 8.0, 1);
        
        String resultado = aluno.gerarRDM();
        
        assertTrue(resultado.contains("Aluno: Alyssandro Ramos\nRDM do 3º periodo:"));
        assertTrue(resultado.contains("T101_t0001 => Disciplina: Matemática, Professor: Adailson Ribeiro, Nota: 9.5, Faltas: 2, Período: 3"));
    
    }
}
