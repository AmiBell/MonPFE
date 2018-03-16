package Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Escale;
import Classes.Offre;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */
@Dao
public interface OffreDAO {
    @Query("SELECT * FROM  offre WHERE id_offre =:offreID")
    Flowable<Offre> getOffreById(int offreID);

    @Query("SELECT * FROM offre")
    Flowable<List<Offre>> getAllOffres();

    @Insert
    void insertOffre(Offre... offres);

    @Update
    void updateOffre(Offre... offres);

    @Delete
    void deleteOffre(Offre offres);

    @Query("DELETE FROM offre")
    void deleteAllOffres();
}
