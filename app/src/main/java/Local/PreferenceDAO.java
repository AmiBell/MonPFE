package Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Escale;
import Classes.Preference;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */
@Dao
public interface PreferenceDAO {
    @Query("SELECT * FROM  preference WHERE id_preference =:preferenceID")
    Flowable<Preference> getPreferenceById(int preferenceID);

    @Query("SELECT * FROM preference")
    Flowable<List<Preference>> getAllPreferences();

    @Insert
    void insertPreference(Preference... preferences);

    @Update
    void updatePreference(Preference... preferences);

    @Delete
    void deletePreference(Preference preference);

    @Query("DELETE FROM preference")
    void deleteAllPreferences();
}
