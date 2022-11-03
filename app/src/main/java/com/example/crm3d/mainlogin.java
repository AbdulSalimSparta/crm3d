package com.example.crm3d;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mainlogin extends AppCompatActivity {
    EditText rmemail,rmpass;
    Button register,logreg;
    public Button admin,registeradm;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);
        register= findViewById(R.id.registerbutton);
        logreg= findViewById(R.id.loginbutton);
        rmemail=findViewById(R.id.emailAdmin);
        rmpass=findViewById(R.id.passwordAdmin);



        mAuth = FirebaseAuth.getInstance();

        logreg.setOnClickListener(view -> {
            loginUser();
        });
        register.setOnClickListener(view ->{
            startActivity(new Intent(mainlogin.this,Registeradmin.class));
        });
    }

    private void loginUser(){
        String email = rmemail.getText().toString();
        String password = rmpass.getText().toString();

        if (TextUtils.isEmpty(email)){
            rmemail.setError("Email cannot be empty");
            rmemail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            rmpass.setError("Password cannot be empty");
            rmpass.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       Toast.makeText(mainlogin.this, "User loged in successfully", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(mainlogin.this,dashboard.class));
                   }
                   else{
                       Toast.makeText(mainlogin.this, "Login error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }
    }
}