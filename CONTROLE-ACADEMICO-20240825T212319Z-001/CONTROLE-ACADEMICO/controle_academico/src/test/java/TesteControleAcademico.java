import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Aluno;
import com.example.ControleAcademico;
import com.example.Disciplina;
import com.example.MatriculaAluno;
import com.example.MatriculaProfessor;
import com.example.Professor;
import com.example.Turma;

public class TesteControleAcademico {

    private ControleAcademico controleAcademico;
    
    @BeforeEach
    public void setup() {
        controleAcademico = new ControleAcademico();
    }

    @Test
    public void testAdicionarDisciplina() {
        Disciplina disciplina = controleAcademico.addDisciplina("Algoritmos", "101");
        assertNotNull(disciplina);
        assertEquals("Algoritmos", disciplina.getNome());
        assertEquals("101", disciplina.getCodigoDisciplina());
    }

    @Test
    public void testCriarProfessor() {
        Professor professor = controleAcademico.criarProfessor("João", "2501");
        assertNotNull(professor);
        assertEquals("João", professor.getNome());
        assertEquals("2501", professor.getCodigoProf());
    }

    @Test
    public void testCriarAluno() {
        Aluno aluno = controleAcademico.criarAluno("Maria", "123456");
        assertNotNull(aluno);
        assertEquals("Maria", aluno.getNome());
        assertEquals("123456", aluno.getMatricula());
    }

    @Test
    public void testCriarTurma() {
        Professor professor = controleAcademico.criarProfessor("João", "2501");
        Disciplina disciplina = controleAcademico.addDisciplina("Algoritmos", "101");
        Turma turma = controleAcademico.criarTurma("T101", disciplina, professor);
        
        assertNotNull(turma);
        assertEquals(disciplina.getNome(), turma.getDisciplina().getNome());
        assertEquals(disciplina.getCodigoDisciplina(), turma.getDisciplina().getCodigoDisciplina());

        assertEquals(professor.getNome(), turma.getProfessor().getNome());
        assertEquals(professor.getCodigoProf(), turma.getProfessor().getCodigoProf());

    }

    @Test
    public void testCriarMatriculaAluno() {
        MatriculaAluno matriculaAluno = controleAcademico.criarMatriculaAluno("Maria", "123456");
        assertNotNull(matriculaAluno);
        assertEquals("Maria", matriculaAluno.getAluno().getNome());
        assertEquals("123456", matriculaAluno.getAluno().getMatricula());
    }

    @Test
    public void testCriarMatriculaProfessor() {
        MatriculaProfessor matriculaProfessor = controleAcademico.criarMatriculaProfessor("João", "2501");
        assertNotNull(matriculaProfessor);
        assertEquals("João", matriculaProfessor.getProfessor().getNome());
        assertEquals("2501", matriculaProfessor.getProfessor().getCodigoProf());
    }

    @Test
    public void testMatricularAlunoEmTurma() {
        Aluno aluno = controleAcademico.criarAluno("Maria", "123456");
        Professor professor = controleAcademico.criarProfessor("João", "2501");
        Disciplina disciplina = controleAcademico.addDisciplina("Algoritmos", "101");
        Turma turma = controleAcademico.criarTurma("T101", disciplina, professor);

        MatriculaAluno matriculaAluno = controleAcademico.criarMatriculaAluno(aluno.getNome(), aluno.getMatricula());
        controleAcademico.matricularAlunoEmTurma(matriculaAluno, turma);

        assertTrue(
            turma.getListaDeAlunos().stream().anyMatch(a -> a.getNome().equals(aluno.getNome()) && a.getMatricula().equals(aluno.getMatricula()))
        );
        assertTrue(
            matriculaAluno.getTurmas().stream().anyMatch(t -> t.getDisciplina().getCodigoDisciplina().equals(turma.getDisciplina().getCodigoDisciplina()) 
            && t.getProfessor().getCodigoProf().equals(turma.getProfessor().getCodigoProf()))
        );
    }


    @Test
    public void testGetAlunosPorTurma() {
        Aluno aluno = controleAcademico.criarAluno("Maria", "123456");
        Professor professor = controleAcademico.criarProfessor("João", "2501");
        Disciplina disciplina = controleAcademico.addDisciplina("Algoritmos", "101");
        Turma turma = controleAcademico.criarTurma("T101", disciplina, professor);

        MatriculaAluno matriculaAluno = controleAcademico.criarMatriculaAluno(aluno.getNome(), aluno.getMatricula());
        controleAcademico.matricularAlunoEmTurma(matriculaAluno, turma);

        List<Aluno> alunosPorTurma = controleAcademico.getAlunosPorTurma(turma);

        assertEquals(1, alunosPorTurma.size());
        assertTrue(
            alunosPorTurma.stream().anyMatch(a -> a.getNome().equals(aluno.getNome()) && a.getMatricula().equals(aluno.getMatricula()))
        );
    }

    @Test
    public void testGetTurmasPorProfessor() {

        Professor professor = new Professor("Kezia", "PROF001");
        Disciplina disciplina = new Disciplina("Compiladores", "DISC001");

        controleAcademico.addDisciplina(disciplina.getNome(), disciplina.getCodigoDisciplina());

        controleAcademico.criarMatriculaProfessor(professor.getNome(), professor.getCodigoProf());

        controleAcademico.criarTurma("TURMA001",controleAcademico.getDisciplinaPorCodigo(disciplina.getCodigoDisciplina()), controleAcademico.getProfessorPorCodigo("PROF001"));
        
        List<Turma> turmas = controleAcademico.getTurmasPorProfessor(controleAcademico.getProfessorPorCodigo("PROF001"));
    
        assertEquals(1, turmas.size());
        assertTrue(
            turmas.stream().anyMatch(t -> t.getDisciplina().getCodigoDisciplina().equals(disciplina.getCodigoDisciplina())
            && t.getProfessor().getCodigoProf().equals(professor.getCodigoProf()))
        );
    }


    @Test
    public void testExibirInformacoesAlunos() {
        Aluno aluno = controleAcademico.criarAluno("Maria", "123456");
        Professor professor = controleAcademico.criarProfessor("João", "2501");
        Disciplina disciplina = controleAcademico.addDisciplina("Algoritmos", "101");
        Turma turma = controleAcademico.criarTurma("T101", disciplina, professor);

        MatriculaAluno matriculaAluno = controleAcademico.criarMatriculaAluno(aluno.getNome(), aluno.getMatricula());
        controleAcademico.matricularAlunoEmTurma(matriculaAluno, turma);

        controleAcademico.exibirInformacoesAlunos(); 
    }

    @Test
    public void testExibirInformacoesProfessores() {
        Professor professor = controleAcademico.criarProfessor("João", "2501");
        Disciplina disciplina = controleAcademico.addDisciplina("Algoritmos", "101");
        Turma turma = controleAcademico.criarTurma("T101", disciplina, professor);

        MatriculaProfessor matriculaProfessor = controleAcademico.criarMatriculaProfessor(professor.getNome(), professor.getCodigoProf());
        matriculaProfessor.adicionarTurma(turma);

        controleAcademico.exibirInformacoesProfessores(); 
    }
}
