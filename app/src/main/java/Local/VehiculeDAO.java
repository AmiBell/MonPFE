package Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Escale;
import Classes.Reservation;
import Classes.Vehicule;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */
@Dao
public interface VehiculeDAO {
    @Query("SELECT * FROM  vehicule WHERE matricule =:vehiculeID")
    Flowable<Vehicule> getVehiculeById(long vehiculeID);

    @Query("SELECT * FROM vehicule")
    Flowable<List<Vehicule>> getAllVehicules();

    @Insert
    void insertVehicule(Vehicule... vehicules);

    @Update
    void updateVehicule(Vehicule... vehicules);

    @Delete
    void deleteVehicule(Vehicule vehicule);

    @Query("DELETE FROM vehicule")
    void deleteAllVehicules();
}
