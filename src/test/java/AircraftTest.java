import Entities.Aircraft;
import Entities.Marine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AircraftTest {
    @Test
    @DisplayName("GIVEN an aircraft with less marines than required WHEN asked whether it has enough THEN return it doesn't")
    public void shouldReturnThereAreNotEnoughMarines(){
        Marine[] marines = new Marine[5];
        Aircraft aircraft = new Aircraft(marines);

        boolean result = aircraft.suficientesMarinos();
        assertFalse(result);
    }

    @Test
    @DisplayName("GIVEN an aircraft with the number of marines required WHEN asked whether it has enough THEN return it does")
    public void shouldReturnWhetherThereAreEnoughMarines(){
        Marine [] marines = new Marine[5];
        Aircraft aircraft = new Aircraft(marines);

        for (int i=0; i<marines.length; i++){
            Marine marine = new Marine();
            marines[i] = marine;
        }

        boolean result = aircraft.suficientesMarinos();
        assertTrue(result);
    }
}
