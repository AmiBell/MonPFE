package Database;

import java.util.List;

import Classes.Preference;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class PreferenceRepository implements IPreferenceDatasource {

    private IPreferenceDatasource mLocalDataSource;
    private static PreferenceRepository mInstance;

    public PreferenceRepository(IPreferenceDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static PreferenceRepository getmInstance(IPreferenceDatasource mLocalDataSource){
        if(mInstance==null)
        {
            mInstance= new PreferenceRepository(mLocalDataSource);
        }
        return mInstance;
    }


    @Override
    public Flowable<Preference> getPreferenceById(int preferenceID) {
        return mLocalDataSource.getPreferenceById(preferenceID);
    }

    @Override
    public Flowable<List<Preference>> getAllPreferences() {
        return mLocalDataSource.getAllPreferences();
    }

    @Override
    public void insertPreference(Preference... preferences) {
        mLocalDataSource.insertPreference(preferences);
    }

    @Override
    public void updatePreference(Preference... preferences) {
        mLocalDataSource.updatePreference(preferences);
    }

    @Override
    public void deletePreference(Preference preference) {
        mLocalDataSource.deletePreference(preference);
    }

    @Override
    public void deleteAllPreferences() {
        mLocalDataSource.deleteAllPreferences();
    }
}
