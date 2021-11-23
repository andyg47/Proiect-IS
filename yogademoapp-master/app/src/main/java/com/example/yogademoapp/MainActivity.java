package com.example.yogademoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    SharedPreferences sharedPreferences;
    public static final String fileName="login";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences=getSharedPreferences(fileName, Context.MODE_PRIVATE);


        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        button1=findViewById(R.id.startyoga1);
        button2=findViewById(R.id.startyoga2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Help_Yoga.class);
                startActivity(intent);
            }
        });




        AlarmHandler alarmHandler=new AlarmHandler(this);
        alarmHandler.cancelAlarmManager();
        alarmHandler.setAlarmManager();

        Toast.makeText(this, "Alarm set!", Toast.LENGTH_SHORT).show();

    }



    public void beforeage18(View view) {
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);

    }

    public void afterage18(View view) {
        Intent intent=new Intent(MainActivity.this, SecondActivity2.class);
        startActivity(intent);

    }

    public void food(View view) {

        Intent intent=new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);


    }

    public void help(View view) {
        Intent intent=new Intent(MainActivity.this,Help_Yoga.class);
        startActivity(intent);
    }
}