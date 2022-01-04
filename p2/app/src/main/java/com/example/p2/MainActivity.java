package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity {

    Button plus, sub, mul, div, d1, d2, d3, back, clear, equals, b;
    ScriptEngine engine;
    String text;
    TextView input, output;
    Double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         engine = new ScriptEngineManager().getEngineByName("rhino");
         plus = findViewById(R.id.add);
         sub = findViewById(R.id.sub);
         mul = findViewById(R.id.mul);
         div = findViewById(R.id.div);
         d1 = findViewById(R.id.d1);
         d2 = findViewById(R.id.d2);
         d3 = findViewById(R.id.d3);
         back = findViewById(R.id.back);
         clear = findViewById(R.id.clear);
         equals = findViewById(R.id.equal);
         input = findViewById(R.id.input);
         output = findViewById(R.id.output);
         text = "";
    }

    public void handleBackspace(View v){
        text = text.substring(0, text.length()-1);
        input.setText(text);
    }

    public void handleClear(View v){
        text = "";
        input.setText(text);
    }

    public void handleEquals(View v){
        try{
            res = (double)engine.eval(text);

            output.setText(String.valueOf(res));
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            text="";
            input.setText("");
        }

    }

    public void handleClick(View v){
        b = findViewById(v.getId());
        text += b.getText().toString();
        input.setText(text);
    }
}