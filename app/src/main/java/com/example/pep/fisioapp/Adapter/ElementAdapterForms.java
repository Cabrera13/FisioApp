package com.example.pep.fisioapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.Firebase.SglClass;
import com.example.pep.fisioapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ElementAdapterForms extends RecyclerView.Adapter<ElementAdapterForms.ViewHolder> {
    private final ArrayList<ObjectForms> arrayInstancies;
    private final String id;

    public ElementAdapterForms(ArrayList<ObjectForms> arrayInstances, String id) {
        this.arrayInstancies = arrayInstances;
        this.id = id;
    }

    @NonNull
    @Override
    public ElementAdapterForms.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.data.setText(arrayInstancies.get(position).getAlergies());
    }


    @Override
    public int getItemCount() {
        final SglClass instance = SglClass.getInstance();
        final ArrayList<ObjectForms> arrayInstances = instance.getListForms(id);
        Log.d("m", ""+ arrayInstances.size());
        return arrayInstances.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView data;

        public ViewHolder(View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.data);
        }

    }


}