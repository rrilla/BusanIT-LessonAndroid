package com.example.helperapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String NAME = "employee.db";
    public static int VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        printLog("onCreate() 호출");
        String sql = "create table if not exists emp("
                +"_id integer primary key autoincrement,"
                +"name text,"
                +"age integer,"
                +"mobile text)";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        printLog("onOpen() 호출");
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        printLog("onUpgrade() 호출 : " + oldVersion + "->" + newVersion);
        if(newVersion > 1){
            sqLiteDatabase.execSQL("drop table if exists emp");
        }
    }

    public void printLog(String data){
        Log.d("DatabaseHelper", data);
    }
}
