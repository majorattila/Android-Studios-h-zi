package com.example.diak.log_reg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class AdatbazisSegito extends SQLiteOpenHelper{

    //Adatbázis felépítése
    public static final String DATABASE_NAME = "homework.db";     //Adatbázis fájl név
    public static final String TABLE_NAME = "rhb4hbje";     //Tábla név

    public static final String COL_1 = "ID";            //Első oszlop neve
    public static final String COL_2 = "USERNAME";    //Második oszlop neve
    public static final String COL_3 = "PWORD";    //Harmadik oszlop neve
    public static final String COL_4 = "FULLNAME";          //Negyedik oszlop neve

    public AdatbazisSegito(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    //Létrehozzuk a táblát és a benne lévő oszlopokhoz típust adunk

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, KERESZTNEV TEXT, VEZETEKNEV TEXT, JEGY INTEGER)");
    }

    //Dobja el a táblát, ha már ilyen létezik

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //Adat lekérdezés

    public Cursor adatLekerdezes(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * from " + TABLE_NAME, null);
        return result;
    }

    //Adat felvétel
    public boolean adatRogzites(String username, String pword, String full_name){
        SQLiteDatabase db = this.getWritableDatabase();
        this.onUpgrade(db,8,8);
        this.onCreate(db);
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, username);
        contentValues.put(COL_3, pword);
        contentValues.put(COL_4, full_name);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;       //Sikertelen adatfelvétel
        }else{
            return true;        //Sikeres adatfelvétel
        }
    }

    //Bejelentkezés
    public boolean login(String username, String pword){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * from " + TABLE_NAME + " WHERE USERNAME LIKE '" + username + "' AND PWORD LIKE '" + pword + "' LIMIT 1", null);
        return result.getCount()==1; //ha van találat, akkor sikeres
    }

    //Név lekérdezése
    public String get_fullname(String username){
        String output = "";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * from " + TABLE_NAME + " WHERE USERNAME LIKE " + username + "LIMIT 1", null);

        if(result!=null && result.getCount()>0) {
            output = result.getString(0);
        }

        return output;
    }
}
