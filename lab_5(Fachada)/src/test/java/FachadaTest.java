import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.*;

import static org.junit.jupiter.api.Assertions.*;

class FachadaTest {
    private Fachada fachada;

    @BeforeEach
    public void setUp() {
    
        fachada = new Fachada();
    
    }

    @Test
    public void testAdicionarAluno() {
    
        fachada.adicionarAluno("A1", "Alyssandro Ramos", "Ciência da Computação", 5);
    
        Aluno aluno = fachada.buscarAlunoPorId("A1");
    
        assertEquals("Alyssandro Ramos", aluno.getNome());
        assertEquals(5, aluno.getPeriodo());
    
    }

    @Test
    public void testAdicionarAlunoExistente() {
    
        fachada.adicionarAluno("A1", "Alyssandro Ramos", "Ciência da Computação", 5);
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fachada.adicionarAluno("A1", "Maria Souza", "Engenharia", 3);
        });
    
        assertTrue(exception.getMessage().contains("Aluno com ID A1 já existe"));
    }

    @Test
    public void testBuscarAlunoInexistente() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fachada.buscarAlunoPorId("A99");
        });
    
        assertTrue(exception.getMessage().contains("Aluno com ID A99 não encontrado"));
    
    }

    @Test
    public void testAdicionarProfessor() {
    
        fachada.adicionarProfessor("P1", "Dr. Carlos", "5 anos");
    
        Professor professor = fachada.buscarProfessorPorId("P1");
    
        assertEquals("Dr. Carlos", professor.getNome());
        assertEquals("Professor : Dr. Carlos, Tempo de casa: 5 anos", professor.getTempoDeCasa());
    
    }

    @Test
    public void testBuscarProfessorInexistente() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fachada.buscarProfessorPorId("P99");
        });
    
        assertTrue(exception.getMessage().contains("Professor com ID P99 não encontrado"));
    
    }

    @Test
    public void testAdicionarItemAlmoxarifado() {
    
        fachada.adicionarItemEstoque("Cadeiras", 50);
    
        String estoque = fachada.mostrarEstoque();
    
        assertTrue(estoque.contains("Cadeiras: 50"));
    
    }

    @Test
    public void testPedidoDeCompraAlmoxarifado() {
    
        String pedido = fachada.pedidoDeCompra("Projetores", 10);
    
        assertEquals("Pedido de compra registrado para Projetores com quantidade 10.", pedido);
    
    }

    @Test
    public void testAgendarReuniaoAdministrativo() {
    
        String string = fachada.agendarReuniao("TI", "João Souza", "2024-09-27", "10:00");
    
        assertEquals("Reunião com diretoria agendada. Departamento de TI para João Souza em 2024-09-27 às 10:00.", string);
    
    }

    @Test
    public void testAdicionarContaFinanceiro() {
    
        String string = fachada.registrarConta(1500.0f, "Conta de Luz", "2024-09-27", "Financeiro");
    
        assertEquals("Conta adicionada: Conta de Luz - 2024-09-27 - Financeiro com valor 1500.0", string);
    
    }
}
