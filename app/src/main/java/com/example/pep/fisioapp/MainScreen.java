package com.example.pep.fisioapp;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainScreen extends AppCompatActivity {
    TextView hour;
    ImageView iconSdl;
    ImageView iconptt;

    Button btncal;
    Button btnpatients;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        hour = findViewById(R.id.textHour);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        SimpleDateFormat day = new SimpleDateFormat("dddd");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        iconSdl = findViewById(R.id.imageView5);
        iconptt = findViewById(R.id.imageView3);
        iconSdl.bringToFront();
        iconptt.bringToFront();

        btncal = findViewById(R.id.btnSchedule);
        btnpatients = findViewById(R.id.btnPatients);


        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        String daynumber = day.format(d);
        String monthname = month.format(d);
        hour.setText(dayOfTheWeek +","+" "+daynumber+" of " + monthname);

        Log.i("d", dayOfTheWeek);
        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(MainScreen.this, Schedule.class);
                startActivity(i);
                */
                long startMillis = System.currentTimeMillis();

                Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
                builder.appendPath("time");
                ContentUris.appendId(builder, startMillis);
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(builder.build());
                startActivity(intent);
            }

        });
        btnpatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainScreen.this, Patients.class);
                startActivity(i);
            }
        });
    }
}
