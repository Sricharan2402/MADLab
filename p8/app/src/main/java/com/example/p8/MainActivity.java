package com.example.p8;

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


    EditText num,msg;
    Button send;
    SmsManager smsManager;
    Integer counter;
    String prevNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.num);
        msg = findViewById(R.id.msg);
        send = findViewById(R.id.send);
        smsManager = SmsManager.getDefault();
        counter = 0;
        prevNumber = "";
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){

                    try{
                        if(prevNumber.equalsIgnoreCase(num.getText().toString())){
                            counter++;
                            if(counter > 2){
                                MainActivity.this.finish();
                                System.exit(0);
                            }
                        }
                        else{
                            counter=1;
                            prevNumber = num.getText().toString();
                        }
                        smsManager.sendTextMessage(num.getText().toString(), null, msg.getText().toString(), null, null);
                        Toast.makeText(MainActivity.this, "Sent", Toast.LENGTH_SHORT).show();
                        msg.setText("");
                    }catch(Exception e){
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
                }
            }
        });
    }
}