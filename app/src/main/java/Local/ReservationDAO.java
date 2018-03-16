package Local;

import android.arch.persistence.room.Dao;
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
@Dao
public interface ReservationDAO {
    @Query("SELECT * FROM  reservation WHERE id_reservation =:reservationID")
    Flowable<Reservation> getReservationById(int reservationID);

    @Query("SELECT * FROM reservation")
    Flowable<List<Reservation>> getAllReservations();

    @Insert
    void insertReservation(Reservation... reservations);

    @Update
    void updateReservation(Reservation... reservations);

    @Delete
    void deleteReservation(Reservation reservation);

    @Query("DELETE FROM reservation")
    void deleteAllReservations();
}
