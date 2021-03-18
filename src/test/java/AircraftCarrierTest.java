import Entities.Aircraft;
import Entities.AircraftCarrier;
import Entities.Marine;
import Entities.Navy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AircraftCarrierTest {

    @Test
    @DisplayName("GIVEN an aircraft carrier with a defined capacity WHEN asked for its available capacity THEN return number of new planes that can be placed in it")
    public void shouldReturnAvailableCapacity(){
        Navy navy = new Navy();
        AircraftCarrier aircraftCarrier = new AircraftCarrier(100, navy);
        navy.aircraftCarriers.add(aircraftCarrier);

        for (int i=0; i<30; i++){
            Aircraft aircraft = new Aircraft ();
            navy.aircrafts.add(aircraft);
        }

        int result = aircraftCarrier.disponibilidadEnPortaAviones();
        assertEquals(70, result);
    }

    @Test
    @DisplayName("GIVEN an aircraft carrier with less marines than required WHEN asked whether it has enough THEN return it doesn't")
    public void shouldReturnThereAreNotEnoughMarines(){
        Marine[] marines = new Marine[5];
        AircraftCarrier aircraftCarrier = new AircraftCarrier(marines);

        boolean result = aircraftCarrier.suficientesMarinos();
        assertFalse(result);
    }

    @Test
    @DisplayName("GIVEN an aircraft carrier with the number of marines required WHEN asked whether it has enough THEN return it does")
    public void shouldReturnWhetherThereAreEnoughMarines(){
        Marine [] marines = new Marine[5];
        AircraftCarrier aircraftCarrier = new AircraftCarrier(marines);

        for (int i=0; i<marines.length; i++){
            Marine marine = new Marine();
            marines[i] = marine;
        }

        boolean result = aircraftCarrier.suficientesMarinos();
        assertTrue(result);
    }
}
