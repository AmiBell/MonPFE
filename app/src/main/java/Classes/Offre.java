package Classes;

import java.util.Date;

/**
 * Created by AspireV on 2018-03-09.
 */

public class Offre {
    private int nbescale ;
    private int heuredep ; //type de temps ?
    private Date datedep ;
    private int nbplacetot ;
    private SexeCompagnie sexeCompagnie  ;

    public Offre(int nbescale, int heuredep, Date datedep, int nbplacetot, SexeCompagnie sexeCompagnie) {
        this.nbescale = nbescale;
        this.heuredep = heuredep;
        this.datedep = datedep;
        this.nbplacetot = nbplacetot;
        this.sexeCompagnie = sexeCompagnie;
    }




    public int getNbescale() {
        return nbescale;
    }

    public void setNbescale(int nbescale) {
        this.nbescale = nbescale;
    }

    public int getHeuredep() {
        return heuredep;
    }

    public void setHeuredep(int heuredep) {
        this.heuredep = heuredep;
    }

    public Date getDatedep() {
        return datedep;
    }

    public void setDatedep(Date datedep) {
        this.datedep = datedep;
    }

    public int getNbplacetot() {
        return nbplacetot;
    }

    public void setNbplacetot(int nbplacetot) {
        this.nbplacetot = nbplacetot;
    }

    public SexeCompagnie getSexeCompagnie() {
        return sexeCompagnie;
    }

    public void setSexeCompagnie(SexeCompagnie sexeCompagnie) {
        this.sexeCompagnie = sexeCompagnie;
    }





}
