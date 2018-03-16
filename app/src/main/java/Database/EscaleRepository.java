package Database;

import java.util.List;

import Classes.Escale;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class EscaleRepository implements IEscaleDatasource {

    private IEscaleDatasource mLocalDataSource;
    private static EscaleRepository mInstance;

    public EscaleRepository(IEscaleDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static EscaleRepository getmInstance(IEscaleDatasource mLocalDataSource){
        if(mInstance==null)
        {
            mInstance= new EscaleRepository(mLocalDataSource);
        }
        return mInstance;
    }


    @Override
    public Flowable<Escale> getEscaleById(int escaleID) {
        return mLocalDataSource.getEscaleById(escaleID);
    }

    @Override
    public Flowable<List<Escale>> getAllEscales() {
        return mLocalDataSource.getAllEscales();
    }

    @Override
    public void insertEscale(Escale... escales) {
        mLocalDataSource.insertEscale(escales);
    }

    @Override
    public void updateEscale(Escale... escales) {
        mLocalDataSource.updateEscale(escales);
    }

    @Override
    public void deleteEscale(Escale escale) {
        mLocalDataSource.deleteEscale(escale);
    }

    @Override
    public void deleteAllEscales() {
        mLocalDataSource.deleteAllEscales();
    }
}
