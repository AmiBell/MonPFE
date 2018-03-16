package Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Lieu;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public interface ILieuDatasource {

    Flowable<Lieu> getLieuById(String lieuID);

    Flowable<List<Lieu>> getAllLieux();

    void insertLieux(Lieu... lieu);

    void updateLieux(Lieu... lieus);

    void deleteLieu(Lieu leius);

    void deleteAllLieux();
}
