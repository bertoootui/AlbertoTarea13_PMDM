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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        butentrada = findViewById(R.id.butentrada);




        butentrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        final View customlayout = getLayoutInflater().inflate(R.layout.alert_entrada,null);

        builder.setView(customlayout);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText edtmat = customlayout.findViewById(R.id.edtAmat);
                Switch swtdisc = customlayout.findViewById(R.id.swtAdisca);
                Switch swtabon = customlayout.findViewById(R.id.swtAabon);





            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
    }
}
