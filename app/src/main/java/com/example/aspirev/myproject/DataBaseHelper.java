package com.example.aspirev.myproject;

/**
 * Created by lenovo on 06/03/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="covoiturage.db";

    private static final String TABLE_NAME ="table_membre";
    private static final String COL_1 ="email" ;
    private static final String COL_2="nom" ;
    private static final String COL_3="prenom" ;
    private static final String COL_4="password";
    private static final String COL_5="anneeNaiss";




    private static final String TABLE_NAMEp ="table_prefrence";
    private static final String COLp_1 ="id_preference" ;
    private static final String COLp_2="music" ;
    private static final String COLp_3="cigarette" ;
    private static final String COLp_4="discussion";



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
        // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String  SQL_String = "CREATE TABLE " + TABLE_NAME + " ( "
                + COL_1 +" TEXT PRIMARY KEY, "
                + COL_2 +" TEXT NOT NULL, "
                + COL_3 +" TEXT NOT NULL, "
                + COL_4 +" TEXT NOT NULL, "
                + COL_5 +" INTEGER NOT NULL );";

        db.execSQL(SQL_String);

        String  SQL_String1 = "CREATE TABLE " + TABLE_NAMEp + " ( "
                + COLp_1 +" INTEGER PRIMARY KEY AUTO_INCREMENT, "
                + COLp_2 +" TEXT NOT NULL, "
                + COLp_3 +" TEXT NOT NULL, "
                + COLp_4 +" TEXT NOT NULL ); "
                ;

        db.execSQL(SQL_String1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAMEp +";");
        onCreate(db);
    }

    public boolean insertMembre(String email, String nom, String prenom, String mdp, long anneNaiss){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,email);
        contentValues.put(COL_2,nom);
        contentValues.put(COL_3,prenom);
        contentValues.put(COL_4,mdp);

        contentValues.put(COL_5,anneNaiss);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1) return false;
        return true;
    }

    public boolean insertpreference( String music, String cigarette, String discussion){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLp_2,music);
        contentValues.put(COLp_3,cigarette);
        contentValues.put(COLp_4,discussion);
        long result = db.insert(TABLE_NAMEp,null,contentValues);
        if(result == -1) return false;
        return true;
    }
}
