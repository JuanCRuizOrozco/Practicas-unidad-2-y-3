package com.example.eva2_1_;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = openOrCreateDatabase("myFriends", MODE_PRIVATE, null);
        //se crea la base de datos
        db.execSQL("create table hola (id int, nombre text)");
        db.execSQL("insert into hola values (1,'Ruben')");
        //estas madres sirven para ejecutar instrucciones sql db.execSQL


    }
}
