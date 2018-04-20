package Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Wilaya;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public interface IWilayaDatasource {

    Flowable<Wilaya> getWilayaById(int wilayaID);

    Flowable<List<Wilaya>> getAllWilaya();

    void insertWilaya(Wilaya... wilayas);

    void updateWilaya(Wilaya... wilayas);

    void deleteWilaya(Wilaya wilaya);

    void deleteAllWilaya();
}
