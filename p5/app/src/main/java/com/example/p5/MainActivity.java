package com.example.p5;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    Button start, reset;
    Handler handler = new Handler();
    volatile Boolean run;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        image.setImageBitmap(bitmap);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        start = findViewById(R.id.start);
        reset = findViewById(R.id.reset);
        paint.setTextSize(50);
        canvas.drawColor(Color.RED);
        float x = image.getX(), y = image.getY();
        ObjectAnimator animX = ObjectAnimator.ofFloat(image, "translationX", 100),
                animY = ObjectAnimator.ofFloat(image, "translationY", 100);

        AnimatorSet anim = new AnimatorSet();
        anim.playTogether(animX, animY);
        anim.setDuration(100);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                run = true;

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        if(!run)return;

                        try{
                            image.animate().translationXBy(10).translationYBy(10).setDuration(100);
                        }
                        catch(Exception e){
                            e.printStackTrace();
//                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        finally {
                            handler.postDelayed(this, 100);
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        if(!run)return;

                        try{
                            paint.setColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                            canvas.drawColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                            canvas.drawText("BRO", 50, 50, paint);
                        }
                        catch(Exception e){
                            e.printStackTrace();
//                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        finally {
                            handler.postDelayed(this, 100);
                        }
                    }
                }).start();
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run = false;
                image.setX(x);
                image.setY(y);
            }
        });
    }
}