package com.example.pep.fisioapp.Firebase;

import android.util.Log;

import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;

import java.util.ArrayList;

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

        ObjectPatients one = new ObjectPatients("47791942n", "josep", "sanchez", 12, "home", "Manlleu", new ArrayList<ObjectForms>());
        ObjectPatients two = new ObjectPatients("52241414k", "pep", "sanchez", 12, "home", "Manlleu", new ArrayList<ObjectForms>());
        one.setForms(new ObjectForms("dwadp1.1", "dadw", "2wdaa", "dwadaw", "djwad"));
        one.setForms(new ObjectForms("dwadp1.2", "dadw", "2wdaa", "dwadaw", "djwad"));

        two.setForms(new ObjectForms("dwadp2", "dadw", "2wdaa", "dwadaw", "djwad2"));

        this.list.add(one);
        this.list.add(two);


    }

    public ArrayList<ObjectPatients> getList() {
        return list;
    }

    public ArrayList<ObjectForms> getListForms(String id) {
        this.listForms.clear();
        for (int i = 0; i < list.size(); i++) {
            if (this.list.get(i).getDni() == id) {
                for (int x = 0; x < list.get(i).getForms().size(); x++) {
                    this.listForms.add((ObjectForms) list.get(i).getForms().get(x));
                }
            }
        }
        return listForms;
    }


    public void setList(ObjectPatients p) {
        this.list.add(p);
    }

    }
