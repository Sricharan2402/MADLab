package com.example.p9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {

    int D, M, Y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calender = (CalendarView) findViewById(R.id.calendar);
        Button button = findViewById(R.id.button);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                D = dayOfMonth;
                M = month+1;
                Y = year;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                bundle.putString("day", String.valueOf(D));
                bundle.putString("month", String.valueOf(M));
                bundle.putString("year", String.valueOf(Y));
                Intent display = new Intent(MainActivity.this, DisplayActivity.class);
                display.putExtras(bundle);
                startActivity(display);
            }
        });
    }
}