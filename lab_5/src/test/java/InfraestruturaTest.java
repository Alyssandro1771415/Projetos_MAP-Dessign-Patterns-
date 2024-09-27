import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Infraestrutura;

import static org.junit.jupiter.api.Assertions.*;

class InfraestruturaTest {

    private Infraestrutura infraestrutura;

    @BeforeEach
    void setUp() {
    
        infraestrutura = new Infraestrutura();
    
    }

    @Test
    void adicionarSala_valida() {
    
        infraestrutura.adicionarSala("101", "Sala de Reunião");
     
        String salasDisponiveis = infraestrutura.mostrarSalasDisponiveis();
     
        assertTrue(salasDisponiveis.contains("101: Sala de Reunião"));
    
    }

    @Test
    void adicionarSala_invalida() {
   
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            infraestrutura.adicionarSala(null, "Sala de Reunião");
        });
   
        assertEquals("Erro: Dados inválidos para adicionar sala.", exception.getMessage());
    }

    @Test
    void alocarSala_disponivel() {
   
        infraestrutura.adicionarSala("101", "Sala de Reunião");
    
        String resultado = infraestrutura.alocarSala("101");
   
        assertEquals("Sala 101 alocada: Sala de Reunião", resultado);
    
    }

    @Test
    void alocarSala_indisponivel() {
    
        String resultado = infraestrutura.alocarSala("102");
        assertEquals("Erro: Sala 102 não disponível.", resultado);
   
    }

    @Test
    void alocarSala_comIdNulo() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            infraestrutura.alocarSala(null);
        });
    
        assertEquals("Erro: ID da sala não pode ser nulo.", exception.getMessage());
    
    }

    @Test
    void desalocarSala_existente() {
   
        infraestrutura.adicionarSala("101", "Sala de Reunião");
        infraestrutura.alocarSala("101");
    
        String resultado = infraestrutura.desalocarSala("101");
     
        assertEquals("Sala 101 desalocada com sucesso.", resultado);
        assertTrue(infraestrutura.mostrarSalasDisponiveis().contains("101: Sala de Reunião"));
   
    }

    @Test
    void desalocarSala_inexistente() {
    
        String resultado = infraestrutura.desalocarSala("102");
        assertEquals("Erro: Sala 102 não existe.", resultado);
   
    }

    @Test
    void mostrarSalasDisponiveis_vazia() {
    
        String resultado = infraestrutura.mostrarSalasDisponiveis();
        assertEquals("Nenhuma sala disponível.", resultado);
    
    }

    @Test
    void mostrarSalasDisponiveis_comSalas() {
     
        infraestrutura.adicionarSala("101", "Sala de Reunião");
        infraestrutura.adicionarSala("102", "Sala de Conferência");
    
        String resultado = infraestrutura.mostrarSalasDisponiveis();
   
        assertTrue(resultado.contains("101: Sala de Reunião"));
        assertTrue(resultado.contains("102: Sala de Conferência"));
    }
}