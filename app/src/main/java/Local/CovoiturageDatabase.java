package Local;

/**
 * Created by lenovo on 16/03/2018.
 */
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import Classes.Escale;
import Classes.Lieu;
import Classes.Membre;
import Classes.Offre;
import Classes.Preference;
import Classes.Reservation;
import Classes.Vehicule;
import Classes.Wilaya;

import static Local.CovoiturageDatabase.DATABASE_VERSION;

@Database(entities = {Membre.class, Offre.class, Reservation.class, Escale.class, Lieu.class,
                     Preference.class, Vehicule.class,Wilaya.class},version = DATABASE_VERSION)
public abstract class CovoiturageDatabase extends RoomDatabase {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME ="Covoiturage";


    public abstract MembreDAO membreDAO();
    public abstract EscaleDAO escaleDAO();
    public abstract LieuDAO lieuDAO();
    public abstract OffreDAO offreDAO();
    public abstract PreferenceDAO preferenceDAO();
    public abstract ReservationDAO reservationDAO();
    public abstract VehiculeDAO vehiculeDAO();
    public abstract WilayaDAO wilayaDAO();

    private static CovoiturageDatabase mInstance;

    public static CovoiturageDatabase getmInstance(Context context){
        if(mInstance==null){
            mInstance= Room.databaseBuilder(context,CovoiturageDatabase.class,DATABASE_NAME)
                    .build();
        }
        return mInstance;
    }
}
