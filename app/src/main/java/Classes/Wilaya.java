package Classes;

/**
 * Created by AspireV on 2018-03-09.
 */

public class Wilaya{
        private int codeW ;
        private String nomW ;
        private double lattitude ;
        private double logitude ;

        public Wilaya(int codeW, String nomW, double lattitude, double logitude) {
            this.codeW = codeW;
            this.nomW = nomW;
            this.lattitude = lattitude;
            this.logitude = logitude;
        }
        public int getCodeW() {
            return codeW;
        }

        public void setCodeW(int codeW) {
            this.codeW = codeW;
        }

        public String getNomW() {
            return nomW;
        }

        public void setNomW(String nomW) {
            this.nomW = nomW;
        }

        public double getLattitude() {
            return lattitude;
        }

        public void setLattitude(double lattitude) {
            this.lattitude = lattitude;
        }

        public double getLogitude() {
            return logitude;
        }

        public void setLogitude(double logitude) {
            this.logitude = logitude;
        }


}
