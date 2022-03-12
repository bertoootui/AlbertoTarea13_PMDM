package com.example.albertotarea13_pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkpermissions();
        createstarterfiles();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                    Intent t = new Intent(MainActivity.this,ActivityLogin.class);
                    startActivity(t);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    private void createstarterfiles() {
        String name = "admin";
        String name2 = "workers";
        String text = "admin-root-admin";
        String text2 = "worker1-1234-worker";
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS+"/PARKING/FILES/");
        File docadmin = new File(file+"/"+name+".txt");
        File docworkers = new File(file+"/"+name2+".txt");
        if(!file.exists())file.mkdir();
        if(!docadmin.exists()) {
            try {
                docadmin.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
        {

            try {
                OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(docadmin));
                os.append(text);
                os.close();
                Toast.makeText(getApplicationContext(),"Se ha guardado el admin por defecto",Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!docworkers.exists()) {
            try {
                docworkers.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
        {

            try {
                OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(docworkers));
                os.append(text2);
                os.close();
                Toast.makeText(getApplicationContext(),"Se ha guardado el trabajador por defecto",Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkpermissions() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},101);
                }
            });
            t.start();
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
                }
            });
            t2.start();
        }
    }//end checkpermissions
}