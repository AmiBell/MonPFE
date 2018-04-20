package Local;

import java.util.List;

import Classes.Escale;
import Database.IEscaleDatasource;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class EscaleDatasource implements IEscaleDatasource {



    private EscaleDAO escaleDAO;
    private static EscaleDatasource mInstance;

    public EscaleDatasource(EscaleDAO escaleDAO) {
        this.escaleDAO = escaleDAO;
    }

    public static EscaleDatasource getInstance(EscaleDAO escaleDAO){

        if (mInstance== null){
            mInstance= new EscaleDatasource(escaleDAO);
        }
        return mInstance;
    }

    @Override
    public Flowable<Escale> getEscaleById(int escaleID) {
        return escaleDAO.getEscaleById(escaleID);
    }

    @Override
    public Flowable<List<Escale>> getAllEscales() {
        return escaleDAO.getAllEscales();
    }

    @Override
    public void insertEscale(Escale... escales) {
        escaleDAO.insertEscale(escales);
    }

    @Override
    public void updateEscale(Escale... escales) {
        escaleDAO.updateEscale(escales);
    }

    @Override
    public void deleteEscale(Escale escale) {
        escaleDAO.deleteEscale(escale);
    }

    @Override
    public void deleteAllEscales() {
        escaleDAO.deleteAllEscales();
    }
}
