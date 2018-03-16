package Local;

import java.util.List;

import Classes.Lieu;
import Database.ILieuDatasource;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class LieuDatasource implements ILieuDatasource {


    private LieuDAO lieuDAO;
    private static LieuDatasource mInstance;

    public LieuDatasource(LieuDAO lieuDAO) {
        this.lieuDAO = lieuDAO;
    }

    public static LieuDatasource getInstance(LieuDAO lieuDAO){

        if (mInstance== null){
            mInstance= new LieuDatasource(lieuDAO);
        }
        return mInstance;
    }


    @Override
    public Flowable<Lieu> getLieuById(String lieuID) {
        return lieuDAO.getLieuById(lieuID);
    }

    @Override
    public Flowable<List<Lieu>> getAllLieux() {
        return null;
    }

    @Override
    public void insertLieux(Lieu... lieu) {

    }

    @Override
    public void updateLieux(Lieu... lieus) {

    }

    @Override
    public void deleteLieu(Lieu leius) {

    }

    @Override
    public void deleteAllLieux() {

    }
}
