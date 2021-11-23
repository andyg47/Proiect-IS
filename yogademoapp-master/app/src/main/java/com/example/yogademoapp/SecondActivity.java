package com.example.yogademoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        newArray = new int[]{

                R.id.exercice_1_pose, R.id.exersice_2_pose,
                R.id.exersice_3_pose, R.id.exersice_4_pose,
                R.id.exersice_5_pose, R.id.exersice_6_pose,
                R.id.exersice_7_pose, R.id.exersice_8_pose,
                R.id.exersice_9_pose, R.id.exersice_10_pose,
                R.id.exersice_11_pose, R.id.exersice_12_pose,
                R.id.exersice_13_pose, R.id.exersice_14_pose,
        };


    }

    public void Imagebuttonclicked(View view) {

        for (int i = 0; i < newArray.length; i++) {
            if (view.getId() == newArray[i]) {
                int value = i + 1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }


        }
    }
}