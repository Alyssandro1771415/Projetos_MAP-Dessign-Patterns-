import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Disciplina;

public class TesteDisciplina {
    
    private Disciplina AlgebraLinear;

    @BeforeEach
    public void setup(){

        AlgebraLinear = new Disciplina("Álgebra Linear", "14931");

    }

    @Test
    public void TestGetDisciplina(){
        assertEquals("Álgebra Linear", AlgebraLinear.getNome());
        assertNotEquals("Algebra Linear", AlgebraLinear.getNome());
    }
    @Test
    public void TesteGetCodigoDisciplina(){
        assertEquals("14931", AlgebraLinear.getCodigoDisciplina());
        assertNotEquals("14930", AlgebraLinear.getCodigoDisciplina());
    }

}
