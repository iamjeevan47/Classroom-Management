package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    public void admin(View login){
        startActivity(new Intent(getApplicationContext(),adminlogin.class));
    }
    public void teacher(View login){
        startActivity(new Intent(getApplicationContext(),teacherlogin.class));
    }
    public void student(View login){
        startActivity(new Intent(getApplicationContext(),studentlogin.class));
    }
}