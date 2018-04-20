package Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import Classes.Escale;
import Classes.Reservation;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 16/03/2018.
 */

public interface IReservationDatasource {

    Flowable<Reservation> getReservationById(int reservationID);

    Flowable<List<Reservation>> getAllReservations();

    void insertReservation(Reservation... reservations);

    void updateReservation(Reservation... reservations);

    void deleteReservation(Reservation reservation);

    void deleteAllReservations();
}
