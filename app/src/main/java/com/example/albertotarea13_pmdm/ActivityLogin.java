package com.example.albertotarea13_pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ActivityLogin extends AppCompatActivity {
    FloatingActionButton butnext;
    Button butregist;
    EditText edtuser, edtpass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        butnext = findViewById(R.id.butnext);
        butregist = findViewById(R.id.butregis);
        edtuser = findViewById(R.id.edtuser);
        edtpass = findViewById(R.id.edtpass);

        butregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(ActivityLogin.this,ActivityRegis.class);
                startActivity(t);
                finish();
            }
        });

        butnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS+"/PARKING/FILES/");
                File docadmin = new File(file+"/"+"admin"+".txt");
                File docworkers = new File(file+"/"+"workers"+".txt");
                String line = "";
                String user = "";
                String pass = "";
                String mode = "";
                int i = 0;
                try {
                    BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(docadmin)));
                    while((line = is.readLine()) != null)
                    {
                        StringTokenizer st = new StringTokenizer(line,"-");
                        while(st.hasMoreTokens()) {
                            switch (i) {
                                case 0:
                                    user = st.nextToken();

                                    break;
                                case 1:
                                    pass = st.nextToken();

                                    break;
                                case 2:
                                    mode = st.nextToken();
                                    break;
                                default:
                                    break;
                            }//end swtich
                        i++;
                        }//end while Tokenizer
                        if(user.equals(edtuser.getText().toString()))
                        {
                            if(pass.equals(edtpass.getText().toString()))
                            {
                                Intent t = new Intent(ActivityLogin.this,ActivityMenu.class);
                                startActivity(t);
                                finish();
                            }
                            else {Toast.makeText(getApplicationContext(),"CONTRASEÑA INCORRECTA",Toast.LENGTH_SHORT).show();break;}


                        }else {Toast.makeText(getApplicationContext(),"USUARIO INCORRECTO",Toast.LENGTH_SHORT).show();break;}
                    }//end while Buffer
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
