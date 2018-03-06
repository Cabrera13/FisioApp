package com.example.pep.fisioapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.R;

import java.util.List;

public class ElementAdapter extends ArrayAdapter<ObjectPatients> {
    public int resourceId;


    public ElementAdapter(Context context, int resource, List<ObjectPatients> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ObjectPatients instance = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(this.resourceId, parent, false);
        }

        TextView nom = convertView.findViewById(R.id.textViewNom);
        TextView dni = convertView.findViewById(R.id.textViewdni);

        nom.setText("Nom:   "+instance.getNom());
        dni.setText("Data:   " +instance.getDni());

        return convertView;
    }
}