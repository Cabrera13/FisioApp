package com.example.pep.fisioapp.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.FirebaseCalls;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    String vinc = "";
    String id = "";
    String id2 = "";

    ImageView backbuttonj;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

        backbuttonj = findViewById(R.id.backbuttonj);

        backbuttonj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ArrayAdapter<String> adapter;
        List<String> list;
        list = new ArrayList<String>();

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

        guardar = findViewById(R.id.Guardar);

        final Intent i = getIntent();
        id = i.getStringExtra("dni");
        Log.d("IDENTIFICADORFORMS", "onCreate: "+ id);

        final SglClass instance = SglClass.getInstance();

        if (id != null){
            set(instance.getPatientsByID(id));
            vinc = "save";
        }

        id2 = i.getStringExtra("dni2");
        final int pos = i.getIntExtra("pos", -1);
        if (id2 != null && pos != -1) {
            setEdit(instance.getPatientsByID(id2), instance.getPatientsByID(id2).getForms().get(pos));
            vinc = "edit";
        }





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
                    if (Objects.equals(vinc, "")) {
                        patients.setFormsk(forms);
                        instancia.setList(patients);
                        FirebaseCalls x = new FirebaseCalls();
                        x.pushUser(patients, patients.getDni());
                    }
                    else if (Objects.equals(vinc, "save")){
                        ArrayList<ObjectForms> k = instance.getPatientsByID(id).getForms();
                        k.add(forms);
                        patients.setForms(k);
                        FirebaseCalls x = new FirebaseCalls();
                        x.pushForm(instance.getPatientsByID(id).getForms(), patients.getDni());
                    }
                    else if (Objects.equals(vinc, "edit")){
                        ArrayList<ObjectForms> k = instance.getPatientsByID(id2).getForms();
                        k.set(pos, forms);
                        patients.setForms(k);
                        instance.getList().set(instance.getPositionPatientList(id2), patients);
                        FirebaseCalls x = new FirebaseCalls();
                        x.modifyForm(patients, id2);

                    }

                    Intent i = new Intent(FormPatients.this, Patients.class);
                    finish();
                    startActivity(i);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Et falten camps per omplir!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
    public void set (ObjectPatients p) {
        Log.d("setFormP", "set: "+ p.toString());

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
        } else if (sexe.getSelectedItem().toString().equals("Dona")) {
            sexe.setSelection(1, true);
        }
        sexe.setEnabled(false);

        poblacio.setText(p.getPoblacio());
        poblacio.setEnabled(false);
    }
    public void setEdit (ObjectPatients p, ObjectForms f){
        Log.d("set", "setEdit: " + p.toString() + f.toString());
        nom.setText(p.getNom());
        cognoms.setText(p.getCognoms());
        DNI.setText(p.getDni());
        DNI.setEnabled(false);
        edat.setText(p.getEdat().toString());
        if (sexe.getSelectedItem().toString().equals("Home")) {
            sexe.setSelection(0, true);
        }
        else if (sexe.getSelectedItem().toString().equals("Dona")) {
            sexe.setSelection(1, true);
        }
        poblacio.setText(p.getEdat().toString());
        farmacs.setText(f.getFarmacs());
        alergies.setText(f.getAlergies());
        toxics.setText(f.getHabits());
        patologies.setText(f.getPatologies());
        antecedents.setText(f.getAntecedents());
    }
}
