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

public class newproduct extends AppCompatActivity {

    EditText productname,productid,price,quantity;
    Button submitbtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newproduct);

        productname = findViewById(R.id.productname);
        productid = findViewById(R.id.productid);
        price = findViewById(R.id.productprice);
        quantity = findViewById(R.id.productquantity);
        submitbtn = findViewById(R.id.submitbutton);

        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://crm3d-247a2-default-rtdb.asia-southeast1.firebasedatabase.app/");

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addproductDetails();

            }
        });
    }

        public void addproductDetails(){
            FirebaseAuth mAuth;

            String Productname = productname.getText().toString();
            String ProductID= productid.getText().toString();
            String Price = price.getText().toString();
            String Quantity = quantity.getText().toString();

            DatabaseReference productDbRef;

            Products product = new Products(Productname,ProductID,Price,Quantity);


            productDbRef= FirebaseDatabase.getInstance("https://crm3d-247a2-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Products/");

            productDbRef.setValue(product);

            Toast.makeText(newproduct.this, "Added", Toast.LENGTH_LONG).show();


    }
}