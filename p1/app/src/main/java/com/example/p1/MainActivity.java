package com.example.p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    EditText name;
    CheckBox one, two;
    RadioButton on, tw;
    Spinner spinner;
    String checkbox, radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View v){
        name = findViewById(R.id.name);
        one = findViewById(R.id.checkBox);
        two = findViewById(R.id.checkBox2);
        on = findViewById(R.id.rb1);
        tw = findViewById(R.id.rb2);
        spinner = findViewById(R.id.spinner);



        if(one.isChecked()){
            if(two.isChecked()){
                checkbox = "one, two";
            }
            else{
                checkbox = "one";
            }
        }
        else{
            if(two.isChecked()){
                checkbox = "two";
            }
            else{
                checkbox = "none";
            }
        }

        if(on.isChecked())radio = "one";
        else radio = "two";
        Bundle extras = new Bundle();
        Intent display = new Intent(this, DisplayActivity.class);
        extras.putString("name", name.getText().toString());
        extras.putString("checkbox", checkbox);
        extras.putString("radio", radio);
        extras.putString("spinner", spinner.getSelectedItem().toString());
        display.putExtras(extras);
        startActivity(display);
    }
}