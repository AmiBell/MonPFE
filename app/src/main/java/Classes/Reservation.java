package Classes;

import java.util.ArrayList;

/**
 * Created by AspireV on 2018-03-09.
 */

public class Reservation {
    private boolean etat =false ;
    private int nbplace ;
    private ArrayList<Escale> escales = new ArrayList<Escale>();

    public Reservation(boolean etat, int nbplace) {

        this.nbplace = nbplace;
    }


    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }
}
