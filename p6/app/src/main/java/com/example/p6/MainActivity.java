package com.example.p6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    FusedLocationProviderClient fusedLocationProviderClient;
    Button getLoc, getName, clear;
    EditText lat, lon, name;
    Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoc = findViewById(R.id.getLoc);
        getName = findViewById(R.id.getName);
        lat = findViewById(R.id.lat);
        lon = findViewById(R.id.lon);
        name = findViewById(R.id.name);
        clear = findViewById(R.id.clear);
        geocoder = new Geocoder(MainActivity.this);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat.setText("");
                lon.setText("");
                name.setText("");
            }
        });

        getLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);

                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    fusedLocationProviderClient.getCurrentLocation(LocationRequest.PRIORITY_HIGH_ACCURACY, null).addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(@NonNull Location location) {
                            try{

                                String latitude = String.valueOf(location.getLatitude()), longitude = String.valueOf(location.getLongitude());
                                lat.setText(latitude);
                                lon.setText(longitude);



                                List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 5);
                                if(!addressList.isEmpty()){
                                    name.setText(addressList.get(0).getLocality());
                                }
                                Double result = new DoubleEvaluator().evaluate("1+2*3+(2+3)-2/4");
                                name.setText(String.valueOf(result));
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else{
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                }
            }
        });

        getName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    List<Address> addressList = geocoder.getFromLocationName(name.getText().toString(), 2);

                    if(!addressList.isEmpty()){
                        lat.setText(String.valueOf(addressList.get(0).getLatitude()));
                        lon.setText(String.valueOf(addressList.get(0).getLongitude()));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


    }
}