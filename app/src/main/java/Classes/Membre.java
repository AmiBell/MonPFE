package Classes;

import java.util.Date;

/**
 * Created by AspireV on 2018-03-09.
 */

public class Membre {
    private String email ;
    private String nom ;
    private String prenom ;
    private String password;
    private int NumeroTel ;
    private Date anneeNaiss ;
    private String photo ;
    private String minibio ;
    public Membre (String Email,String Nom,String Prenom,String Password,int NumeroTel,Date AnneeNaiss,String Photo,
                   String Minibio)
    {
        this.email=Email ; this.nom=Nom ;
        this.prenom=Prenom ; this.password = Password ;
        this.anneeNaiss=AnneeNaiss;
        this.minibio=Minibio ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getAnneeNaiss() {
        return anneeNaiss;
    }

    public void setAnneeNaiss(Date anneeNaiss) {
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
}
