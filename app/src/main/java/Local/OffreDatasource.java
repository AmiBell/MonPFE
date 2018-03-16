package Local;

import java.util.List;

import Classes.Offre;
import Database.IOffreDatasource;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class OffreDatasource implements IOffreDatasource {


    private OffreDAO offreDAO;
    private static OffreDatasource mInstance;

    public OffreDatasource(OffreDAO offreDAO) {
        this.offreDAO = offreDAO;
    }

    public static OffreDatasource getInstance(OffreDAO offreDAO){

        if (mInstance== null){
            mInstance= new OffreDatasource(offreDAO);
        }
        return mInstance;
    }


    @Override
    public Flowable<Offre> getOffreById(int offreID) {
        return offreDAO.getOffreById(offreID);
    }

    @Override
    public Flowable<List<Offre>> getAllOffres() {
        return offreDAO.getAllOffres();
    }

    @Override
    public void insertOffre(Offre... offres) {
        offreDAO.insertOffre(offres);
    }

    @Override
    public void updateOffre(Offre... offres) {
        offreDAO.updateOffre(offres);
    }

    @Override
    public void deleteOffre(Offre offres) {
        offreDAO.deleteOffre(offres);
    }

    @Override
    public void deleteAllOffres() {
        offreDAO.deleteAllOffres();
    }
}
