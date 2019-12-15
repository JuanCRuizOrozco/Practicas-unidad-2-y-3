package com.example.eva2_7_sqlite_sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase sqLiteDatabase;
    private final String DIRECTORY = "eva2_7_sqlite_sdcard";
    private final String DATABASE = "prueba";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // obtener la ruta de la sd card

        String sdPath = Environment.getExternalStorageDirectory().getPath();

        File fPath = new File(sdPath +"/"+ DIRECTORY+"/");

        if(!fPath.exists()){
            fPath.mkdir(); // si la ruta no existe la crea
        }
        String sPath = sdPath+"/"+DIRECTORY+"/"+DATABASE;
        sqLiteDatabase = SQLiteDatabase.openDatabase(sPath,null, SQLiteDatabase.CREATE_IF_NECESSARY);

    }
}
