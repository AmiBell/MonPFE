package Local;

import java.util.List;

import Classes.Vehicule;
import Database.IVehiculeDatasource;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class VehiculeDatasource implements IVehiculeDatasource {

    private VehiculeDAO vehiculeDAO;
    private static VehiculeDatasource mInstance;

    public VehiculeDatasource(VehiculeDAO vehiculeDAO) {
        this.vehiculeDAO= vehiculeDAO;
    }

    public static VehiculeDatasource getInstance(VehiculeDAO vehiculeDAO){

        if (mInstance== null){
            mInstance= new VehiculeDatasource(vehiculeDAO);
        }
        return mInstance;
    }

    @Override
    public Flowable<Vehicule> getVehiculeById(int vehiculeID) {
        return vehiculeDAO.getVehiculeById(vehiculeID);
    }

    @Override
    public Flowable<List<Vehicule>> getAllVehicules() {
        return vehiculeDAO.getAllVehicules();
    }

    @Override
    public void insertVehicule(Vehicule... vehicules) {
        vehiculeDAO.insertVehicule(vehicules);
    }

    @Override
    public void updateVehicule(Vehicule... vehicules) {
        vehiculeDAO.updateVehicule(vehicules);
    }

    @Override
    public void deleteVehicule(Vehicule vehicule) {
        vehiculeDAO.deleteVehicule(vehicule);
    }

    @Override
    public void deleteAllVehicules() {
        vehiculeDAO.deleteAllVehicules();
    }
}
