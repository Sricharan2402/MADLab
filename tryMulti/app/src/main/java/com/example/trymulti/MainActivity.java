package com.example.trymulti;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView image;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    Button start, stop, reset;
    float X, Y;
    volatile Boolean running = false;
    Handler hand;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);

        bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        image.setImageBitmap(bitmap);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setTextSize(50);
        X = image.getX();
        Y = image.getY();
        hand = new Handler();
        rand = new Random();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(!running)return;

                        try{
                            image.animate().translationYBy(10f).translationXBy(10f).setDuration(100);
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            hand.postDelayed(this, 100);
                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(!running)return;

                        try{
                            paint.setColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                            canvas.drawColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                            canvas.drawText("BANNER", 5, 100, paint);
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        finally{
                            hand.postDelayed(this, 100);
                        }
                    }
                }).start();
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setX(X);
                image.setY(Y);
            }
        });

    }
}