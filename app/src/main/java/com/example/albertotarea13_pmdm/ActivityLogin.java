package com.example.albertotarea13_pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityLogin extends AppCompatActivity {
    FloatingActionButton butnext;
    Button butregist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        butnext = findViewById(R.id.butnext);
        butregist = findViewById(R.id.butregis);

        butregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(ActivityLogin.this,ActivityRegis.class);
                startActivity(t);
                finish();
            }
        });
    }
}
