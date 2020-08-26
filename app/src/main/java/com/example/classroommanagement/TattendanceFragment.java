package com.example.classroommanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TattendanceFragment extends Fragment {

    CardView makerecord,viewrecord,studentdetails;

    public TattendanceFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Attendance");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tattendance, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        makerecord = view.findViewById(R.id.makerecord);
        viewrecord = view.findViewById(R.id.viewrecord);
        studentdetails = view.findViewById(R.id.studentdetails);

        makerecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),markattendance.class));
            }
        });

        viewrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),viewattendance.class));
            }
        });

        studentdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),studentdetails.class));
            }
        });
    }
}