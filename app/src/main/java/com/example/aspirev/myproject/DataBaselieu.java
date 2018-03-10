package com.example.aspirev.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AspireV on 2018-03-09.
 */

public class DataBaselieu  extends SQLiteOpenHelper{
    private static final String DATABASE_NAME="covoiturage.db";

    private static final String TABLE_NAME ="table_preference";
    private static final String COL_1 ="id_preference" ;
    private static final String COL_2="music" ;
    private static final String COL_3="cigarette" ;
    private static final String COL_4="discussion";


    public DataBaselieu(Context context) {
        super(context, DATABASE_NAME, null,1);
        // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String  SQL_String = "CREATE TABLE " + TABLE_NAME + " ( "
                + COL_1 +" TEXT PRIMARY KEY Autoincriment, "
                + COL_2 +" TEXT NOT NULL, "
                + COL_3 +" TEXT NOT NULL, "
                + COL_4 +" TEXT NOT NULL ); "
                ;

        db.execSQL(SQL_String);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        onCreate(db);
    }

    public boolean insertMembre(String id_preference, String music, String cigarette, String discussion){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id_preference);
        contentValues.put(COL_2,music);
        contentValues.put(COL_3,cigarette);
        contentValues.put(COL_4,discussion);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1) return false;
        return true;
    }


}
