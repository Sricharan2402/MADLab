package com.example.mtg;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView canvas;
    Button btn, btn2;
    Handler hand = new Handler();
    Paint paint;
    Canvas can;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        canvas = findViewById(R.id.canvas);
        Bitmap bitmap = Bitmap.createBitmap(1080, 1000, Bitmap.Config.ARGB_8888);
        canvas.setImageBitmap(bitmap);
        paint = new Paint();
        can = new Canvas(bitmap);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runnable.run();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            canvas.animate().translationXBy(300).setDuration(600);
                        }
                        catch(Exception e){
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }).start();
            }
        });

//        bn.setOnClickListener(v ->{
//
//        });

//        bn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                runnable.run();
//            }
//        });

//        btn.setOnClickListener(v ->{
//            runnable.run();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    ObjectAnimator anim = ObjectAnimator.ofFloat(canvas, "translationX", 1000);
//                    anim.setDuration(2000);
//                    anim.addListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            super.onAnimationEnd(animation);
//                            anim.start();
//                        }
//                    });
//                    anim.start();
//                }
//            }).start();
//            Log.d("bro", "what the fuck");
//            runnable.run();
//        });

    }
//
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try{
                Random rand =  new Random();
                int intcolor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                paint.setColor(intcolor);
                paint.setTextSize(50);
                can.drawText("TEXT", 50, 50, paint);
                Log.e("color", String.valueOf(intcolor));
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                hand.postDelayed(this, 100);
            }
        }
    };
}