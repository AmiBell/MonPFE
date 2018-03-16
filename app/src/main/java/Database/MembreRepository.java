package Database;

import java.util.List;

import Classes.Membre;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class MembreRepository implements IMembreDatasource {

    private IMembreDatasource mLocalDataSource;
    private static MembreRepository mInstance;

    public MembreRepository(IMembreDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static MembreRepository getmInstance(IMembreDatasource mLocalDataSource){
        if(mInstance==null)
        {
            mInstance= new MembreRepository(mLocalDataSource);
        }
        return mInstance;
    }

    @Override
    public Flowable<Membre> getUserById(String membreID) {
        return mLocalDataSource.getUserById(membreID);
    }

    @Override
    public Flowable<List<Membre>> getAllUsers() {
        return mLocalDataSource.getAllUsers();
    }

    @Override
    public void insertUser(Membre... membres) {
        mLocalDataSource.insertUser(membres);
    }

    @Override
    public void UpdateUser(Membre... membres) {
        mLocalDataSource.UpdateUser(membres);
    }

    @Override
    public void DeleteUser(Membre membre) {
        mLocalDataSource.DeleteUser(membre);
    }

    @Override
    public void deleteAllUsers() {
        mLocalDataSource.deleteAllUsers();
    }
}
