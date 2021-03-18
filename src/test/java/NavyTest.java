import Entities.*;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NavyTest {

    @Test
    @DisplayName("GIVEN a group of navies WHEN checking for repeated aliases for a particular navy THEN return the correct value of other navies sharing the alias")
    public void shouldGiveCorrectValueForNaviesCount(){
        ArrayList<Navy> navies = new ArrayList<>();
        Board board = new Board(navies);

        Navy n1 = new Navy("Blue navy", board);
        Navy n2 = new Navy("Green navy", board);
        Navy n3 = new Navy("Blue navy", board);
        Navy n4 = new Navy("Blue navy", board);

        navies.add(n1);
        navies.add(n2);
        navies.add(n3);
        navies.add(n4);

        assertEquals(2, n1.alias());
        assertEquals(0, n2.alias());
    }

    @Test
    @DisplayName("GIVEN the location of an enemy explosion WHEN consulting which objects were hit SHOULD return all destroyed objects")
    public void shouldReturnDestroyedObjects(){
        Navy navy = new Navy();
        Position position = new Position(0, 0);

        Ship s1 = new Ship(position);
        navy.ships.add(s1);

        Aircraft a1 = new Aircraft(position);
        navy.aircrafts.add(a1);

        AircraftCarrier ac1 = new AircraftCarrier(position);
        navy.aircraftCarriers.add(ac1);

        ArrayList<Object> shouldReturn = new ArrayList<>();
        shouldReturn.add(s1);
        shouldReturn.add(ac1);
        shouldReturn.add(a1);

        assertEquals(shouldReturn, navy.seranDestruidas(0, 0));
    }

    @Test
    @DisplayName("GIVEN the location of a Navy's own explosion WHEN it attacks the Navy's own machines SHOULD return that it isn't a good attack")
    public void shouldReturnAttackIsNotGood(){
        Navy navy = new Navy();
        Position position = new Position(0, 0);

        Ship s1 = new Ship(position);
        navy.ships.add(s1);

        Aircraft a1 = new Aircraft(position);
        navy.aircrafts.add(a1);

        AircraftCarrier ac1 = new AircraftCarrier(position);
        navy.aircraftCarriers.add(ac1);

        ArrayList<Object> shouldReturn = new ArrayList<>();
        shouldReturn.add(s1);
        shouldReturn.add(ac1);
        shouldReturn.add(a1);

        assertFalse(navy.esBuenAtaque(0, 0));
    }

    @Test
    @DisplayName("GIVEN the location of a Navy's own explosion WHEN it doesn't hit any of the Navy's own machines SHOULD return that it's a good attack")
    public void shouldReturnAttackIsGood(){
        Navy navy = new Navy();
        Position position = new Position(0, 0);

        Ship s1 = new Ship(position);
        navy.ships.add(s1);

        Aircraft a1 = new Aircraft(position);
        navy.aircrafts.add(a1);

        AircraftCarrier ac1 = new AircraftCarrier(position);
        navy.aircraftCarriers.add(ac1);

        ArrayList<Object> shouldReturn = new ArrayList<>();
        shouldReturn.add(s1);
        shouldReturn.add(ac1);
        shouldReturn.add(a1);

        assertTrue(navy.esBuenAtaque(2, 2));
    }

    @Test
    @DisplayName("GIVEN a navy WHEN consulting the number of machines (aircrafts, ships and aircraft carriers) THEN return the right number")
    public void shouldReturnAmountOfMachinesInNavy() {
        Navy navy = new Navy();

        Ship s1 = new Ship();
        Ship s2 = new Ship();

        navy.ships.add(s1);
        navy.ships.add(s2);

        Aircraft a1 = new Aircraft();
        Aircraft a2 = new Aircraft();
        Aircraft a3 = new Aircraft();

        navy.aircrafts.add(a1);
        navy.aircrafts.add(a2);
        navy.aircrafts.add(a3);

        AircraftCarrier ac1 = new AircraftCarrier();

        navy.aircraftCarriers.add(ac1);

        assertEquals(6, navy.numerodeMaquinas(), "The amount of machines in this navy was successfully counted");
        }

        @Test
        @DisplayName("GIVEN a navy containing an array of ships WHEN given the command to move specific values in x and y THEN should move them all")
        public void shouldMoveShips() {
            Navy navy = new Navy();
            Position location = new Position (0,0);

            Ship s1 = new Ship(location);

            navy.ships.add(s1);

            navy.muevase(6,7);
            assertEquals(6, navy.ships.get(0).getLocation().getLongitude());
            assertEquals(7, navy.ships.get(0).getLocation().getLatitude());
        }

        @Test
        @DisplayName("GIVEN an enemy navy WHEN consulting it's aircraft plates THEN return a list with enemy plates")
        public void shouldReturnEnemyAircraftPlates() {
            Navy n1 = new Navy();
            Navy n2 = new Navy();

            n1.gameBoard.navies.add(n2);

            Aircraft a1 = new Aircraft("A100", true);
            Aircraft a2 = new Aircraft("A200", true);
            Aircraft a3 = new Aircraft("A300", true);
            Aircraft a4 = new Aircraft("A400", true);

            n1.aircrafts.add(a1);
            n1.aircrafts.add(a2);
            n2.aircrafts.add(a3);
            n2.aircrafts.add(a4);

            ArrayList<String> shouldReturn = new ArrayList<>();
            shouldReturn.add("A300");
            shouldReturn.add("A400");

            assertEquals(shouldReturn, n1.enAire());
        }

    @Test
    @DisplayName("GIVEN at least two navies with aircrafts sharing plates WHEN consulting whether there could be a confusion THEN return true")
    public void shouldReturnProblemInAir() {
        Navy n1 = new Navy();
        Navy n2 = new Navy();

        n1.gameBoard.navies.add(n2);

        Aircraft a1 = new Aircraft("A100", true);
        Aircraft a2 = new Aircraft("A200", true);
        Aircraft a3 = new Aircraft("A300", true);
        Aircraft a4 = new Aircraft("A100", true);

        n1.aircrafts.add(a1);
        n1.aircrafts.add(a2);
        n2.aircrafts.add(a3);
        n2.aircrafts.add(a4);

        assertTrue(n1.problemaEnAire());
    }

    @Test
    @DisplayName("GIVEN at least two navies without aircrafts sharing plates WHEN consulting whether there could be a confusion THEN false")
    public void shouldReturnNotProblemInAir() {
        Navy n1 = new Navy();
        Navy n2 = new Navy();

        n1.gameBoard.navies.add(n2);

        Aircraft a1 = new Aircraft("A100", true);
        Aircraft a2 = new Aircraft("A200", true);
        Aircraft a3 = new Aircraft("A300", true);
        Aircraft a4 = new Aircraft("A400", true);

        n1.aircrafts.add(a1);
        n1.aircrafts.add(a2);
        n2.aircrafts.add(a3);
        n2.aircrafts.add(a4);

        assertFalse(n1.problemaEnAire());
    }
}
