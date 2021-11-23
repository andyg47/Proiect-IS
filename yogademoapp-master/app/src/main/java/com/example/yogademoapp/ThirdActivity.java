package com.example.yogademoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    String buttonvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent=getIntent();
        buttonvalue =intent.getStringExtra("value");


        int intvalue=Integer.valueOf(buttonvalue);


        switch (intvalue){
            case 1:
                setContentView(R.layout.activity_exercice_1);
                break;
            case 2:
                setContentView(R.layout.activity_exercice_2);
                break;
            case 3:
                setContentView(R.layout.activity_exercice_3);
                break;
            case 4:
                setContentView(R.layout.activity_exercice_4);
                break;
            case 5:
                setContentView(R.layout.activity_exercice_5);
                break;
            case 6:
                setContentView(R.layout.activity_exercice_6);
                break;
            case 7:
                setContentView(R.layout.activity_exercice_7);
                break;
            case 8:
                setContentView(R.layout.activity_exercice_8);
                break;
            case 9:
                setContentView(R.layout.activity_exercice_9);
                break;
            case 10:
                setContentView(R.layout.activity_exercice_10);
                break;
            case 11:
                setContentView(R.layout.activity_exercice_11);
                break;
            case 12:
                setContentView(R.layout.activity_exercice_12);
                break;
            case 13:
                setContentView(R.layout.activity_exercice_13);
                break;
            case 14:
                setContentView(R.layout.activity_exercice_14);
                break;
            case 15:
                setContentView(R.layout.activity_exercice_15);
                break;
        }

    }
}