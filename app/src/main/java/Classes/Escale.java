package Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/**
 * Created by AspireV on 2018-03-09.
 */

@Entity(tableName = "escale",foreignKeys = {@ForeignKey(entity = Lieu.class,
                                           parentColumns = {"id_lieu"},
                                           childColumns = "id_lieuEscale")},
                                           indices = @Index("id_lieuEscale"))
public class Escale {

    @android.support.annotation.NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_escale")
    private int id_escale;

    @ColumnInfo(name = "rang")
    @NonNull
    private int rang ;

    @NonNull
    @ColumnInfo(name = "prix")
    private double prix  ;

    @NonNull
    @ColumnInfo(name = "id_lieuEscale")
    private int id_nomEscale ;

    @Ignore
    public Escale(int rang, double prix, int id_nomEscale) {
        this.rang = rang;
        this.prix = prix;
        this.id_nomEscale = id_nomEscale;
    }

    public Escale() {
    }

    public void setId_escale(int id_escale) {
        this.id_escale = id_escale;
    }

    public int getId_escale() {
        return id_escale;
    }

    public int getRang() {
        return rang;
    }

    public double getPrix() {
        return prix;
    }

    public int getId_nomEscale() {
        return id_nomEscale;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setId_nomEscale(int id_nomEscale) {
        this.id_nomEscale = id_nomEscale;
    }

    @Override
    public String toString() {
        return "Escale{" +
                "rang=" + rang +
                ", prix=" + prix +
                ", id_nomEscale=" + id_nomEscale +
                '}';
    }
}
