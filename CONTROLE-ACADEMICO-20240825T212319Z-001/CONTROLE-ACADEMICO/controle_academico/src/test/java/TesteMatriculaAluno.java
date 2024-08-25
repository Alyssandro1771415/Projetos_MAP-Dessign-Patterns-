import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Aluno;
import com.example.Disciplina;
import com.example.MatriculaAluno;
import com.example.Professor;
import com.example.Turma;

public class TesteMatriculaAluno {
    
    private MatriculaAluno novaMatricula;
    private Aluno Alyssandro;
    private Turma turmaAlgoritmos;
    private Turma turmaCompiladores;

    @BeforeEach
    public void setup() {
        Alyssandro = new Aluno("Alyssandro", "222080493");
        novaMatricula = new MatriculaAluno(Alyssandro.getNome(), Alyssandro.getMatricula());

        Disciplina algoritmos = new Disciplina("Algoritmos", "14931");
        Professor professoraKezia = new Professor("Kezia", "2501");
        turmaAlgoritmos = new Turma(algoritmos, professoraKezia);

        Disciplina Compiladores = new Disciplina("Compiladores", "14932");
        Professor professoraCheyanne = new Professor("Cheyanne", "2502");
        turmaCompiladores = new Turma(Compiladores, professoraCheyanne);

    }

    @Test
    public void TesteGetAluno() {
        Aluno alunoDaMatricula = novaMatricula.getAluno();
        
        assertEquals(Alyssandro.getNome(), alunoDaMatricula.getNome());
        assertEquals(Alyssandro.getMatricula(), alunoDaMatricula.getMatricula());
    }

    @Test
    public void TesteGetTurmas(){

        novaMatricula.matricularEmTurma(turmaAlgoritmos);
        novaMatricula.matricularEmTurma(turmaCompiladores);

        assertEquals(2, novaMatricula.getTurmas().size());
        assertTrue(novaMatricula.getTurmas().contains(turmaAlgoritmos));
        assertTrue(novaMatricula.getTurmas().contains(turmaCompiladores));
    }

    @Test
    public void TesteMatricularEmTurma(){

        novaMatricula.matricularEmTurma(turmaAlgoritmos);
        novaMatricula.matricularEmTurma(turmaAlgoritmos);

        assertEquals(1, novaMatricula.getNumeroDeTurmas());
        assertTrue(novaMatricula.getTurmas().contains(turmaAlgoritmos));

    }

}