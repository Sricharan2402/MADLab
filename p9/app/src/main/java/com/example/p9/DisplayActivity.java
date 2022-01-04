package com.example.p9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView day = findViewById(R.id.dayH), month = findViewById(R.id.monH), year = findViewById(R.id.yearH);
        Bundle bundle = getIntent().getExtras();
        day.setText(bundle.getString("day"));

        month.setText(bundle.getString("month"));

        year.setText(bundle.getString("year"));
    }
}