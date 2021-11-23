package com.example.yogademoapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Splashscreenok extends AppCompatActivity {


    EditText etUsername,etPassword;
    Button btnLogin;
    CheckBox cbShowPassword;


    SharedPreferences sharedPreferences;

    private String userName="admin";
    private String password="12344";

    public static final String fileName="login";
    public static final String Username="username";
    public static final String Password="password";




    Animation up,down;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreenok);

        ImageView imageView=findViewById(R.id.appsplash);
        up=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up);
        imageView.setAnimation(up);


        TextView textView=findViewById(R.id.appname);
        down=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },3500);












        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);

        btnLogin=findViewById(R.id.btnLogin);

        cbShowPassword=findViewById(R.id.cbShowPassword);

        sharedPreferences=getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Username)&&sharedPreferences.contains(Password)){
            Intent i=new Intent(Splashscreenok.this,Help_Yoga.class);
            startActivity(i);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();

                if(username.equals(userName) && password.equals(password)){
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString(Username, username);
                    editor.putString(Password, password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Successfully Login", Toast.LENGTH_SHORT).show();

                    Intent i=new Intent(Splashscreenok.this,MainActivity.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid User Details", Toast.LENGTH_LONG).show();
                    etUsername.setText("");
                    etUsername.requestFocus();
                    etPassword.setText("");

                }
            }
        });

        cbShowPassword.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if(!isChecked){
                etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            else{
                etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        }));

    }







}