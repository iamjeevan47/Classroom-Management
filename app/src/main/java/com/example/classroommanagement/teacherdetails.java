package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class teacherdetails extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherdetails);
        recyclerView = findViewById(R.id.teacherlist);

        String[] teachname = {"Jeevan","Ayush","Rishabh","Rahul","Himanshu","Mohit","Manish","Jeevan","Ayush","Rishabh","Rahul","Himanshu","Mohit","Manish"};
        String[] teachdesig= {"Assistant Professor","Professor","Assistant Professor","Professor","Assistant Professor","Professor","Assistant Professor","Professor","Assistant Professor","Professor","Assistant Professor","Professor","Assistant Professor","Professor"};

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new teacheradapter(teachname,teachdesig));
    }
}