package com.example.albertotarea13_pmdm;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ActivityMenu extends AppCompatActivity {
    Button butcontext, butentrada, butbloq,butbar,butinfo;
    FloatingActionButton butsave, butNback;
    EditText edtmat;
    Switch swtabon ,swtdisc;
    TextView txtmatricula;
    private static boolean disc, abon;
    private static String mat;
    Parking parking = new Parking();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        butentrada = findViewById(R.id.butentrada);
        edtmat = findViewById(R.id.edtRmat);
        swtdisc = findViewById(R.id.swtRdisc);
        swtabon = findViewById(R.id.swtRabon);
        butsave = findViewById(R.id.butNsave);
        butNback = findViewById(R.id.butNback);
        txtmatricula = findViewById(R.id.txtmatricula);
        disc = false;
        abon = false;
        File file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS+"/PARKING/DATA/");
        File docplazas = new File(file2+"/plazas.txt");



        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mat = edtmat.getText().toString();
                if(disc = true) parking.setDispdisc(parking.getDispdisc()-1);
                if(abon = true) parking.setDispabon(parking.getDispabon()-1);
                if(abon == false && disc == false) parking.setDisc(parking.getDisc()-1);
                String mat = edtmat.getText().toString();
                String text = "MATRÍCULA: " + mat +" ABONADO: " + abon + " DISCAPACITADO: "+ disc;
                OutputStreamWriter os = null;
                try {
                    os = new OutputStreamWriter(new FileOutputStream(docplazas));
                    os.append(text);
                    os.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });

        butNback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butsave.setVisibility(View.INVISIBLE);
                butNback.setVisibility(View.INVISIBLE);
                txtmatricula.setVisibility(View.INVISIBLE);
                edtmat.setVisibility(View.INVISIBLE);
                swtabon.setVisibility(View.INVISIBLE);
                swtdisc.setVisibility(View.INVISIBLE);
            }
        });


        butentrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               butsave.setVisibility(View.VISIBLE);
               butNback.setVisibility(View.VISIBLE);
               txtmatricula.setVisibility(View.VISIBLE);
               edtmat.setVisibility(View.VISIBLE);
               swtabon.setVisibility(View.VISIBLE);
               swtdisc.setVisibility(View.VISIBLE);


            }
        });
        swtdisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disc = !disc;
            }
        });
        swtabon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abon = !abon;
            }
        });


    }
}
