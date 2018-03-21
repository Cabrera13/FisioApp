package com.example.pep.fisioapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.pep.fisioapp.Adapter.ElementAdapterForms;
import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;
import com.example.pep.fisioapp.RecyclerClass.RecyclerItemClickListener;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

public class ViewForm extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_form);

        final SglClass instance = SglClass.getInstance();
        final ArrayList<ObjectForms> arrayInstances = instance.getListForms("47791942n");

        mRecycleView = findViewById(R.id.recycler);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, HORIZONTAL, false);
        mRecycleView.setLayoutManager(mLayoutManager);
        mAdapter = new ElementAdapterForms(arrayInstances,"47791942n");
        mRecycleView.setAdapter(mAdapter);



        mRecycleView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, mRecycleView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        //recycleView


    }

}
