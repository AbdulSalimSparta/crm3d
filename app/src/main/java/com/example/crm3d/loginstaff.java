package com.example.crm3d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginstaff extends AppCompatActivity {

    EditText staffemail,staffpassword;
    Button logstaff;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginstaff);

        staffemail = findViewById(R.id.staffemail);
        staffpassword = findViewById(R.id.passwordstaff);
        logstaff=findViewById(R.id.logstaff);

        mAuth = FirebaseAuth.getInstance();
        logstaff.setOnClickListener(view -> {
            loginUser();
        });
    }

    private void loginUser(){
        String email = staffemail.getText().toString();
        String password = staffpassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            staffemail.setError("Email cannot be empty");
            staffpassword.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            staffemail.setError("Password cannot be empty");
            staffpassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(loginstaff.this, "User loged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginstaff.this,Staff1stpage.class));
                    }
                    else{
                        Toast.makeText(loginstaff.this, "Login error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}