package Entities;
import java.util.Scanner;

/**
 * Represents position on the board
 *
 *
 * @author Juan Manuel Calderon, Adriana Maria Velasquez, Daniela Ramirez
 */

public class Position {
    private int latitude;
    private int longitude;

    /**
     * Constructors of class Position
     */

    public Position() {
    }

    public Position(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Method that accesses latitude
     *
     * @return attribute latitude
     */

    public int getLatitude(){
        return this.latitude;
    }

    /**
     * Method that accesses longitude
     *
     * @return attribute longitude
     */

    public int getLongitude(){
        return this.longitude;
    }

    /**
     * Method that modifies latitude
     *
     * @param y new latitude
     */

    public void setLatitude(int y){
        latitude = y;
    }

    /**
     * Method that modifies longitude
     *
     * @param x new longitude
     */

    public void setLongitude(int x){
        longitude = x;
    }
}
