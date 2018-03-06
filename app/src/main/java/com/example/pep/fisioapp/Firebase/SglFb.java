package com.example.pep.fisioapp.Firebase;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.example.pep.fisioapp.LoginScreen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.*;

/**
 * Created by Pep on 05/03/2018.
 */

public class SglFb {
    private static final SglFb ourInstance = new SglFb();
    private ArrayList<ObjectPatients> list;

    public static SglFb getInstance() {
        return ourInstance;
    }

    private SglFb() {
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
