package com.example.pep.fisioapp.Activities;

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

import com.example.pep.fisioapp.Firebase.FirebaseCalls;
import com.example.pep.fisioapp.R;

import java.text.ParseException;
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

        FirebaseCalls x = new FirebaseCalls();
        x.getUserInf();
        hour = findViewById(R.id.textHour);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        SimpleDateFormat day = new SimpleDateFormat("d");
        SimpleDateFormat month = new SimpleDateFormat("MM");

        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd");
        String dateInString = "Friday, Jun 7";

        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        iconSdl = findViewById(R.id.imageView5);
        iconptt = findViewById(R.id.imageView3);
        iconSdl.bringToFront();
        iconptt.bringToFront();

        btncal = findViewById(R.id.btnSchedule);
        btnpatients = findViewById(R.id.btnPatients);


        hour.setText(formatter.format(date));

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
