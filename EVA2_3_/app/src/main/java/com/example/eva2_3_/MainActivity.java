package com.example.eva2_3_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase slDB;
    EditText edTxtNomb, edTxtApe;
    TextView txtVwVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //vincular datos pendiente
        edTxtNomb = findViewById(R.id.edTxtNomb);
        edTxtApe = findViewById(R.id.edTxtApe);
        txtVwVista = findViewById(R.id.txtVwVista);


        slDB = openOrCreateDatabase("db_prueba",MODE_PRIVATE,null);
        try {
            slDB.execSQL("create table  datos (datos integer primary key autoincrement, nombre text, apellido text)");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void onClick (View v){
        ContentValues cvDatos = new ContentValues();
        cvDatos.put("noombre",edTxtNomb.getText().toString());
        cvDatos.put("apellido",edTxtApe.getText().toString());
        slDB.insert("datos",null,cvDatos);

    }
}
