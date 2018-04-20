package Database;

import java.util.List;

import Classes.Escale;
import Classes.Reservation;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class ReservationRepository implements IReservationDatasource {

    private IReservationDatasource mLocalDataSource;
    private static ReservationRepository mInstance;

    public ReservationRepository(IReservationDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static ReservationRepository getmInstance(IReservationDatasource mLocalDataSource){
        if(mInstance==null)
        {
            mInstance= new ReservationRepository(mLocalDataSource);
        }
        return mInstance;
    }


    @Override
    public Flowable<Reservation> getReservationById(int reservationID) {
        return mLocalDataSource.getReservationById(reservationID);
    }

    @Override
    public Flowable<List<Reservation>> getAllReservations() {
        return mLocalDataSource.getAllReservations();
    }

    @Override
    public void insertReservation(Reservation... reservations) {
        mLocalDataSource.insertReservation(reservations);
    }

    @Override
    public void updateReservation(Reservation... reservations) {
        mLocalDataSource.updateReservation(reservations);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        mLocalDataSource.deleteReservation(reservation);
    }

    @Override
    public void deleteAllReservations() {
        mLocalDataSource.deleteAllReservations();
    }
}
