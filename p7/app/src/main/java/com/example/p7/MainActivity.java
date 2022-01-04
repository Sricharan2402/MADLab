package com.example.p7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    EditText text, name;
    Button read, write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.input);
        read = findViewById(R.id.read);
        write = findViewById(R.id.write);
        name = findViewById(R.id.name);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    File f = new File(getFilesDir(), name.getText().toString());
                    try{
                        FileOutputStream fout = new FileOutputStream(f);
                        fout.write(text.getText().toString().getBytes(StandardCharsets.UTF_8));
                        fout.close();
                        name.setText("");
                        text.setText("");
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    File f = new File(getFilesDir(), name.getText().toString());
                    try{
                        Scanner s = new Scanner(f);
                        s.useDelimiter("\\z");
                        text.setText(s.nextLine());
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                }
            }
        });
    }
}