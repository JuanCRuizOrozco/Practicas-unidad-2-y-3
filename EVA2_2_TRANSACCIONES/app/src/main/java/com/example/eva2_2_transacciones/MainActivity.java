package com.example.eva2_2_transacciones;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqDB = openOrCreateDatabase("mi_db",MODE_PRIVATE,null);
        try{
            sqDB.execSQL("create table prueba( pruebaid integer primary key autoincrement, algo text)");

        }catch (SQLException e){
            e.printStackTrace();
        }
        sqLiteDatabase.execSQL("CREATE TABLE prueba(pruebaid INTEGER PRIMARY KEY AUTOINCREMENT, algo TEXT)");

        try {
            sqDB.execSQL("insert  into prueba(algo) values ('Juano') ");
            sqDB.execSQL("insert  into prueba(algo) values ('Pepino') ");
            //int i = 1/0;
            sqDB.execSQL("insert  into prueba(algo) values ('Piedrito') ");
            sqDB.execSQL("insert  into prueba(algo) values ('El cacas')");
            sqDB.setTransactionSuccessful();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqDB.endTransaction();
        }
        String[] args= {"Juano"};

        Cursor cursor  = sqDB.rawQuery("select * from pureba where algo = ?",args);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Log.wtf("cursor",cursor.getString(cursor.getColumnIndex("algo")));
            Cursor.moveToNext();


        }


    }
}
