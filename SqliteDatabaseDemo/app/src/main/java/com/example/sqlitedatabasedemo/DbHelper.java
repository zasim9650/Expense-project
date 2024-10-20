package com.example.sqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
   private static final String DATABASE_NAME="demo_db";
   private static final int DATABASE_VERSION=1;


    public DbHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_QUERY="CREATE TABLE Register(id INTEGER PRIMARY KEY AutoIncrement ,name TEXT,email TEXT, password NUMBER,gender TEXT)";
sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Register");
        onCreate(sqLiteDatabase);

    }
    public void registerUserHelper(String name,String email, String pass,String gender){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("key_name",name);
        contentValues.put("key_email",email);
        contentValues.put("key_pass",pass);
        contentValues.put("key_gender",gender);
        sqLiteDatabase.insert("Register",null,contentValues);
        sqLiteDatabase.close();

    }
}
