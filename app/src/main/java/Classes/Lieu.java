package Classes;

/**
 * Created by AspireV on 2018-03-09.
 */

public class Lieu {
    private double lattitude ;
    private double logittude  ;
    private String nomlieu ;

    public Lieu(double lattitude, double logittude, String nomlieu) {
        this.lattitude = lattitude;
        this.logittude = logittude;
        this.nomlieu = nomlieu;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public double getLogittude() {
        return logittude;
    }
    public void setLogittude(double logittude) {
        this.logittude= logittude ;
    }

    public void setNomlieu(String nomlieu) {
        this.nomlieu = nomlieu;
    }

    public String getNomlieu() {
        return nomlieu;
    }





}
