import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Financeiro;

import static org.junit.jupiter.api.Assertions.*;

class FinanceiroTest {

    private Financeiro financeiro;

    @BeforeEach
    void setUp() {
   
        financeiro = new Financeiro();
  
    }

    @Test
    void adicionarConta_valida() {
     
        financeiro.adicionarConta(1000.0f, "Conta de Luz", "01/09/2024", "Administração");
        assertEquals(1, financeiro.getContas().size());
   
    }

    @Test
    void adicionarConta_invalida() {
   
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            financeiro.adicionarConta(0, null, null, null);
     
        });
     
        assertEquals("Erro: Dados inválidos para adicionar conta.", exception.getMessage());
    
    }

    @Test
    void deletarConta_existente() {
    
        financeiro.adicionarConta(1000.0f, "Conta de Luz", "01/09/2024", "Administração");
     
        String resultado = financeiro.deletarConta("Conta de Luz", "01/09/2024", "Administração");
    
        assertEquals("Conta deletada: Conta de Luz - 01/09/2024 - Administração", resultado);
        assertEquals(0, financeiro.getContas().size());
    
    }

    @Test
    void deletarConta_inexistente() {
      
        String resultado = financeiro.deletarConta("Conta de Água", "01/09/2024", "Administração");
        assertEquals("Conta não encontrada: Conta de Água - 01/09/2024 - Administração", resultado);
    
    }

    @Test
    void adicionarPagamentoServidor_valido() {
    
        financeiro.adicionarPagamentoServidor(2000.0f, "Danilo", "01/09/2024", "RH");
        assertEquals(1, financeiro.getPagamentosServidores().size());
    
    }

    @Test
    void adicionarPagamentoServidor_invalido() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            financeiro.adicionarPagamentoServidor(0, null, null, null);
        });
        assertEquals("Erro: Dados inválidos para adicionar pagamento.", exception.getMessage());
    
    }

    @Test
    void deletarPagamentoServidor_existente() {
    
        financeiro.adicionarPagamentoServidor(2000.0f, "Danilo", "01/09/2024", "RH");
    
        String resultado = financeiro.deletarPagamentoServidor("Danilo", "01/09/2024", "RH");
     
        assertEquals("Pagamento de servidor deletado: Danilo - 01/09/2024 - RH", resultado);
        assertEquals(0, financeiro.getPagamentosServidores().size());
    
    }

    @Test
    void deletarPagamentoServidor_inexistente() {
   
        String resultado = financeiro.deletarPagamentoServidor("Alyssandro", "01/09/2024", "TI");
        assertEquals("Pagamento de servidor não encontrado: Alyssandro - 01/09/2024 - TI", resultado);
    
    }
}
