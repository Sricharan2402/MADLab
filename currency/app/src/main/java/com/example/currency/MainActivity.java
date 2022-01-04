package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Spinner isp, osp;
    Map<String, Double> map;
    Button convert;
    EditText input, output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = new HashMap<>();
        map.put("EUR", 1.0);
        map.put("USD", 1.5);
        map.put("YEN", 70.0);
        map.put("INR", 90.0);

        convert = findViewById(R.id.convert);
        isp = findViewById(R.id.iSp);
        osp = findViewById(R.id.oSp);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText(String.valueOf(map.get(osp.getSelectedItem())/map.get(isp.getSelectedItem())*Double.parseDouble(input.getText().toString())));
            }
        });
    }
}