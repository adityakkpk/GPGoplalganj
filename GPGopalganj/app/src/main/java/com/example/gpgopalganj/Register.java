package com.example.gpgopalganj;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.Attributes;

public class Register extends AppCompatActivity {

    EditText Name,Branch,Email,Password;
//    TextView textView,textView2;
    Button submit,login;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    boolean passwordVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name = findViewById(R.id.name);
        Branch = findViewById(R.id.branch);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        submit = findViewById(R.id.button);
        login = findViewById(R.id.button2);
        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar);

//        Password Visibility

//        Password.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                final int Right = 2;
//                if (event.getAction()==MotionEvent.ACTION_UP){
//                    if (event.getRawX()>=Password.getRight()-Password.getCompoundDrawables()[Right].getBounds().width()){
//                        int selection=Password.getSelectionEnd();
//                        if (passwordVisible){
//                            //set Drawable image
//                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility_off,0);
//                            //for hiding image
//                            Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                            passwordVisible=false;
//                        }else {
//                            //set Drawable image
//                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility,0);
//                            //for showing image
//                            Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                            passwordVisible=true;
//                        }
//                        Password.setSelection(selection);
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });

        if (firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), dashboard.class));
            finish();
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString().trim();
                String branch = Branch.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    Name.setError("please enter your Name.");
                    return;
                }
                if (TextUtils.isEmpty(branch)) {
                    Branch.setError("please enter your Branch.");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Email.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Password.setError("Password is Required.");
                    return;
                }

                if(password.length()<6){
                    Password.setError("Password must be greater than 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            //Email Verification
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(Register.this, "Verification Email has been sent.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Register.this, "", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "onFailure: Email not sent"+e.getMessage());
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                }
                            });




                            Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), dashboard.class));
                            finish();
                        }else {
                            Toast.makeText(Register.this, "Error ! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);

                        }
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });

    }

}