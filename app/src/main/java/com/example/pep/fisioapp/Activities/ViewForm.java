package com.example.pep.fisioapp.Activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.pep.fisioapp.Adapter.ElementAdapterForms;
import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;
import com.example.pep.fisioapp.RecyclerClass.RecyclerItemClickListener;
import android.support.v4.app.Fragment;
import com.example.pep.fisioapp.Fragment.FragmentViewBottom;

import java.io.Serializable;
import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

public class ViewForm extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    ObjectForms objectePacient;
    String identificadordni;
    ObjectPatients d;
FragmentViewBottom s;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_form);

        
        Intent i = getIntent();
        if (i != null) {
            identificadordni = i.getStringExtra("dni");
            Log.d("id", identificadordni);
        }



        final SglClass instance = SglClass.getInstance();

        final ArrayList<ObjectForms> arrayInstances = instance.getListForms(identificadordni);

        Log.d(" arrayInst  ", "onCreate: " + arrayInstances.size());



        mRecycleView = findViewById(R.id.recycler);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, HORIZONTAL, false);
        mRecycleView.setLayoutManager(mLayoutManager);
        mAdapter = new ElementAdapterForms(arrayInstances,identificadordni);
        mRecycleView.setAdapter(mAdapter);



        mRecycleView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, mRecycleView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        ObjectForms objectePacient = arrayInstances.get(position);

                        Log.d("objectepacients", objectePacient.toString());
                        /*Bundle obj = new Bundle();
                        if (savedInstanceState != null) {
                           getSupportFragmentManager().beginTransaction().add(R.id.fragment, new sss()).commit();
                        }

                        */
                        //getIntent().putExtra("complexObject", objectePacient);
                        //getIntent().putExtra("complexObject2", instance.getPatientsByID(identificadordni));
                        /*Bundle args = new Bundle();
                        args.putSerializable("obj", objectePacient);
                        args.putSerializable("objP", instance.getPatientsByID(identificadordni));

                        FragmentViewBottom f = new FragmentViewBottom();
                        f.setArguments(args);*/
                        //obj.putSerializable("obj", objectePacient);
                        //obj.putSerializable("objP", instance.getPatientsByID(identificadordni));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        //recycleView


    }
    public ObjectForms getMyData() {
        return objectePacient;
    }
    public ObjectPatients getMyData2(){
        final SglClass instance = SglClass.getInstance();
        d = instance.getPatientsByID(identificadordni);
        return d ;
    }

}
