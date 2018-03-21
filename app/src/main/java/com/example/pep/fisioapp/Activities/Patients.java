package com.example.pep.fisioapp.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.pep.fisioapp.Adapter.ElementAdapter;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;

import java.util.ArrayList;

public class Patients extends AppCompatActivity {
    Toolbar tool;
    Button add;
    ListView list;
    ElementAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);
        list = findViewById(R.id.list);

        final SglClass instance = SglClass.getInstance();
        final ArrayList<ObjectPatients> arrayInstances = instance.getList();
        add = findViewById(R.id.buttonAdd);

        //elementAdapter
        adapter = new ElementAdapter(this, R.layout.arrayadapter, arrayInstances );
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //tool = findViewById(R.id.toolbar);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                view.setSelected(true);
                try {
                    Intent i = new Intent(Patients.this, ViewForm.class);
                    startActivity(i);
                }
                catch (NullPointerException e){
                    //
                }

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patients.this, FormPatients.class);
                startActivity(i);
            }
        });

    }
}
