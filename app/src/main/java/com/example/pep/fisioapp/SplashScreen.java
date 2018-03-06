package com.example.pep.fisioapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        final long DELAY = 3000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent (SplashScreen.this, LoginScreen.class);
                startActivity(intent);
                finish ();
            }
        }, DELAY);
    }
}