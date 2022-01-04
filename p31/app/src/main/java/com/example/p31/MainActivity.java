package com.example.p31;

import static android.graphics.Bitmap.Config.ARGB_8888;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        bitmap = Bitmap.createBitmap(1920, 1080, ARGB_8888);
        image.setImageBitmap(bitmap);
        canvas = new Canvas(bitmap);
        paint = new Paint();

        paint.setColor(Color.WHITE);
//        canvas.drawRect(10, 10, 100, 100, paint);
        canvas.drawArc(new RectF(10, 10, 100, 100), 0, 180, true, paint);
//        canvas.drawArc();
    }
}