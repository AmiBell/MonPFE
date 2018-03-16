package Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Vehicule;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public interface IVehiculeDatasource {

    Flowable<Vehicule> getVehiculeById(int vehiculeID);

    Flowable<List<Vehicule>> getAllVehicules();

    void insertVehicule(Vehicule... vehicules);

    void updateVehicule(Vehicule... vehicules);

    void deleteVehicule(Vehicule vehicule);

    void deleteAllVehicules();
}
