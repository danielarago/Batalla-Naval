package Entities;

/**
 * Represents an aircraft
 *
 *
 * @author Juan Manuel Calderon, Adriana Maria Velasquez, Daniela Ramirez
 */

public class Aircraft {
    private String licensePlate;
    private boolean inAir;
    public int score;
    public static final int numMarines = 2;
    Marine [] marines = new Marine[numMarines];
    private Position location;

    /**
     * Constructors for class Aircraft
     */

    public Aircraft() {
    }

    public Aircraft(Marine[] marines) {
        this.marines = marines;
    }

    public Aircraft(String licensePlate, boolean inAir) {
        this.licensePlate = licensePlate;
        this.inAir = inAir;
    }

    public Aircraft(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Aircraft(Position location) {
        this.location = location;
    }

    /**
     * Method that confirms whether there are enough marines on an aircraft
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

    /**
     * Method that accesses an aircraft's license plate
     *
     * @return the attribute license plate
     */

    public String getLicensePlate(){
        return licensePlate;
    }

    /**
     * Method that confirms whether an aircraft is in the air
     *
     * @return true or false
     */

    public boolean isInAir() {
        return inAir;
    }
}
