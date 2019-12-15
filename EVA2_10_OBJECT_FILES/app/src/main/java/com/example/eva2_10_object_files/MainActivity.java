package com.example.eva2_10_object_files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button btnGuardar;
    private EditText edtxtName, edtxtApe;
    private RadioButton rbtnMas, rbtnFem, rbtnOtro;
    private TextView txtVwData;

    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = findViewById(R.id.btnGuardar);
        edtxtName = findViewById(R.id.edtxtName);
        edtxtApe = findViewById(R.id.edtxtApe);
        rbtnMas = findViewById(R.id.rbtnMas);
        rbtnFem = findViewById(R.id.rbtnFem);
        rbtnOtro = findViewById(R.id.rbtnOtro);
        txtVwData = findViewById(R.id.txtVwData);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
                leer();
            }
        });
    }

    public void guardar(){

        String name = edtxtName.getText().toString();
        String ape = edtxtApe.getText().toString();
        int gener = 0;
        if(rbtnMas.isChecked()){
            gener = 1;
        }else if(rbtnFem.isChecked()){
            gener = 2;
        }else if(rbtnOtro.isChecked()){
            gener = 3;
        }

        Personas personas = new Personas(name, ape, gener);

        try {
            fileOutputStream = openFileOutput("datos.xxx",0);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(personas);
            objectOutputStream.writeObject(new Personas());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void leer(){
        try {
            fileInputStream = openFileInput("datos.xxx");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Personas personas = (Personas) (objectInputStream.readObject());
            while(true){
                txtVwData.append("Nombre: " + personas.getNombre() + " " + personas.getApellido() + "\n");
                txtVwData.append("Genero: " + personas.getGenero() + "\n");
                txtVwData.append("----------------\n");
                personas = (Personas) (objectInputStream.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

    class Personas implements Sezrializable {
    private String nombre;
    private String apellido;
    private int genero;

    public Personas(){
        this.nombre = "Miguel";
        this.apellido = "Balderrama";
        this.genero = 1;
    }

    public Personas(String nombre, String apellido, int genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
}
