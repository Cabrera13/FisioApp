package com.example.pep.fisioapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;
import com.example.pep.fisioapp.Adapter.ElementAdapter;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class Patients extends AppCompatActivity {
    Toolbar tool;
    Button add;
    ListView list;
    ElementAdapter adapter;
    ImageView srch;
    ImageView bkbtn;
    TextView textttlforms;
    EditText editsearch;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        list = findViewById(R.id.list);
        editsearch = findViewById(R.id.edittextsearch);
        textttlforms = findViewById(R.id.texttitleforms);

        editsearch.setVisibility(View.GONE);
        srch = findViewById(R.id.searchfind);

        bkbtn = findViewById(R.id.backbutton);
        bkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editsearch.setText("");
               finish();
            }
        });

        srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textttlforms.setVisibility(View.GONE);
                editsearch.setVisibility(View.VISIBLE);
                editsearch.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editsearch, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        final SglClass instance = SglClass.getInstance();
        final ArrayList<ObjectPatients> arrayInstances = instance.getList();
        add = findViewById(R.id.buttonAdd);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);*/

        //elementAdapter
        adapter = new ElementAdapter(this, R.layout.arrayadapter, arrayInstances );
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                view.setSelected(true);
                try {

                    Intent i = new Intent(Patients.this, ViewForm.class);
                    Log.d("kkkkk", "onItemClick: "+ instance.getList().get(position).getDni());
                    i.putExtra("dni", instance.getList().get(position).getDni());
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

    @Override
    protected void onResume() {
        super.onResume();
        editsearch.setText("");
        textttlforms.setVisibility(View.VISIBLE);
        editsearch.setVisibility(View.GONE);
    }

}
