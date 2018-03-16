package Database;

import java.util.List;

import Classes.Vehicule;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class VehiculeRepository implements IVehiculeDatasource {

    private IVehiculeDatasource mLocalDataSource;
    private static VehiculeRepository mInstance;

    public VehiculeRepository(IVehiculeDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static VehiculeRepository getmInstance(IVehiculeDatasource mLocalDataSource){
        if(mInstance==null)
        {
            mInstance= new VehiculeRepository(mLocalDataSource);
        }
        return mInstance;
    }


    @Override
    public Flowable<Vehicule> getVehiculeById(int vehiculeID) {
        return mLocalDataSource.getVehiculeById(vehiculeID);
    }

    @Override
    public Flowable<List<Vehicule>> getAllVehicules() {
        return mLocalDataSource.getAllVehicules();
    }

    @Override
    public void insertVehicule(Vehicule... vehicules) {
        mLocalDataSource.insertVehicule(vehicules);
    }

    @Override
    public void updateVehicule(Vehicule... vehicules) {
        mLocalDataSource.updateVehicule(vehicules);
    }

    @Override
    public void deleteVehicule(Vehicule vehicule) {
        mLocalDataSource.deleteVehicule(vehicule);
    }

    @Override
    public void deleteAllVehicules() {
        mLocalDataSource.deleteAllVehicules();
    }
}
