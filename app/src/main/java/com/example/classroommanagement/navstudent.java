package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class navstudent extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private AttendanceFragment attendanceFragment;
    private NotesFragment notesFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navstudent);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        frameLayout = findViewById(R.id.fragmentcontainer);
        attendanceFragment = new AttendanceFragment();
        notesFragment = new NotesFragment();
        accountFragment = new AccountFragment();
        Toolbar toolbar = (Toolbar) findViewById(R.id.stoolbar);
        setSupportActionBar(toolbar);
        setFragment(attendanceFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.attendance:
                        setFragment(attendanceFragment);
                        return true;

                    case R.id.notes:
                        setFragment(notesFragment);
                        return true;

                    case R.id.account:
                        setFragment(accountFragment);
                        return true;

                    default: return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentcontainer,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optstudent, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.timetable:
                Toast.makeText(getApplicationContext(), "Time Table", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Viewtimetable.class));
                return true;

            case R.id.security:
                Toast.makeText(getApplicationContext(), "Security", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.help:
                Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),changepassword.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}