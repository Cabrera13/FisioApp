package com.example.pep.fisioapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ElementAdapter extends ArrayAdapter<ObjectPatients> {
    private final List<ObjectPatients> ok;
    private final List<ObjectPatients> objects;
    public int resourceId;


    public ElementAdapter(Context context, int resource, List<ObjectPatients> objects) {
        super(context, resource, objects);
        this.ok = new ArrayList<>();
        this.ok.addAll(objects);
        this.objects = objects;
        this.resourceId = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ObjectPatients instance = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(this.resourceId, parent, false);
        }

        TextView nom = convertView.findViewById(R.id.textViewNom);
        TextView dni = convertView.findViewById(R.id.textViewdni);

        nom.setText(instance.getNom());
        dni.setText(instance.getDni());

        return convertView;
    }
    // Filter Class
    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());
        this.objects.clear();
        if (charText.length() == 0) {
            this.objects.addAll(ok);
        }
        else
        {
            for (ObjectPatients d : this.ok)
            {
                if (d.getNom().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    this.objects.add(d);
                }
            }
        }
        notifyDataSetChanged();
    }
}