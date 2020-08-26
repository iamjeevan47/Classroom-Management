package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class adminsignup extends AppCompatActivity {

    Userdata userdata;
    FirebaseAuth auth;
    FirebaseFirestore fb;
    Button btnca, btntologin;
    ProgressDialog progressDialog;
    EditText adminname,adminemail,adminphone,adminusername,adminpass,admibcpass;
    String name, email, phone, username, password, cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsignup);
        btnca = findViewById(R.id.createaccount);
        btntologin = findViewById(R.id.login1);

        adminname = findViewById(R.id.adminname);
        adminemail = findViewById(R.id.adminemail);
        adminphone = findViewById(R.id.adminphone);
        adminusername = findViewById(R.id.username1);
        adminpass = findViewById(R.id.password1);
        admibcpass = findViewById(R.id.cpassword1);

        auth = FirebaseAuth.getInstance();
        fb = FirebaseFirestore.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Wait a second...");

        btntologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),adminlogin.class));
            }
        });
        
        btnca.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                progressDialog.show();
                name = adminname.getText().toString().trim();
                email = adminemail.getText().toString().trim();
                phone = adminphone.getText().toString().trim();
                username = adminusername.getText().toString().trim();
                password = adminpass.getText().toString().trim();
                cpassword = admibcpass.getText().toString().trim();
                userdata = new Userdata(name, email, phone, username, password, cpassword);

                fb.collection("Admin").document(name).set(userdata).addOnSuccessListener(new OnSuccessListener<Void>()
                {
                    @Override
                    public void onSuccess(Void aVoid)
                    {
                        if (password.equals(cpassword))
                        {
                            auth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(Task<AuthResult> task)
                                {
                                    if(task.isSuccessful())
                                    {
                                        progressDialog.dismiss();
                                        Toast.makeText(adminsignup.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),adminlogin.class));
                                    }
                                    else
                                    {
                                        Toast.makeText(adminsignup.this, "Admin Not Registered", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener(){
                                @Override
                                public void onFailure(Exception e)
                                    {
                                        Toast.makeText(adminsignup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                        }//comparing password
                        else
                        {
                            Toast.makeText(adminsignup.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(Exception e)
                    {
                        Toast.makeText(adminsignup.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                    }
                });

            } //endofonclick
        }); //endofonclicklistener
    } //endofoncreate
}