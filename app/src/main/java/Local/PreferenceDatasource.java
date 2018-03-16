package Local;

import java.util.List;

import Classes.Preference;
import Database.IPreferenceDatasource;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class PreferenceDatasource implements IPreferenceDatasource {

    private PreferenceDAO preferenceDAO;
    private static PreferenceDatasource mInstance;

    public PreferenceDatasource(PreferenceDAO preferenceDAO) {
        this.preferenceDAO = preferenceDAO;
    }

    public static PreferenceDatasource getInstance(PreferenceDAO preferenceDAO){

        if (mInstance== null){
            mInstance= new PreferenceDatasource(preferenceDAO);
        }
        return mInstance;
    }


    @Override
    public Flowable<Preference> getPreferenceById(int preferenceID) {
        return preferenceDAO.getPreferenceById(preferenceID);
    }

    @Override
    public Flowable<List<Preference>> getAllPreferences() {
        return preferenceDAO.getAllPreferences();
    }

    @Override
    public void insertPreference(Preference... preferences) {
        preferenceDAO.insertPreference(preferences);
    }

    @Override
    public void updatePreference(Preference... preferences) {
        preferenceDAO.updatePreference(preferences);
    }

    @Override
    public void deletePreference(Preference preference) {
        preferenceDAO.deletePreference(preference);
    }

    @Override
    public void deleteAllPreferences() {
        preferenceDAO.deleteAllPreferences();
    }
}
