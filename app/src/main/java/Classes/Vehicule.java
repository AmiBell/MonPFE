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

@Entity(tableName = "vehicule", foreignKeys = {@ForeignKey(entity = Membre.class,
                                             parentColumns = "id_membre", childColumns = "proprietaire")},
                                         indices = @Index("proprietaire"))
public class Vehicule {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "matricule")
    private Long matricule ;

    @NonNull
    @ColumnInfo(name = "modele")
    private String modele ;

    @NonNull
    @ColumnInfo(name = "marque")
    private String marque ;

    @NonNull
    @ColumnInfo(name = "couleur")
    private String couleur ;

    @ColumnInfo(name = "proprietaire")
    private String proprietaire;


    @Ignore
    public Vehicule(String marque ,Long matricule , String modele , String couleur,String proprietaire) {
        this.marque = marque; this.matricule=matricule ; this.modele=modele ; this.couleur=couleur ;
        this.proprietaire=proprietaire;
    }

    public Vehicule() {
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele= modele  ;
    }

    public Long getMatricule() {
        return matricule;
    }

    public void setMatricule(Long matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }
    public void setMarque(String Marque) {
        this.marque=marque ;
    }

    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur=couleur ;
    }

    @Override
    public String toString() {
        return this.marque+"\n"+this.modele+"\n"+this.couleur;
    }
}
