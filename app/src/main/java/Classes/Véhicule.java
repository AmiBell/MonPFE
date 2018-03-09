package Classes;

/**
 * Created by AspireV on 2018-03-09.
 */

public class Véhicule {
    private Long matricule ;
    private String modele ;
    private String marque ;
    private String couleur ;


    public Véhicule(String marque ,Long matricule , String modele , String couleur) {
        this.marque = marque; this.matricule=matricule ; this.modele=modele ; this.couleur=couleur ;
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
}
