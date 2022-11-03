package com.example.crm3d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addstaff extends AppCompatActivity {

    EditText names,emails,phones,dobs,qualifications,addresss,passwords;
    Button submitbtn;
    FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstaff);

        names= findViewById(R.id.name);
        emails= findViewById(R.id.email);
        phones= findViewById(R.id.phone);
        dobs= findViewById(R.id.dob);
        qualifications= findViewById(R.id.qualification);
        addresss= findViewById(R.id.address);
        submitbtn= findViewById(R.id.submit);
        passwords=findViewById(R.id.passwordstaff);

        mAuth = FirebaseAuth.getInstance();



        FirebaseDatabase database = FirebaseDatabase.getInstance("https://crm3d-247a2-default-rtdb.asia-southeast1.firebasedatabase.app/");

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertStafftData();

            }
        });


    }
    public void insertStafftData(){
        FirebaseAuth mAuth;

        String name = names.getText().toString();
        String email = emails.getText().toString();
        String password = passwords.getText().toString();
        String phone = phones.getText().toString();
        String dob = dobs.getText().toString();
        String qualification = qualifications.getText().toString();
        String address = addresss.getText().toString();
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            String userId = task.getResult().getUser().getUid();
                            DatabaseReference staffDbRef;

                            Staff staffs = new Staff(name,email,phone,dob,qualification,address);


                            staffDbRef= FirebaseDatabase.getInstance("https://crm3d-247a2-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("staff/"+userId);

                            staffDbRef.setValue(staffs);

                            Toast.makeText(addstaff.this, "Added", Toast.LENGTH_LONG).show();
                        }
                        else {

                            Toast.makeText(addstaff.this, "Failed", Toast.LENGTH_LONG).show();
                        }
                    }

       });
        }



}