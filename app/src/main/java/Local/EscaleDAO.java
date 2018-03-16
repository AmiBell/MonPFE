package Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Escale;
import Classes.Membre;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */
@Dao
public interface EscaleDAO {
    @Query("SELECT * FROM  escale WHERE id_escale =:escaleID")
    Flowable<Escale> getEscaleById(int escaleID);

    @Query("SELECT * FROM escale")
    Flowable<List<Escale>> getAllEscales();

    @Insert
    void insertEscale(Escale... escales);

    @Update
    void updateEscale(Escale... escales);

    @Delete
    void deleteEscale(Escale escale);

    @Query("DELETE FROM escale")
    void deleteAllEscales();
}
