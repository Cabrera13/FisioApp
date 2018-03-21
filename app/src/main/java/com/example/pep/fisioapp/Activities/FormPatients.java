package com.example.pep.fisioapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.FirebaseCalls;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;

import java.util.ArrayList;
import java.util.List;

public class FormPatients extends AppCompatActivity {

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
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_form);

        nom = findViewById(R.id.Nom);
        cognoms = findViewById(R.id.Cognoms);
        DNI = findViewById(R.id.DNI);
        edat = findViewById(R.id.Edat);
        sexe = findViewById(R.id.Sexe);
        poblacio = findViewById(R.id.poblacio);

        alergies = findViewById(R.id.Alergies);
        farmacs = findViewById(R.id.Farmacs);
        toxics = findViewById(R.id.Toxics);
        patologies = findViewById(R.id.Patologies);
        antecedents = findViewById(R.id.Antecedents);

        guardar = findViewById(R.id.Guardar);

        ArrayAdapter<String> adapter;
        List<String> list;
        list = new ArrayList<String>();

        list.add("Home");
        list.add("Dona");

        adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexe.setAdapter(adapter);

        final SglClass instancia = SglClass.getInstance();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!alergies.getText().toString().isEmpty() && !farmacs.getText().toString().isEmpty() && !toxics.getText().toString().isEmpty()
                && !patologies.getText().toString().isEmpty() && !antecedents.getText().toString().isEmpty() && !DNI.getText().toString().isEmpty() &&
                !nom.getText().toString().isEmpty() && !cognoms.getText().toString().isEmpty() && !edat.getText().toString().isEmpty() &&
                        !sexe.getSelectedItem().toString().isEmpty() && !poblacio.getText().toString().isEmpty() ) {
                    forms = new ObjectForms(alergies.getText().toString(), farmacs.getText().toString(), toxics.getText().toString(), patologies.getText().toString(),
                            antecedents.getText().toString());
                    patients = new ObjectPatients(DNI.getText().toString(), nom.getText().toString(), cognoms.getText().toString(), Integer.parseInt(edat.getText().toString()),
                            sexe.getSelectedItem().toString(), poblacio.getText().toString(), new ArrayList<ObjectForms>());
                    patients.setForms(forms);
                    instancia.setList(patients);

                   FirebaseCalls x = new FirebaseCalls();
                   x.pushUser(patients, patients.getDni());




                    Intent i = new Intent(FormPatients.this, Patients.class);
                    startActivity(i);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Et falten camps per omplir!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
