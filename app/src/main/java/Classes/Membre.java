package Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;import android.text.Editable;


import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * Created by AspireV on 2018-03-09.
 */
@Entity(tableName = "membres")
public class Membre {

    @android.support.annotation.NonNull
    @PrimaryKey
    @ColumnInfo(name = "id_membre")
    private String id_membre;

    @NonNull
    @ColumnInfo(name = "nom")
    private String nom ;

    @NonNull
    @ColumnInfo(name = "prenom")
    private String prenom ;

    @NonNull
    @ColumnInfo(name = "anneeNaiss")
    private int anneeNaiss ;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    @Nullable
    @ColumnInfo(name = "numeroTel")
    private int NumeroTel ;

    @NonNull
    @ColumnInfo(name = "genre")
    private String genre;

   // private String photo ;
    @ColumnInfo(name = "minibio")
    private String minibio ;

    public Membre() {
    }

    @Ignore
    public Membre(String email, String nom, String prenom, String password, int numeroTel, int anneeNaiss, String minibio, String genre) {
        this.id_membre=email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        NumeroTel = numeroTel;
        this.anneeNaiss = anneeNaiss;
        this.minibio = minibio;
        this.genre=genre;
    }


    @Ignore
    public Membre(String email, String nom, String prenom, String password, int anneeNaiss,String genre) {
        this.id_membre= email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.anneeNaiss = anneeNaiss;
        this.genre=genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getEmail() {
        return id_membre;
    }



    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumeroTel() {
        return NumeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        NumeroTel = numeroTel;
    }

    public int getAnneeNaiss() {
        return anneeNaiss;
    }

    public void setAnneeNaiss(int anneeNaiss) {
        this.anneeNaiss = anneeNaiss;
    }

    public String getMinibio() {
        return minibio;
    }

    public void setMinibio(String minibio) {
        this.minibio = minibio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getId_membre() {
        return id_membre;
    }

    public void setId_membre(String id_membre) {
        this.id_membre = id_membre;
    }

    @Override
    public String toString() {
        return this.nom+"\n"+this.prenom+"\n"+this.genre+"\n"+this.anneeNaiss;
    }
}
