package Classes;

/**
 * Created by AspireV on 2018-03-09.
 */

public class Escale {
    private int rang ;
    private double prix  ;
    private String nomescale ;

    public Escale(int rang, double prix, String nomescale) {
        this.rang = rang;
        this.prix = prix;
        this.nomescale = nomescale;
    }



    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNomescale() {
        return nomescale;
    }

    public void setNomescale(String nomescale) {
        this.nomescale = nomescale;
    }





}
