package Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Offre;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public interface IOffreDatasource {

    Flowable<Offre> getOffreById(int offreID);

    Flowable<List<Offre>> getAllOffres();

    void insertOffre(Offre... offres);

    void updateOffre(Offre... offres);

    void deleteOffre(Offre offres);

    void deleteAllOffres();
}
