package Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Escale;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public interface IEscaleDatasource {

    Flowable<Escale> getEscaleById(int escaleID);
   Flowable<List<Escale>> getAllEscales();

    void insertEscale(Escale... escales);


    void updateEscale(Escale... escales);


    void deleteEscale(Escale escale);

    void deleteAllEscales();
}
