package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class adminsignup extends AppCompatActivity {
    
    Button btnca, btntologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsignup);
        btnca = findViewById(R.id.createaccount);
        btntologin = findViewById(R.id.login1);
        
        btnca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),adminlogin.class));
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        });

        btntologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),adminlogin.class));
                Toast.makeText(getApplicationContext(), "Welcome to Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}