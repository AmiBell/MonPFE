package Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

/**
 * Created by AspireV on 2018-03-09.
 */

@Entity(tableName = "reservation",foreignKeys = {@ForeignKey(entity = Offre.class,
                                                 parentColumns = "id_offre",
                                                 childColumns = "offre_reservee")},
                                              indices = @Index("offre_reservee"))
public class Reservation {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_reservation")
    private int id_reservation;

    @NonNull
    @ColumnInfo(name = "etat")
    private boolean etat =false ;

    @NonNull
    @ColumnInfo(name = "nbPlace")
    private int nbPlace ;

    @NonNull
    @ColumnInfo(name = "offre_reservee")
    private int offre_reservee;

    @Ignore
    public Reservation(boolean etat, int nbPlace, int offre_reservee) {
        this.etat = etat;
        this.nbPlace = nbPlace;
        this.offre_reservee = offre_reservee;
    }

    public Reservation() {
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public boolean isEtat() {
        return etat;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public int getOffre_reservee() {
        return offre_reservee;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public void setOffre_reservee(int offre_reservee) {
        this.offre_reservee = offre_reservee;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "etat=" + etat +
                ", nbPlace=" + nbPlace +
                ", offre_reservee=" + offre_reservee +
                '}';
    }
}
