package Entities; /**
 * Represents an aircraft carrier
 *
 *
 * @author Juan Manuel Calderon, Adriana Maria Velasquez, Daniela Ramirez
 */

import java.util.ArrayList;

public class AircraftCarrier {
    private int numberId;
    private int capacity;
    public int score;
    public static final int numMarines = 5;
    Marine [] marines = new Marine[numMarines];
    private Position location;
    private Navy navy;

    /**
     * Constructors of class AircraftCarrier
     */

    public AircraftCarrier() {
    }

    public AircraftCarrier(int capacity, Navy navy) {
        this.capacity = capacity;
        this.navy = navy;
    }

    public AircraftCarrier(Marine[] marines) {
        this.marines = marines;
    }

    public AircraftCarrier(Position location) {
        this.location = location;
    }

    /**
     * Method that determines how many available spaces for planes there are left
     *
     * @return capacity still available
     */

    public int disponibilidadEnPortaAviones(){
        return this.capacity-navy.getNumberOfAircrafts();
    }

    /**
     * Method that confirms whether there are enough marines on the aircraft carrier to pilot it
     *
     * @return true or false
     */

    public boolean suficientesMarinos(){
        boolean result = false;
        int cont = marines.length;
        for (int i=0; i<this.marines.length; i++) {
            if (marines[i] == null) {
                cont = cont - 1;
            }
        }
        if (cont == this.marines.length){
            result = true;
        }
        return result;
    }

    /**
     * Method that accesses the ship's location in x
     *
     * @return coordinate in x
     */

    public int getLocationX(){
        location = this.location;
        return location.getLongitude();
    }

    /**
     * Method that accesses the ship's location in x
     *
     * @return coordinate in y
     */

    public int getLocationY(){
        location = this.location;
        return location.getLatitude();
    }
}
