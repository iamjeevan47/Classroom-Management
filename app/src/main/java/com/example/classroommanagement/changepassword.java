package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class changepassword extends AppCompatActivity {
    EditText old,newp,cnewp;
    Button submit;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        old= findViewById(R.id.oldpass);
        newp = findViewById(R.id.newpass);
        cnewp = findViewById(R.id.cnewpass);
        submit = findViewById(R.id.done);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Setting up new password...");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
            }
        });
    }
}