import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Professor;

public class TestProfessor {

    private Professor Alyssandro;

    @BeforeEach
    public void setup(){
        Alyssandro = new Professor("Alyssandro", "222080458");
    }

    @Test
    public void TestGetNome(){
        assertEquals("Alyssandro", Alyssandro.getNome());
    }
    @Test
    public void TestgetCodigoProf(){
        assertEquals("222080458", Alyssandro.getCodigoProf());
    }

}
