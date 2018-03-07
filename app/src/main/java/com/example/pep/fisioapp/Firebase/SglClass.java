package com.example.pep.fisioapp.Firebase;

import com.example.pep.fisioapp.Classes.ObjectPatients;

import java.util.ArrayList;

/**
 * Created by Pep on 05/03/2018.
 */

public class SglClass {
    private static final SglClass ourInstance = new SglClass();
    private ArrayList<ObjectPatients> list;

    public static SglClass getInstance() {
        return ourInstance;
    }

    private SglClass() {
        this.list = new ArrayList<>();
        ObjectPatients one = new ObjectPatients("47791942n", "josep");
        ObjectPatients two = new ObjectPatients("52241414k", "pep");
        this.list.add(one);
        this.list.add(two);
    }

    public ArrayList<ObjectPatients> getList() {
        return list;
    }

    public void setList(ArrayList<ObjectPatients> list) {
        this.list = list;
    }

}
