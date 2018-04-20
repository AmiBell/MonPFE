package Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AspireV on 2018-03-09.
 */

@Entity(tableName = "wilaya", indices = {@Index(value = "nomW", unique = true)})
public class Wilaya{

    @PrimaryKey
    @ColumnInfo(name = "codeW")
    private int codeW ;

    @ColumnInfo(name = "nomW")
    private String nomW ;

    @ColumnInfo
    private double lattitude ;

    @ColumnInfo
    private double longitude ;

    @Ignore
    private ArrayList<Lieu> listLieux = new ArrayList<Lieu>();

    @Ignore
    public Wilaya(int codeW, String nomW, double lattitude, double longitude) {
        this.codeW = codeW;
        this.nomW = nomW;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public Wilaya() {
    }

    public int getCodeW() {
        return codeW;
    }

    public String getNomW() {
        return nomW;
    }

    public double getLattitude() {
        return lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public ArrayList<Lieu> getListLieux() {
        return listLieux;
    }

    public void setCodeW(int codeW) {
        this.codeW = codeW;
    }

    public void setNomW(String nomW) {
        this.nomW = nomW;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setListLieux(ArrayList<Lieu> listLieux) {
        this.listLieux = listLieux;
    }
}
