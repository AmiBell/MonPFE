package com.example.aspirev.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AspireV on 2018-03-09.
 */

public class DataBaseWilaya extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="covoiturage.db";

    private static final String TABLE_NAME ="table_wilaya";
    private static final String COL_1 ="lattitude" ;
    private static final String COL_2="logittude" ;
    private static final  String COL_3="codew" ;
    private static final String COL_4="nomlieu";


    public DataBaseWilaya(Context context) {
        super(context, DATABASE_NAME, null,1);
        // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String  SQL_String = "CREATE TABLE " + TABLE_NAME + " ( "
                + COL_1 +" float PRIMARY KEY , "
                + COL_2 +" float PRIMARY KEY , "
                + COL_3 +" TEXT NOT NULL FOREIGN KEY(codew) REFERECES table_wilaya,  "
                + COL_4 +" TEXT NOT NULL, "

                ;

        db.execSQL(SQL_String);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        onCreate(db);
    }

    public boolean insertMembre(String codew, float lattitude,float logittude, String nomwilaya){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,codew);
        contentValues.put(COL_2,lattitude);
        contentValues.put(COL_3,logittude);
        contentValues.put(COL_4,nomwilaya);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1) return false;
        return true;
    }


}
