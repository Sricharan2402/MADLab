package com.example.tryanim;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView image;
    Button rotate;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        rotate = findViewById(R.id.rotate);
        bitmap = Bitmap.createBitmap(600, 400, Bitmap.Config.ARGB_8888);
        image.setImageBitmap(bitmap);
        canvas = new Canvas(bitmap);
        paint = new Paint();
//        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.RED);
        canvas.drawRect(100, 170, 500, 300, paint);
        canvas.drawArc(150, 100, 450, 250, 0, -180, true, paint);
        paint.setColor(Color.GRAY);
        canvas.drawArc(150, 250, 250, 350, 0, 360, true, paint);
        canvas.drawArc(350, 250, 450, 350, 0, 360, true, paint);

        Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.startAnimation(anim);
            }
        });
    }
}