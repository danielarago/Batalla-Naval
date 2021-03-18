package Entities;

/**
 * Represents a ship
 *
 *
 * @author Juan Manuel Calderon, Adriana Maria Velasquez, Daniela Ramirez
 */

public class Ship {
    private int numberId;
    public int score;
    public static final int numMarines = 4;
    Marine [] marines = new Marine[numMarines];
    private Position location;

    /**
     * Constructors of the class Ship
     */

    public Ship() {
    }

    public Ship(Marine[] marines) {
        this.marines = marines;
    }

    public Ship(Position location) {
        this.location = location;
    }

    /**
     * Method that confirms whether there are enough marines on a ship
     *
     * @return true or false
     */

    public boolean suficientesMarinos(){
        boolean result = false;
        int cont = marines.length;
        for (Marine marine : this.marines) {
            if (marine == null) {
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

    /**
     * Method that establishes the ship's location
     *
     * @return void
     */

    public void setLocation(Position p){
        this.location = p;
    }

    /**
     * Method that accesses the ship's location
     *
     * @return attribute location of the ship
     */

    public Position getLocation(){
        return location;
    }
}
