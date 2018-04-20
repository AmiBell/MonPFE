package Database;

import java.util.List;

import Classes.Lieu;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class LieuRepository implements ILieuDatasource {


    private ILieuDatasource mLocalDataSource;
    private static LieuRepository mInstance;

    public LieuRepository(ILieuDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static LieuRepository getmInstance(ILieuDatasource mLocalDataSource){
        if(mInstance==null)
        {
            mInstance= new LieuRepository(mLocalDataSource);
        }
        return mInstance;
    }

    @Override
    public Flowable<Lieu> getLieuById(String lieuID) {
        return mLocalDataSource.getLieuById(lieuID);
    }

    @Override
    public Flowable<List<Lieu>> getAllLieux() {
        return mLocalDataSource.getAllLieux();
    }

    @Override
    public void insertLieux(Lieu... lieu) {
        mLocalDataSource.insertLieux(lieu);
    }

    @Override
    public void updateLieux(Lieu... lieus) {
        mLocalDataSource.updateLieux(lieus);
    }

    @Override
    public void deleteLieu(Lieu leius) {
        mLocalDataSource.deleteLieu(leius);
    }

    @Override
    public void deleteAllLieux() {
        mLocalDataSource.deleteAllLieux();
    }
}
