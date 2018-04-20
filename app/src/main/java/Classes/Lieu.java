package Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/**
 * Created by AspireV on 2018-03-09.
 */

@Entity(tableName ="lieu")
public class Lieu {

    @android.support.annotation.NonNull

    @PrimaryKey
    @ColumnInfo(name = "id_lieu")
    private String id_lieu;

    @NonNull
    @ColumnInfo(name = "lattitude")
    private double lattitude ;

    @NonNull
    @ColumnInfo(name = "longitude")
    private double longittude  ;

    @NonNull
    @ColumnInfo(name = "nomLieu")
    private String nomLieu ;

    @Ignore
    public Lieu(double lattitude, double longittude, String nomLieu) {
        this.lattitude = lattitude;
        this.longittude = longittude;
        this.nomLieu = nomLieu;
        this.id_lieu = String.valueOf(lattitude+longittude);
    }

    public Lieu() {
    }

    public double getLattitude() {
        return lattitude;
    }

    public double getLongittude() {
        return longittude;
    }

    public String getNomLieu() {
        return nomLieu;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public void setLongittude(double longittude) {
        this.longittude = longittude;
    }

    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }

    public String getId_lieu() {
        return id_lieu;
    }

    public void setId_lieu(String id_lieu) {
        this.id_lieu = id_lieu;
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "lattitude=" + lattitude +
                ", longittude=" + longittude +
                ", nomLieu='" + nomLieu + '\'' +
                '}';
    }
}
