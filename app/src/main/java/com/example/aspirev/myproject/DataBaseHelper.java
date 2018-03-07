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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
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
}
