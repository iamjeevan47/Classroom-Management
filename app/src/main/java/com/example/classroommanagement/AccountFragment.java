package com.example.classroommanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AccountFragment extends Fragment {

    TextView name,email,phone,enrollment,course;
    FirebaseFirestore fb;
    FirebaseAuth auth;
    Button logout;
    String userId;

    public AccountFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Account");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        name = view.findViewById(R.id.studname);
        email = view.findViewById(R.id.studmail);
        phone = view.findViewById(R.id.studphone);
        enrollment = view.findViewById(R.id.enrollmentnumberr);
        course = view.findViewById(R.id.coursee);

        logout = view.findViewById(R.id.logout);
        fb = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        userId = auth.getCurrentUser().getUid();

        DocumentReference documentReference = fb.collection("Admin").document("jeevandeepsaini@gmail.com")
                .collection("Student").document(getActivity().getIntent().getStringExtra("studentemail").toString());
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot)
            {
                if(documentSnapshot.exists())
                {
                    enrollment.setText(documentSnapshot.getString("EnrollmentNumber"));
                    course.setText(documentSnapshot.getString("Course"));
                    name.setText(documentSnapshot.getString("Name"));
                    email.setText(documentSnapshot.getString("Email"));
                    phone.setText(documentSnapshot.getString("Phone"));
                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Data not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), AdminLoginActivity.class));
                getActivity().finish();
            }
        });
    }
}
