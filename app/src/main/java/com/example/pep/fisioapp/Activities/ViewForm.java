package com.example.pep.fisioapp.Activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.pep.fisioapp.Adapter.ElementAdapterForms;
import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;
import com.example.pep.fisioapp.RecyclerClass.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;


public class ViewForm extends AppCompatActivity {
    EditText nom;
    EditText cognoms;
    EditText DNI;
    EditText edat;
    Spinner sexe;
    EditText poblacio;

    EditText alergies;
    EditText farmacs;
    EditText toxics;
    EditText patologies;
    EditText antecedents;

    ObjectPatients patients;
    ObjectForms forms;
    ImageView savebut;
    ImageView editbut;
    Integer positionArray;


    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;


    String identificadordni;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_form);


        positionArray = 0;
        savebut = findViewById(R.id.add);
        editbut = findViewById(R.id.edit);
        nom = findViewById(R.id.Nom);
        cognoms = findViewById(R.id.Cognoms);
        DNI = findViewById(R.id.DNI);
        edat = findViewById(R.id.Edat);
        sexe = findViewById(R.id.Sexe);
        poblacio = findViewById(R.id.poblacio);

        ArrayAdapter<String> adapter;
        List<String> list;
        list = new ArrayList<>();

        list.add("Home");
        list.add("Dona");
        adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexe.setAdapter(adapter);


        alergies = findViewById(R.id.Alergies);
        farmacs = findViewById(R.id.Farmacs);
        toxics = findViewById(R.id.Toxics);
        patologies = findViewById(R.id.Patologies);
        antecedents = findViewById(R.id.Antecedents);


        Intent i = getIntent();
        if (i != null) {
            identificadordni = i.getStringExtra("dni");
            Log.d("id", identificadordni);
        }



        final SglClass instance = SglClass.getInstance();
        final ArrayList<ObjectForms> arrayInstances = instance.getListForms(identificadordni);

        set(instance.getListForms(identificadordni).get(0), instance.getPatientsByID(identificadordni));

        Log.d(" arrayInst  ", "onCreate: " + arrayInstances.size());



        editbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewForm.this, FormPatients.class);
                i.putExtra("dni2", identificadordni.toString());
                i.putExtra("pos", positionArray);
                startActivity(i);
            }
        });
        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("IDENTIFICADORDNIVIEWFOR", "onClick: " + identificadordni.toString());
                Intent i = new Intent(ViewForm.this, FormPatients.class);
                i.putExtra("dni", identificadordni);
                startActivity(i);

            }
        });




        mRecycleView = findViewById(R.id.recycler);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, HORIZONTAL, false);
        mRecycleView.setLayoutManager(mLayoutManager);
        mAdapter = new ElementAdapterForms(arrayInstances,identificadordni);
        mRecycleView.setAdapter(mAdapter);



        mRecycleView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, mRecycleView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        ObjectPatients objPatients = instance.getPatientsByID(identificadordni);
                        ObjectForms objForms = arrayInstances.get(position);
                        Log.d("position", "onItemClick: " + identificadordni);
                        set(objForms, objPatients );
                        positionArray = position;

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        //recycleView


    }
    public void set (ObjectForms f, ObjectPatients p) {

        nom.setText(p.getNom());
        nom.setEnabled(false);
        cognoms.setText(p.getCognoms());
        cognoms.setEnabled(false);
        DNI.setText(p.getDni());
        DNI.setEnabled(false);
        edat.setText(p.getEdat().toString());
        edat.setEnabled(false);

        if (sexe.getSelectedItem().toString().equals("Home")) {
            sexe.setSelection(0, true);
        }
        else if (sexe.getSelectedItem().toString().equals("Dona")) {
            sexe.setSelection(1, true);
        }
        sexe.setEnabled(false);

        poblacio.setText(p.getEdat().toString());
        poblacio.setEnabled(false);

        farmacs.setText(f.getFarmacs());
        farmacs.setEnabled(false);

        alergies.setText(f.getAlergies());
        alergies.setEnabled(false);

        toxics.setText(f.getHabits());
        toxics.setEnabled(false);

        patologies.setText(f.getPatologies());
        patologies.setEnabled(false);

        antecedents.setText(f.getAntecedents());
        antecedents.setEnabled(false);
    }



}
