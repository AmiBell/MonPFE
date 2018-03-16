package Local;

import java.util.List;

import Classes.Escale;
import Classes.Reservation;
import Database.IReservationDatasource;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public class ResevationDatasource implements IReservationDatasource {

    private ReservationDAO reservationDAO;
    private static ResevationDatasource mInstance;

    public ResevationDatasource(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public static ResevationDatasource getInstance(ReservationDAO reservationDAO){

        if (mInstance== null){
            mInstance= new ResevationDatasource(reservationDAO);
        }
        return mInstance;
    }


    @Override
    public Flowable<Reservation> getReservationById(int reservationID) {
        return reservationDAO.getReservationById(reservationID);
    }

    @Override
    public Flowable<List<Reservation>> getAllReservations() {
        return reservationDAO.getAllReservations();
    }

    @Override
    public void insertReservation(Reservation... reservations) {
        reservationDAO.insertReservation(reservations);
    }

    @Override
    public void updateReservation(Reservation... reservations) {
        reservationDAO.updateReservation(reservations);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationDAO.deleteReservation(reservation);
    }

    @Override
    public void deleteAllReservations() {
        reservationDAO.deleteAllReservations();
    }
}
