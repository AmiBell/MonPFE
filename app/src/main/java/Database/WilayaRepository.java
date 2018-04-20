package Database;

import java.util.List;

import Classes.Wilaya;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class WilayaRepository implements IWilayaDatasource {

    private IWilayaDatasource mLocalDataSource;
    private static WilayaRepository mInstance;

    public WilayaRepository(IWilayaDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static WilayaRepository getmInstance(IWilayaDatasource mLocalDataSource){
        if(mInstance==null)
        {
            mInstance= new WilayaRepository(mLocalDataSource);
        }
        return mInstance;
    }


    @Override
    public Flowable<Wilaya> getWilayaById(int wilayaID) {
        return mLocalDataSource.getWilayaById(wilayaID);
    }

    @Override
    public Flowable<List<Wilaya>> getAllWilaya() {
        return mLocalDataSource.getAllWilaya();
    }

    @Override
    public void insertWilaya(Wilaya... wilayas) {
        mLocalDataSource.insertWilaya(wilayas);
    }

    @Override
    public void updateWilaya(Wilaya... wilayas) {
        mLocalDataSource.updateWilaya(wilayas);
    }

    @Override
    public void deleteWilaya(Wilaya wilaya) {
        mLocalDataSource.deleteWilaya(wilaya);
    }

    @Override
    public void deleteAllWilaya() {
        mLocalDataSource.deleteAllWilaya();
    }
}
