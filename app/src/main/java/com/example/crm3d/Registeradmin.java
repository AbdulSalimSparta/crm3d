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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registeradmin extends AppCompatActivity {
    EditText remail,rpass,namee;
    Button register,logreg;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeradmin);
        register= findViewById(R.id.registerbtn);
        logreg= findViewById(R.id.logregbtn);
        remail=findViewById(R.id.remail);
        rpass=findViewById(R.id.rpass);
        namee= findViewById(R.id.Adminname);

        mAuth = FirebaseAuth.getInstance();



        FirebaseDatabase database = FirebaseDatabase.getInstance("https://crm3d-247a2-default-rtdb.asia-southeast1.firebasedatabase.app/");

        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(view->{
            createUser();
        });

        logreg.setOnClickListener(viev ->{
            startActivity(new Intent(Registeradmin.this,mainlogin.class));
        });

    }

    public void createUser(){

        FirebaseAuth mAuth;

        String name = namee.getText().toString();
        String email = remail.getText().toString();
        String password =rpass.getText().toString();
        mAuth = FirebaseAuth.getInstance();

        if (TextUtils.isEmpty(email)){
            remail.setError("E-mail cannot be Empty");
            remail.requestFocus();
        } else if(TextUtils.isEmpty(password)){
            rpass.setError("Password cannot be Empty");
            rpass.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){


                        String userId = task.getResult().getUser().getUid();
                        DatabaseReference staffDbRef;

                        Admin admin = new Admin(name,email);

                        staffDbRef= FirebaseDatabase.getInstance("https://crm3d-247a2-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Admin/"+userId);

                        staffDbRef.setValue(admin);

                        Toast.makeText(Registeradmin.this, "User register successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Registeradmin.this,mainlogin.class));
                    }
                    else{
                        Toast.makeText(Registeradmin.this, "Registration error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

}