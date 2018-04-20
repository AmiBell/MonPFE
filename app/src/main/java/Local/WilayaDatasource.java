package Local;

import java.util.List;

import Classes.Wilaya;
import Database.IWilayaDatasource;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class WilayaDatasource implements IWilayaDatasource {

    private WilayaDAO wilayaDAO;
    private static WilayaDatasource mInstance;

    public WilayaDatasource(WilayaDAO wilayaDAO) {
        this.wilayaDAO = wilayaDAO;
    }

    public static WilayaDatasource getInstance(WilayaDAO wilayaDAO){

        if (mInstance== null){
            mInstance= new WilayaDatasource(wilayaDAO);
        }
        return mInstance;
    }


    @Override
    public Flowable<Wilaya> getWilayaById(int wilayaID) {
        return wilayaDAO.getWilayaById(wilayaID);
    }

    @Override
    public Flowable<List<Wilaya>> getAllWilaya() {
        return wilayaDAO.getAllWilaya();
    }

    @Override
    public void insertWilaya(Wilaya... wilayas) {
        wilayaDAO.insertWilaya(wilayas);
    }

    @Override
    public void updateWilaya(Wilaya... wilayas) {
        wilayaDAO.updateWilaya(wilayas);
    }

    @Override
    public void deleteWilaya(Wilaya wilaya) {
        wilayaDAO.deleteWilaya(wilaya);
    }

    @Override
    public void deleteAllWilaya() {
        wilayaDAO.deleteAllWilaya();
    }
}
