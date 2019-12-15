package com.example.eva2_8_files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    TextView txtVwInfo;

    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwInfo = findViewById(R.id.txtVwInfo);

        inputStream = getResources().openRawResource(R.raw.mi_text);
        inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);

        try {
            String sCade;
            while ((sCade = bufferedReader.readLine()) !=null){
                txtVwInfo.setText(sCade);
                txtVwInfo.append("\n");

            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
