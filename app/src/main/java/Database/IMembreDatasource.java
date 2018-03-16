package Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Membre;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public interface IMembreDatasource {

    Flowable<Membre> getUserById(String membreID);

    Flowable<List<Membre>> getAllUsers();

    void insertUser(Membre... membres);

    void UpdateUser(Membre... membres);

    void DeleteUser(Membre membre);

    void deleteAllUsers();
}
