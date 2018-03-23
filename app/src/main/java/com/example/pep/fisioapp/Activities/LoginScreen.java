package com.example.pep.fisioapp.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pep.fisioapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_SHORT;

public class LoginScreen extends AppCompatActivity {
    Button buttonLogin;
    EditText mEditTextEmail;
    EditText mEditTextPassWord;
    String password;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        FirebaseApp.initializeApp(this);



        buttonLogin = findViewById(R.id.buttonLogin);
        mEditTextEmail = (EditText) findViewById(R.id.editMail);
        mEditTextPassWord = (EditText) findViewById(R.id.editText3);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                username = mEditTextEmail.getText().toString();
                password = mEditTextPassWord.getText().toString();
                if (!Objects.equals(username, "") && !Objects.equals(password, "")) {
                    signIn(username, password);
                }

                else {
                    Toast.makeText(LoginScreen.this, "Falten camps per omplir!",
                            LENGTH_SHORT).show();
                }

            }
        });

    }
    public void signIn(String mail, String psw) {
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(mail, psw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override


                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginScreen.this, "Log In successfully",
                                    LENGTH_SHORT).show();
                            Intent i = new Intent(LoginScreen.this, MainScreen.class);
                            finish();
                            startActivity(i);



                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginScreen.this, "Authentication failed.",
                                    LENGTH_SHORT).show();
                        }

                        // ...
                    }

                });
    }
}