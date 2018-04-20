package Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Escale;
import Classes.Lieu;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */
@Dao
public interface LieuDAO {
    @Query("SELECT * FROM  lieu WHERE id_lieu = :lieuID")
    Flowable<Lieu> getLieuById(String lieuID);

    @Query("SELECT * FROM lieu")
    Flowable<List<Lieu>> getAllLieux();

    @Insert
    void insertLieux(Lieu... lieu);

    @Update
    void updateLieux(Lieu... lieus);

    @Delete
    void deleteLieu(Lieu leius);

    @Query("DELETE FROM lieu")
    void deleteAllLieux();
}
