package com.example.yogademoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        TextView textView=(TextView)findViewById(R.id.textview);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}