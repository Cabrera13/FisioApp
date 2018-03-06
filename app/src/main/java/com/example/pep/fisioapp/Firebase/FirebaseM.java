package com.example.pep.fisioapp.Firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import static android.content.ContentValues.TAG;

/**
 * Created by Pep on 05/03/2018.
 */

class FirebaseM {
    private static final FirebaseM ourInstance = new FirebaseM();
    private FirebaseAuth mAuth;
    static FirebaseM getInstance() {
        return ourInstance;
    }

    private FirebaseM() {
    }

}
