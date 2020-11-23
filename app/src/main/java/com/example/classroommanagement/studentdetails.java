package com.example.classroommanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class studentdetails extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView recyclerView;
    private FirestoreRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_studentdetails);

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.studentlistt);

        //Query
        Query query = firebaseFirestore.collection("Admin").document(FirebaseAuth.getInstance().getCurrentUser().getEmail()).collection("Student");

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                Log.d("STUDENTS", value.toString());
            }
        });

        //Recyleroptions
        FirestoreRecyclerOptions<studentmodel> options = new FirestoreRecyclerOptions.Builder<studentmodel>().setQuery(query, studentmodel.class).build();

        //adapter

        adapter = new FirestoreRecyclerAdapter<studentmodel, studentViewHolder>(options)
        {
            @NonNull
            @Override
            public studentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studentlist,parent,false);
                return new studentViewHolder(view);
            }
            @Override
            protected void onBindViewHolder(@NonNull studentViewHolder holder, int position, @NonNull studentmodel model)
            {
                holder.sname.setText(model.getName()); holder.sname.setTextColor(Color.BLACK);
                holder.senroll.setText(model.getEnrollmentNumber()); holder.senroll.setTextColor(Color.BLACK);
                holder.call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                holder.mail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private class studentViewHolder extends RecyclerView.ViewHolder
    {
        TextView sname, senroll;
        ImageButton call, mail;

        public studentViewHolder(@NonNull View itemView)
        {
            super(itemView);
            sname = itemView.findViewById(R.id.sname);
            senroll = itemView.findViewById(R.id.enrollmentnumber);
            call = itemView.findViewById(R.id.call);
            mail = itemView.findViewById(R.id.mail);

        }
//        private void phonecall()  //forphonecall
//        {
//            String Dialer = num.getText().toString();
//            if (ContextCompat.checkSelfPermission(studentdetails.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
//            {
//                ActivityCompat.requestPermissions(studentdetails.this, new String[]{Manifest.permission.CALL_PHONE}, dial);
//            }
//            else
//            {
//                Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Dialer));
//                startActivity(callintent);
//            }
//        }
//
//        public void onRequestPermissionResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults) {
//            super.onRequestPermissionsResult(requestCode, permission, grantResults);
//            if (requestCode == dial)
//            {
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
//                {
//                    phonecall();
//                } else
//                {
//                    Toast.makeText(studentdetails.this, "Permission Denied", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }


//mail
//        Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("message/rfc822");
//                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail"});
//        startActivity(Intent.createChooser(intent, "Choose default Mail App"));
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}