package com.example.albertotarea13_pmdm;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityMenu extends AppCompatActivity {
    Button butcontext, butentrada, butbloq,butbar,butinfo;
    EditText edtmat;
    Switch swtabon ,swtdisc;
    private static boolean disc, abon;
    private static String mat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        butentrada = findViewById(R.id.butentrada);
        edtmat = findViewById(R.id.edtRmat);
        swtdisc = findViewById(R.id.swtRdisc);
        swtabon = findViewById(R.id.swtRabon);
        disc = false;
        abon = false;


        butentrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mat = edtmat.getText().toString();



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
