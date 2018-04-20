package Database;

import java.util.List;

import Classes.Offre;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class OffreRepository implements IOffreDatasource {


    private IOffreDatasource mLocalDataSource;
    private static OffreRepository mInstance;

    public OffreRepository(IOffreDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static OffreRepository getmInstance(IOffreDatasource mLocalDataSource){
        if(mInstance==null)
        {
            mInstance= new OffreRepository(mLocalDataSource);
        }
        return mInstance;
    }

    @Override
    public Flowable<Offre> getOffreById(int offreID) {
        return mLocalDataSource.getOffreById(offreID);
    }

    @Override
    public Flowable<List<Offre>> getAllOffres() {
        return mLocalDataSource.getAllOffres();
    }

    @Override
    public void insertOffre(Offre... offres) {
        mLocalDataSource.insertOffre(offres);
    }

    @Override
    public void updateOffre(Offre... offres) {
        mLocalDataSource.updateOffre(offres);
    }

    @Override
    public void deleteOffre(Offre offres) {
        mLocalDataSource.deleteOffre(offres);
    }

    @Override
    public void deleteAllOffres() {
        mLocalDataSource.deleteAllOffres();
    }
}
