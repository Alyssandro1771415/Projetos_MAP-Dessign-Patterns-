import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Professor;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    private Professor professor;

    @BeforeEach
    void setUp() {

        professor = new Professor("001", "Alyssandro Ramos", "5 anos");
    
    }

    @Test
    void testConstrutor_valido() {
    
        assertEquals("Alyssandro Ramos", professor.getNome());
        assertEquals("001", professor.getId());
        assertEquals("Professor : Alyssandro Ramos, Tempo de casa: 5 anos", professor.getTempoDeCasa());
    
    }

    @Test
    void testConstrutor_invalido() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Professor(null, "Alyssandro Ramos", "5 anos");
        });
        assertEquals("Erro: Dados do professor não podem ser nulos.", exception.getMessage());
    
    }

    @Test
    void testSetNome() {
    
        professor.setNome("Carlos Andrade");
        assertEquals("Carlos Andrade", professor.getNome());
    
    }

    @Test
    void testSetTempoDeCasa() {
    
        professor.setTempoDeCasa("10 anos");
        assertEquals("Professor : Alyssandro Ramos, Tempo de casa: 10 anos", professor.getTempoDeCasa());
    
    }

    @Test
    void testAlocarDisciplina() {
    
        professor.alocarDisciplina("Matemática");
        assertTrue(professor.mostrarTurma().contains("Disciplina1: Matemática"));
    
    }

    @Test
    void testAlocarMultiplasDisciplinas() {
    
        professor.alocarDisciplina("Matemática");
        professor.alocarDisciplina("História");
     
        String turma = professor.mostrarTurma();
    
        assertTrue(turma.contains("Disciplina1: Matemática"));
        assertTrue(turma.contains("Disciplina2: História"));
    
    }

    @Test
    void testMostrarTurma_vazia() {
    
        String resultado = professor.mostrarTurma();
        assertEquals("Disciplinas Alocadas:\n", resultado);
    
    }
}
