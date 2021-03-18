package Entities;
import java.util.ArrayList;

/**
 * Represents the game board
 *
 *
 * @author Juan Manuel Calderon, Adriana Maria Velasquez, Daniela Ramirez
 */
public class Board {
    public int max_x = 100;
    public int min_x = -100;
    public int max_y = 100;
    public int min_y = -100;
    public ArrayList<Navy> navies = new ArrayList<>();

    /**
     * Constructors for class Board
     */

    public Board(ArrayList<Navy> navies) {
        this.navies = navies;
    }

    public Board() {
    }

    /**
     * Counts how many navies share the name given in the parameters
     *
     * @param n, name of the navy calling the method alias in Navy
     * @return cont, count of navies
     */

    public int CountNavies(String n){
        int cont = 0;
        for (Navy n1 : navies) {
            if (n1.getName().equals(n)) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Method that places all of the plates of the aircrafts of another navy
     *
     * @return list of plates
     */

    public ArrayList<String> countAircrafts(){
        ArrayList <String> plates = new ArrayList<>();
        for (Navy n1 : navies) {
                for (Aircraft a1 : n1.aircrafts) {
                    if (a1.isInAir()) {
                        plates.add(a1.getLicensePlate());
                    }
                }
        }
        return plates;
    }

    /**
     * Method that determines whether other navies share aircraft plates with the navy calling the method
     *
     * @param originalAircrafts array list of the navy calling the method's aircrafts
     * @return true or false
     */

    public boolean sharedPlates(ArrayList <Aircraft> originalAircrafts){
        boolean result = false;
        for (Navy n1 : navies) {
            for (Aircraft aircraft : n1.aircrafts){
                for (int i=0; i<originalAircrafts.size(); i++){
                    if(aircraft.getLicensePlate().equals(originalAircrafts.get(i).getLicensePlate())){
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}

