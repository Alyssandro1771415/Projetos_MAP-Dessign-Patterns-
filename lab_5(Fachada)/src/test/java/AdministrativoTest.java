import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Administrativo;

import static org.junit.jupiter.api.Assertions.*;

public class AdministrativoTest {

    private Administrativo administrativo;

    @BeforeEach
    public void setup() {
   
        administrativo = new Administrativo();
   
    }

    @Test
    public void testAgendarReuniao() {
   
        String resultado = administrativo.agendarReuniao("Tecnologia", "Alyssandro Ramos", "2024-09-30", "10:00");
        assertEquals("Reunião com diretoria agendada. Departamento de Tecnologia para Alyssandro Ramos em 2024-09-30 às 10:00.", resultado);
   
    }

    @Test
    public void testAgendarReuniaoComDadosInvalidos() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            administrativo.agendarReuniao(null, "Alyssandro Ramos", "2024-09-30", "10:00");
        });
   
        assertEquals("Erro: Dados inválidos para agendamento.", exception.getMessage());
    
    }

    @Test
    public void testMarcarEntrevista() {
    
        String resultado = administrativo.marcarEntrevista("Joana Santos", "RH", "2024-09-25", "14:00");
        assertEquals("Entrevista marcada com Joana Santos do departamento de RH em 2024-09-25 às 14:00.", resultado);
    
    }

    @Test
    public void testMarcarEntrevistaComDadosInvalidos() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            administrativo.marcarEntrevista(null, "RH", "2024-09-25", "14:00");
        });
   
        assertEquals("Erro: Dados inválidos para agendamento.", exception.getMessage());
    
    }
}
