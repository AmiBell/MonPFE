package Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Preference;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public interface IPreferenceDatasource {

    Flowable<Preference> getPreferenceById(int preferenceID);

    Flowable<List<Preference>> getAllPreferences();

    void insertPreference(Preference... preferences);

    void updatePreference(Preference... preferences);

    void deletePreference(Preference preference);

    void deleteAllPreferences();
}
