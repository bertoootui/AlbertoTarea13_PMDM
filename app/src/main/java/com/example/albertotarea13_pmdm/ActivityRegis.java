package com.example.albertotarea13_pmdm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ActivityRegis extends AppCompatActivity {
    EditText edtnombre, edtapll,edttlfn,edtmat,edtplaza;
    FloatingActionButton butsave;
    Switch swtdis;
    private static boolean  disc = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        edtapll = findViewById(R.id.edtapell);
        edtmat = findViewById(R.id.edtmat);
        edtnombre = findViewById(R.id.edtnombre);
        edttlfn = findViewById(R.id.edttlfn);
        edtplaza = findViewById(R.id.edtplaza);
        butsave = findViewById(R.id.butsaveregis);
        swtdis = findViewById(R.id.swtdis);

        swtdis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disc = !disc;
            }
        });


        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, apll, mat, plaza;
                int tlfn = Integer.parseInt(edttlfn.getText().toString());
                nombre = edtnombre.getText().toString();
                apll = edtapll.getText().toString();
                mat = edtmat.getText().toString();
                plaza = edtplaza.getText().toString();


                String text = nombre + "-"+apll+"-"+mat+"-"+tlfn+"-"+plaza + "-"+disc;
                String name = "abonados";
                File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS+"/PARKING/");
                File doc = new File(file+"/"+name+".txt");
                if(!file.exists())file.mkdir();
                if(!doc.exists()) {
                    try {
                        doc.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    try {
                        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(doc));
                        os.append(text);
                        os.close();
                        Toast.makeText(getApplicationContext(),"Se ha guardado el abonado",Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }




            }
        });
    }




}
