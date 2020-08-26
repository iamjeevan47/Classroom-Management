package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import java.util.Date;


public class markattendance extends AppCompatActivity
{
    String date;
    Button button;
    Spinner spinner;
    TextView textView;
    RecyclerView recyclerView;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markattendance);
        button = findViewById(R.id.submit);
        textView = findViewById(R.id.currentdate);
        spinner = findViewById(R.id.lecturespinner);
        recyclerView = findViewById(R.id.markattendance);

        String[] studentname = {"Jeevan","Ayush","Rishabh","Rahul","Himanshu","Mohit","Manish"};
        String[] enroll= {"01090102018","02090102018","03090102018","04090102018","05090102018","06090102018","07090102018"};

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new markattendanceadapter(studentname, enroll));

        //DateDisplay
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = simpleDateFormat.format(new Date());
        textView.setText(date);
    }

}


