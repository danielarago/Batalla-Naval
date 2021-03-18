package Entities;

import java.util.ArrayList;

/**
 * Represents a navy fleet
 *
 *
 * @author Juan Manuel Calderon, Adriana Maria Velasquez, Daniela Ramirez
 */

public class Navy {
    private String name;
    private final static int code = 0;
    public ArrayList <Ship> ships = new ArrayList<>();
    public ArrayList<AircraftCarrier> aircraftCarriers = new ArrayList<>();
    public ArrayList <Aircraft> aircrafts = new ArrayList<>();
    public Board gameBoard = new Board();

    /** Constructors for class navy **/

    public Navy() {
    }

    public Navy(String name, Board gameBoard) {
        this.gameBoard = gameBoard;
        this.name = name;
    }

    /**
     * Method called to search for other navies that share the same name as the navy in question
     *
     * @return the count of navies from the count navies methods -1 (the navy itself)
     */

    public int alias(){
        String n = this.name;
        int cont = gameBoard.CountNavies(n);
        return cont-1;
    }

    /**
     * Method that accesses a Navy's name
     *
     * @return the attribute name
     */

    public String getName() {
        return name;
    }

    /**
     * Method that returns the amount of aircrafts in a Navy
     *
     * @return size of the Aircraft array list
     */

    public int getNumberOfAircrafts() {
        return aircrafts.size();
    }

    /**
     * Method that returns the total amount of machines in a Navy
     *
     * @return sum of size of Aircraft array, Aircraft carrier array and Ship array
     */

    public int numerodeMaquinas(){
        int numberShips = ships.size();
        int numberAircraftCarriers = aircraftCarriers.size();
        int numberAircrafts = aircrafts.size();
        return numberAircrafts+numberShips+numberAircraftCarriers;
    }

    /**
     * Method that returns the list of objects destroyed with an explosion according to their position
     *
     * @param longitud of explosion
     * @param latitud of explosion
     * @return array list containing the objects destroyed by an explosion
     */

    public ArrayList<Object> seranDestruidas (int longitud, int latitud){
        ArrayList <AircraftCarrier> aircraftCarriers = this.aircraftCarriers;
        ArrayList<Ship> ships = this.ships;
        ArrayList<Aircraft> aircrafts = this.aircrafts;
        ArrayList <Object> destroyedObjects = new ArrayList<>();
        for (int i=0; i<ships.size(); i++){
            Ship ship = ships.get(i);
            if (ship.getLocationX() == longitud && ship.getLocationY() == latitud){
                destroyedObjects.add(ship);
            }
        }
        for (int j=0; j<aircraftCarriers.size(); j++){
            AircraftCarrier aircraftCarrier = aircraftCarriers.get(j);
            if (aircraftCarrier.getLocationX() == longitud && aircraftCarrier.getLocationX() == latitud){
                destroyedObjects.add(aircraftCarrier);
            }
        }
        for (int k=0; k<aircrafts.size(); k++){
            Aircraft aircraft = aircrafts.get(k);
            if (aircraft.getLocationX() == longitud && aircraft.getLocationY() == latitud){
                destroyedObjects.add(aircraft);
            }
        }
        return destroyedObjects;
    }

    /**
     * Method that moves all of the ships in the navy a given number of spaces in x and y
     *
     * @param deltaLongitud spaces to be moved in x
     * @param deltaLatitud spaces to be moved in y
     */

    public void muevase(int deltaLongitud, int deltaLatitud){
        for (int i=0; i<ships.size(); i++) {
            if (deltaLongitud+this.ships.get(i).getLocation().getLongitude() >= gameBoard.min_x && deltaLongitud+this.ships.get(i).getLocation().getLongitude() <= gameBoard.max_x) {
                if (deltaLatitud + ships.get(i).getLocation().getLatitude() >= gameBoard.min_y && deltaLatitud + ships.get(i).getLocation().getLatitude() <= gameBoard.max_y) {
                    ships.get(i).setLocation(new Position(deltaLatitud + this.ships.get(i).getLocationY(), deltaLongitud + this.ships.get(i).getLocationX()));
               }
            }
        }
    }

    /**
     * Method that calls countAircrafts method in board
     *
     * @return plates of enemy aircrafts
     */

    public ArrayList<String> enAire(){
        ArrayList <String> plates = gameBoard.countAircrafts();
        return plates;
    }

    /**
     * Method that confirms whether an attack is good (none of the Navy's own machines are destroyed) or bad (any of the Navy's machines are destroyed)
     *
     * @param longitud of attack
     * @param latitud of attack
     * @return true or false
     */

    public boolean esBuenAtaque(int longitud, int latitud){
        ArrayList <AircraftCarrier> aircraftCarriers = this.aircraftCarriers;
        ArrayList<Ship> ships = this.ships;
        ArrayList<Aircraft> aircrafts = this.aircrafts;
        boolean result = true;
        for (int i=0; i<ships.size(); i++){
            Ship ship = ships.get(i);
            if (ship.getLocationX() == longitud && ship.getLocationY() == latitud){
                result = false;
            }
        }
        for (int j=0; j<aircraftCarriers.size(); j++){
            AircraftCarrier aircraftCarrier = aircraftCarriers.get(j);
            if (aircraftCarrier.getLocationX() == longitud && aircraftCarrier.getLocationX() == latitud){
                result = false;
            }
        }
        for (int k=0; k<aircrafts.size(); k++){
            Aircraft aircraft = aircrafts.get(k);
            if (aircraft.getLocationX() == longitud && aircraft.getLocationY() == latitud){
                result = false;
            }
        }
        return result;
    }

    /**
     * Method that calls sharedPlates method in board
     *
     * @return true or false
     */

    public boolean problemaEnAire(){
        boolean result = gameBoard.sharedPlates(aircrafts);
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }

        if(!(o instanceof Navy)){
            return false;
        }

        Navy n = (Navy)o;

        return this.name == n.getName();
    }
}
