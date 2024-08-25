import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Aluno;

public class TestAluno {

    private Aluno Alyssandro;

    @BeforeEach
    public void setup(){
        Alyssandro = new Aluno("Alyssandro", "222080458");
    }

    @Test
    public void TestGetNome(){
        assertEquals("Alyssandro", Alyssandro.getNome());
    }
    @Test
    public void TestGetMatricula(){
        assertEquals("222080458", Alyssandro.getMatricula());
    }

}
