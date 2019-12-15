package com.example.eva2_9_internal_space;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText edTxtInfo;
    private TextView txtVwInfo;
    private Button btnDisplay;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

    private OutputStream outputStream;
    private OutputStreamWriter outputStreamWriter;
    private BufferedWriter bufferedWriter;

    private final String NAME_FILE = "mi_archivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtInfo = findViewById(R.id.edTxtInfo);
        txtVwInfo = findViewById(R.id.txtVwInfo);
        btnDisplay = findViewById(R.id.btnDisplay);

        try {
            String sCade;
            inputStream = openFileInput(NAME_FILE);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            while((sCade = bufferedReader.readLine()) != null){
                txtVwInfo.setText(sCade);
                txtVwInfo.append("\n");
            }
            bufferedReader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVwInfo.setText("");
                try {
                    String[] cade = edTxtInfo.getText().toString().split("\n");
                    outputStream = openFileOutput(NAME_FILE,0);
                    outputStreamWriter = new OutputStreamWriter(outputStream);
                    bufferedWriter = new BufferedWriter(outputStreamWriter);
                    for (int i=0; i < cade.length; i++){
                        bufferedWriter.append(cade[i]);
                        bufferedWriter.append("\n");


                    }
                    bufferedReader.close();



                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
        });

    }
}
