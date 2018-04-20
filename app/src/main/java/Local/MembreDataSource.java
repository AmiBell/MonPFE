package Local;

import java.util.List;

import Classes.Membre;
import Database.IMembreDatasource;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class MembreDataSource implements IMembreDatasource {


    private MembreDAO membreDAO;
    private static MembreDataSource mInstance;

    public MembreDataSource(MembreDAO userDAO) {
        this.membreDAO = userDAO;
    }

    public static MembreDataSource getInstance(MembreDAO membreDAO){

        if (mInstance== null){
            mInstance= new MembreDataSource(membreDAO);
        }
        return mInstance;
    }

    @Override
    public Flowable<Membre> getUserById(String membreID) {
        return membreDAO.getUserById(membreID);
    }

    @Override
    public Flowable<List<Membre>> getAllUsers() {
        return membreDAO.getAllUsers();
    }

    @Override
    public void insertUser(Membre... membres) {
        membreDAO.insertUser(membres);
    }

    @Override
    public void UpdateUser(Membre... membres) {
        membreDAO.UpdateUser(membres);
    }

    @Override
    public void DeleteUser(Membre membre) {
        membreDAO.DeleteUser(membre);
    }

    @Override
    public void deleteAllUsers() {
        membreDAO.deleteAllUsers();
    }
}
