import Entities.Marine;
import Entities.Ship;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {
    @Test
    @DisplayName("GIVEN a ship with less marines than required WHEN asked whether it has enough THEN return it doesn't")
    public void shouldReturnThereAreNotEnoughMarines(){
        Marine[] marines = new Marine[4];
        Ship ship = new Ship(marines);

        boolean result = ship.suficientesMarinos();
        assertFalse(result);
    }

    @Test
    @DisplayName("GIVEN a ship with the number of marines required WHEN asked whether it has enough THEN return it does")
    public void shouldReturnWhetherThereAreEnoughMarines(){
        Marine [] marines = new Marine[4];
        Ship ship = new Ship(marines);

        for (int i=0; i<marines.length; i++){
            Marine marine = new Marine();
            marines[i] = marine;
        }

        boolean result = ship.suficientesMarinos();
        assertTrue(result);
    }
}
