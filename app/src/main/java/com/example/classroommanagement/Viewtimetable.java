package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Viewtimetable extends AppCompatActivity {

    ListView pdflistView;
    DatabaseReference databaseReference;
    List<timetablegettersetter> uploadPDF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtimetable);
        pdflistView = findViewById(R.id.timetablelist);
        uploadPDF = new ArrayList<>();

        viewAllFiles();

        pdflistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                timetablegettersetter tgs = uploadPDF.get(position);

                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(tgs.getUrl()));
                startActivity(intent);
            }
        });
    }

    private void viewAllFiles()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener()
            {
                @Override
                public void onDataChange( DataSnapshot snapshot) {

                    for (DataSnapshot postSnapshot : snapshot.getChildren())
                    {
                        timetablegettersetter timetablegettersetter = postSnapshot.getValue(timetablegettersetter.class);
                        uploadPDF.add(timetablegettersetter);
                    }

                    String[] uploads = new String[uploadPDF.size()];

                    for(int i=0;i<uploads.length;i++)
                    {
                        uploads[i] = uploadPDF.get(i).getName();
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads)
                    {
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent)
                        {
                            View view = super.getView(position, convertView, parent);
                            TextView textView = view.findViewById(android.R.id.text1);
                            textView.setTextColor(Color.BLACK);
                            return view;
                        }
                    };
                    pdflistView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError error) {

                }

            });

    }//viewAllFiles
}