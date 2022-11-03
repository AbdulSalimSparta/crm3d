package com.example.crm3d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import com.example.crm3d.ui.home.HomeFragment;
import com.example.crm3d.ui.home.HomeViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public Button btnadmin,button2,button3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnadmin= (Button) findViewById(R.id.adminbtn);
        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,mainlogin.class);
                startActivity(intent);
            }
        });


        button2= (Button) findViewById(R.id.manager);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,managerlogin.class);
                startActivity(intent);
            }
        });

        button3= (Button) findViewById(R.id.staff);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,loginstaff.class);
                startActivity(intent);
            }
        });




    }


}