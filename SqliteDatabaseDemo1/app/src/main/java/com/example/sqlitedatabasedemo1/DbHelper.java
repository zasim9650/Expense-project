package com.example.sqlitedatabasedemo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "demo_db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE Register(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,password TEXT ,email TEXT,gender TEXT)";
        db.execSQL(CREATE_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Register");
        onCreate(db);

    }

    public boolean registerUserHelper(String name, String email, String pass, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", pass);
        contentValues.put("gender", gender);

       long l= sqLiteDatabase.insert("Register", null, contentValues);
        sqLiteDatabase.close();

        if(l>0){
            return true;

        }
        else {
            return false;
        }
    }

}
