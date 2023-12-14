package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

public class DBSLite extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="datos";
    public DBSLite(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + DATABASE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, fecha long)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
    public void guardaDatos(String nombre, long fecha) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("fecha", fecha);
        db.insert(DATABASE_NAME, null, values);
    }


    public Vector<String>listDatos(){
        Vector<String> result=new Vector<String>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, nombre FROM " + DATABASE_NAME + " ORDER BY id", null);

        while(cursor.moveToNext()){
            result.add(cursor.getInt(0)+" "+cursor.getString(1));
        }
        cursor.close();
        return result;
    }
}
