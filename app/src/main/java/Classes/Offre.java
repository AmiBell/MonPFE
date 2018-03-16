package Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Date;

import io.reactivex.annotations.NonNull;

/**
 * Created by AspireV on 2018-03-09.
 */

@Entity(tableName = "offre",foreignKeys ={ @ForeignKey(entity = Lieu.class,
                                          parentColumns = {"id_lieu"}, childColumns = "id_lieuDep"),
                                          @ForeignKey(entity = Lieu.class,
                                          parentColumns = {"id_lieu"}, childColumns = "id_lieuArv"),
                                           @ForeignKey(entity = Escale.class,
                                           parentColumns = "id_escale",
                                           childColumns = "id_escaleOffre")},
        indices = {@Index("id_lieuDep"),@Index("id_lieuArv"), @Index("id_escaleOffre")})
public class Offre {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_offre")
    private long id_offre;

    @NonNull
    @ColumnInfo(name = "id_lieuDep")
    private int id_lieuDep;

    @NonNull
    @ColumnInfo(name = "id_lieuArv")
    private int id_lieuArv;

    @NonNull
    @ColumnInfo(name = "id_escaleOffre")
    private int id_escaleOffre ;

    @NonNull
    @ColumnInfo(name = "heureDep")
    private Integer heureDep ;

    @Ignore
    private Time heureDepart ;

    @NonNull
    @ColumnInfo(name = "DateDep")
    private String dateDep ;

    @Ignore
    private  Date dateDepart;

    @NonNull
    @ColumnInfo(name = "nbPlaceTotale")
    private int nbPlaceTotale ;

    @ColumnInfo(name = "sexeCompagnie")
    private String sexeCompagnie  ;

    @Ignore
    public Offre(int lieuDep, int lieuArv, int id_escaleOffre, Time heureDep, java.sql.Date dateDep, int nbPlaceTotale, String sexeCompagnie) {
        this.id_lieuDep = lieuDep;
        this.id_lieuArv = lieuArv;
        this.id_escaleOffre = id_escaleOffre;
        this.heureDepart = heureDep;
        this.dateDepart = dateDep;
        this.nbPlaceTotale = nbPlaceTotale;
        this.sexeCompagnie = sexeCompagnie;
    }

    @Ignore
    public Offre(long id_offre, int id_escaleOffre, Time heureDepart, Date dateDep, int nbPlaceTotale, String sexeCompagnie) {
        this.id_offre = id_offre;
        this.id_escaleOffre = id_escaleOffre;
        this.heureDepart = heureDepart;
        this.dateDepart = dateDep;
        this.nbPlaceTotale = nbPlaceTotale;
        this.sexeCompagnie = sexeCompagnie;
    }

    public Integer getHeureDep() {
        return heureDep;
    }

    public void setDateDep(String dateDep) {
        this.dateDep = dateDep;
    }

    public String getDateDep() {
        return dateDep;
    }

    public Offre() {
    }

    public void setHeureDep(Integer heureDep) {
        this.heureDep = heureDep;
    }

    public void setHeureDepart(Time heureDepart) {
        this.heureDepart = heureDepart;
    }



    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Time getHeureDepart() {
        return heureDepart;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public int getId_lieuDep() {
        return id_lieuDep;
    }

    public int getId_lieuArv() {
        return id_lieuArv;
    }

    public void setId_offre(long id_offre) {
        this.id_offre = id_offre;
    }

    public void setId_lieuDep(int id_lieuDep) {
        this.id_lieuDep = id_lieuDep;
    }

    public void setId_lieuArv(int id_lieuArv) {
        this.id_lieuArv = id_lieuArv;
    }

    public long getId_offre() {
        return id_offre;
    }

    public int getLieuDep() {
        return id_lieuDep;
    }

    public int getLieuArv() {
        return id_lieuArv;
    }

    public int getId_escaleOffre() {
        return id_escaleOffre;
    }



    public int getNbPlaceTotale() {
        return nbPlaceTotale;
    }

    public String getSexeCompagnie() {
        return sexeCompagnie;
    }

  /*  public void setId_offre(long id_offre) {
        this.id_offre = id_offre;
    }*/

    public void setId_escaleOffre(int id_escaleOffre) {
        this.id_escaleOffre = id_escaleOffre;
    }

    public void setLieuDep(int lieuDep) {
        this.id_lieuDep = lieuDep;
    }

    public void setLieuArv(int lieuArv) {
        this.id_lieuArv = lieuArv;
    }



    public void setNbPlaceTotale(int nbPlaceTotale) {
        this.nbPlaceTotale = nbPlaceTotale;
    }

    public void setSexeCompagnie(String sexeCompagnie) {
        this.sexeCompagnie = sexeCompagnie;
    }

    @Override
    public String toString() {
        return " ";
    }
}
