package com.example.aspirev.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AspireV on 2018-03-09.
 */

public class DataBaseVehicule extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="covoiturage.db";

    private static final String TABLE_NAME ="table_vehicule";
    private static final String COL_1 ="matricule" ;
    private static final String COL_2="marque" ;
    private static final String COL_3="modele" ;
    private static final String COL_4="couleur";
    private static final String COL_5="eEmail";




    public DataBaseVehicule(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String  SQL_String = "CREATE TABLE " + TABLE_NAME + " ( "
                + COL_1 +" TEXT PRIMARY KEY, "
                + COL_2 +" TEXT NOT NULL, "
                + COL_3 +" TEXT NOT NULL, "
                + COL_4 +" TEXT NOT NULL, "
                + COL_5+"TEXT FOREIGN KEY (Email) REFRERENCES table_membre"
                ;

        db.execSQL(SQL_String);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        onCreate(db);
    }

    public boolean insertVehicule(String matricule, String marque, String modele, String couleur,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,matricule);
        contentValues.put(COL_2,marque);
        contentValues.put(COL_3,modele);
        contentValues.put(COL_4,couleur);
        contentValues.put(COL_5,email);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1) return false;
        return true;
    }
}
