import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Disciplina;
import com.example.MatriculaProfessor;
import com.example.Professor;
import com.example.Turma;

public class TesteMatriculaProfessor {
    
    private Professor kezia;
    private MatriculaProfessor novaMatricula;
    private Disciplina algoritmos;
    private Disciplina compiladores;
    private Turma turmaAlgoritmos;
    private Turma turmaCompiladores;

    @BeforeEach
    public void setup(){

        kezia = new Professor("Kézia", "2220");
        novaMatricula = new MatriculaProfessor(kezia.getNome(), kezia.getCodigoProf());
        algoritmos = new Disciplina("Algoritmos", "14931");
        turmaAlgoritmos = new Turma(algoritmos, kezia);

        compiladores = new Disciplina("Compiladores", "14932");
        turmaCompiladores = new Turma(compiladores, kezia);

    }

    @Test
    public void TesteGetProfessor(){

        Professor professorDaMatricula = novaMatricula.getProfessor();

        assertEquals(kezia.getNome(), professorDaMatricula.getNome());
        assertEquals(kezia.getCodigoProf(), professorDaMatricula.getCodigoProf());

    }

    @Test
    public void TesteAdicionarTurmas(){

        novaMatricula.adicionarTurma(turmaAlgoritmos);
        novaMatricula.adicionarTurma(turmaCompiladores);
        novaMatricula.adicionarTurma(turmaAlgoritmos);

        assertEquals(2, novaMatricula.getNumeroDeTurmas());
        assertTrue(novaMatricula.getTurmas().contains(turmaAlgoritmos));

    }
}
