package com.example.pep.fisioapp.Firebase;

import android.support.annotation.NonNull;

import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Pep on 20/03/2018.
 */

public class FirebaseCalls {


        String getToken() {
            FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
            return mUser.getUid();
        }

        public void pushUser (ObjectPatients p, String dni){
            DatabaseReference mDatabase;
            mDatabase = FirebaseDatabase.getInstance().getReference();

            String token = getToken();
            // x.push().child(token).child(dni).setValue(p);
            mDatabase.child("users").child(token).child(dni).setValue(p);

        }
    }


