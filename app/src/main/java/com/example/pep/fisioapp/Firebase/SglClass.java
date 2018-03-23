package com.example.pep.fisioapp.Firebase;

import android.database.DatabaseUtils;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.pep.fisioapp.Activities.FormPatients;
import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.google.firebase.database.DatabaseReference;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by Pep on 05/03/2018.
 */

public class SglClass {
    private static final SglClass ourInstance = new SglClass();
    private ArrayList<ObjectForms> listForms;
    private ArrayList<ObjectPatients> list;

    public static SglClass getInstance() {
        return ourInstance;
    }

    private SglClass() {
        this.list = new ArrayList<>();
        this.listForms = new ArrayList<>();
/*
        ObjectPatients one = new ObjectPatients("47791942n", "josep", "sanchez", 12, "home", "Manlleu", new ArrayList<ObjectForms>());
        ObjectPatients two = new ObjectPatients("52241414k", "pep", "sanchez", 12, "home", "Manlleu", new ArrayList<ObjectForms>());
        one.setFormsk(new ObjectForms("dwadp1.1", "dadw", "2wdaa", "dwadaw", "djwad"));
        one.setFormsk(new ObjectForms("dwadp1.2", "dadw", "2wdaa", "dwadaw", "djwad"));

        two.setFormsk(new ObjectForms("dwadp2", "dadw", "2wdaa", "dwadaw", "djwad2"));
*/


    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void objectRefreshInstance(ObjectPatients d) {
        Log.d("lllp", "objectRefreshdInstance: " +d.getDni() );
        if (!this.list.contains(d)) {
            this.list.add(d);
            Collections.sort(this.list, new CustomComparator());
        }
    }

    public ArrayList<ObjectPatients> getList() {
        return list;
    }

    public int getPositionPatientList (String dni) {
        int pos = 0;
        for (int x = 0; x < this.list.size(); x++){
            if (this.list.get(x).getDni().equals(dni)){
                pos = x;
            }
        }
        return pos;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ArrayList<ObjectForms> getListForms(String id) {
        this.listForms.clear();
        Log.d("id k arriba es ok", "getListForms: " + id);
        Log.d("dvsvrga", "getListForms: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            Log.d("dvsvrga", "getListForms: " + id + "/" + list.get(i).getDni());
            if (Objects.equals(id, this.list.get(i).getDni())) {
                Log.d("entrat", "getListForms: "+this.list.get(i).getForms().size());

                for (int x = 0; x < this.list.get(i).getForms().size(); x++) {
                    Log.d("entrat!", "getListForms: " + this.list.get(i).getForms().size());
                    this.listForms.add(this.list.get(i).getForms().get(x));
                }
            }
        }
        Log.d("SIZE", "getListForms: " + listForms.size());
        return this.listForms;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ObjectPatients getPatientsByID (String id) {
        ObjectPatients p = null;
        for (int i = 0; i < list.size(); i++){
            if (Objects.equals(this.list.get(i).getDni(), id)) {
                p = this.list.get(i);
            }
        }
        return p;
    }
    /*
    public ObjectForms getObjectForms (String id, int position) {
        Log.d("id", "" + id);
        Log.d("position", "" + position);
        ArrayList<ObjectForms> x = getListForms(id);
        Log.d("object", ""+x);
        return x.get(position);
    }
*/

    public class CustomComparator implements Comparator<ObjectPatients> {
        @Override
        public int compare(ObjectPatients o1, ObjectPatients o2) {
            return o1.getNom().compareTo(o2.getNom());
        }
    }

    public void setList(ObjectPatients p) {
        if (!this.list.contains(p)){this.list.add(p);
            Collections.sort(this.list, new CustomComparator());
        }
    }
    }
