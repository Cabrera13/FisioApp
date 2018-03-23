package com.example.pep.fisioapp.Firebase;

import android.os.Build;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.pep.fisioapp.Activities.FormPatients;
import com.example.pep.fisioapp.Classes.ObjectForms;
import com.example.pep.fisioapp.Classes.ObjectPatients;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Pep on 20/03/2018.
 */

public class FirebaseCalls {

        final SglClass instance = SglClass.getInstance();

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
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public void pushForm (ArrayList<ObjectForms> p, String dni) {
            DatabaseReference mDatabase;
            mDatabase = FirebaseDatabase.getInstance().getReference();
            String token = getToken();
            instance.getPatientsByID(dni).getForms();
            mDatabase.child("users").child(token).child(dni).child("forms").setValue(p);
        }
        public void modifyForm(ObjectPatients p, String dni) {
            DatabaseReference mDatabase;
            mDatabase = FirebaseDatabase.getInstance().getReference();
            String token = getToken();
            mDatabase.child("users").child(token).child(dni).setValue(p);
        }

    public void getUserInf () {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener postListener = new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                // ...
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    ObjectPatients post = postSnapshot.getValue(ObjectPatients.class);

                    instance.objectRefreshInstance(post);
                    Log.e("Get Data", post.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.child("users").child(getToken()).addListenerForSingleValueEvent(postListener);
    }
}


