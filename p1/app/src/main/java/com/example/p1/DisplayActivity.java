package com.example.p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {


    TextView name, checkbox, radio, spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        name = findViewById(R.id.named);
        checkbox = findViewById(R.id.checkd);
        radio = findViewById(R.id.radiod);
        spinner = findViewById(R.id.spinnerd);



        Bundle extras = getIntent().getExtras();
        name.setText(extras.getString("name"));
        checkbox.setText(extras.getString("checkbox"));
        radio.setText(extras.getString("radio"));
        spinner.setText(extras.getString("spinner"));
    }
}