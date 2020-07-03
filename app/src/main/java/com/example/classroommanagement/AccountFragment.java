package com.example.classroommanagement;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class AccountFragment extends Fragment {

    public AccountFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {   // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.optstudent, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.timetable)
        {
            Toast.makeText(getActivity(), "timetable", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.security)
        {
            Toast.makeText(getActivity(), "security", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.help)
        {
            Toast.makeText(getActivity(), "help", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
        }
    }