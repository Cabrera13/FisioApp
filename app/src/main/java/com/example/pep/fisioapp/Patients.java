package com.example.pep.fisioapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.pep.fisioapp.Adapter.ElementAdapter;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.SglClass;

import java.util.ArrayList;

public class Patients extends AppCompatActivity {
    Toolbar tool;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);
        ListView list = findViewById(R.id.list);

        final SglClass instance = SglClass.getInstance();
        final ArrayList<ObjectPatients> arrayInstances = instance.getList();

        //elementAdapter
        final ElementAdapter adapter = new ElementAdapter(this, R.layout.arrayadapter, arrayInstances );
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //tool = findViewById(R.id.toolbar);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                view.setSelected(true);


                try {
                    //
                }
                catch (NullPointerException e){
                    //
                }

            }
        });

    }
}
