package com.example.myalistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;



public class Databasehelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME="mylist.db";
    public static String TABLE_NAME="mylist_data";
    public static String COL1="ID";
    public static String COL2="NAME";
    public static String COL3="PASSWORD";
    public Databasehelper( Context context ){super(context,DATABASE_NAME, null ,1);}


    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry="create table tb_student (ID INTEGER primary key autoincrement , NAME TEXT ,PASSWORD TEXT)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);


    }
    public boolean addData(String NAME) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, NAME);
        //contentValues.put(COL3, PASSWORD);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListcontent(){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.rawQuery("SELECT *,"+TABLE_NAME,null);
    }


}