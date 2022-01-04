package com.example.p3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView car;
    Button rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        car = findViewById(R.id.car);
        rotate = findViewById(R.id.R);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //car.animate().translationXBy(200).setDuration(1000);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                anim.setDuration(2000);
                car.startAnimation(anim);
            }
        });
    }

}