package com.example.classroommanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class updateteacherprofile extends AppCompatActivity {

    EditText name, email, phone;
    Button update, cancel;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_updateteacherprofile);
        update = findViewById(R.id.updprofile);
        cancel = findViewById(R.id.canl);

        name = findViewById(R.id.teachhname);
        email = findViewById(R.id.teachhemail);
        phone = findViewById(R.id.teachhphone);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Updating Profile");
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        firebaseFirestore.collection("Admin").document("jeevandeepsaini@gmail.com")
                .collection("Professor").document(FirebaseAuth.getInstance().getCurrentUser().getEmail())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>()
        {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot)
            {
                name.setText(documentSnapshot.getString("Name"));
                phone.setText(documentSnapshot.getString("Phone"));
                email.setText(documentSnapshot.getString("Email"));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                hideKeyBoard();
                progressDialog.show();
                final String adminname = name.getText().toString().trim();
                final String adminemail = email.getText().toString().trim();
                final String adminphone = phone.getText().toString().trim();

                if(adminname.isEmpty() || adminemail.isEmpty() || adminphone.isEmpty())
                {
                    progressDialog.dismiss();
                    Toast.makeText(updateteacherprofile.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseFirestore.collection("Admin").document(FirebaseAuth.getInstance().getCurrentUser().getEmail())
                            .update("Name",adminname,"Email",adminemail,"Phone",adminphone)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    progressDialog.dismiss();
                                    if(task.isComplete())
                                    {
                                        Toast.makeText(updateteacherprofile.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(updateteacherprofile.this, "Please try again later", Toast.LENGTH_SHORT).show();
                                    }
//                                    startActivity(new Intent(getApplicationContext(), NavAdminActivity.class));
//                                    finish();
                                    onBackPressed();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            progressDialog.dismiss();
                            Toast.makeText(updateteacherprofile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), navteacher.class));
                finish();
            }
        });
    }
    private void hideKeyBoard() {
        if (getCurrentFocus() != null)
        {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}