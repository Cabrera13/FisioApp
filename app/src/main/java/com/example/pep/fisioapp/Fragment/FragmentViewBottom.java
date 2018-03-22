package com.example.pep.fisioapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pep.fisioapp.Activities.ViewForm;
import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;

import java.io.Serializable;
import java.util.zip.Inflater;


public class FragmentViewBottom extends Fragment {
    SglClass instancia;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instancia = SglClass.getInstance();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment_view_bottom, container, false);

        ViewForm activ = (ViewForm) getActivity();
        ObjectForms d = activ.getMyData();
        ObjectPatients d2 = activ.getMyData2();

        Log.d("d", ""+d2);
        nom = rootView.findViewById(R.id.Nom);
        cognoms = rootView.findViewById(R.id.Cognoms);
        DNI = rootView.findViewById(R.id.DNI);
        edat = rootView.findViewById(R.id.Edat);

//        Log.d(" ", "onCreateView: "+ d.getAlergies());
//        nom.setText(d.toString());



        return inflater.inflate(R.layout.fragment_fragment_view_bottom, container, false);


        // Inflate the layout for this fragment

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        instancia = SglClass.getInstance();








    }
}
