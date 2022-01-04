package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText pno, msg;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pno = findViewById(R.id.pno);
        msg = findViewById(R.id.msg);
        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPermissionGranted()) {
                    SmsManager smsManager = SmsManager.getDefault();

                    try {
                        smsManager.sendTextMessage(pno.getText().toString(), null, msg.getText().toString(), null, null);
                        Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public boolean isPermissionGranted(){
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else{
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
            return false;
        }
    }
}