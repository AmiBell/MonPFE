package Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Escale;
import Classes.Reservation;
import Classes.Wilaya;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */
@Dao
public interface WilayaDAO {
    @Query("SELECT * FROM  wilaya WHERE codeW =:wilayaID")
    Flowable<Wilaya> getWilayaById(int wilayaID);

    @Query("SELECT * FROM wilaya")
    Flowable<List<Wilaya>> getAllWilaya();

    @Insert
    void insertWilaya(Wilaya... wilayas);

    @Update
    void updateWilaya(Wilaya... wilayas);

    @Delete
    void deleteWilaya(Wilaya wilaya);

    @Query("DELETE FROM wilaya")
    void deleteAllWilaya();
}
