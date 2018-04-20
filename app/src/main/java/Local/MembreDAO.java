package Local;

import android.arch.persistence.room.Dao;
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
@Dao
public interface MembreDAO {
    @Query("SELECT * FROM  membres WHERE id_membre =:membreID")
    Flowable<Membre> getUserById(String membreID);

    @Query("SELECT * FROM membres")
    Flowable<List<Membre>> getAllUsers();

    @Insert
    void insertUser(Membre... membres);

    @Update
    void UpdateUser(Membre... membres);

    @Delete
    void DeleteUser(Membre membre);

    @Query("DELETE FROM membres")
    void deleteAllUsers();
}
