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

public class navadmin extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private MyclassFragment myclassFragment;
    private NotesupFragment notesupFragment;
    private AccountadFragment accountadFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navadmin);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        frameLayout = findViewById(R.id.fragmentcontainer);
        myclassFragment = new MyclassFragment();
        notesupFragment = new NotesupFragment();
        accountadFragment = new AccountadFragment();
        Toolbar toolbar = (Toolbar) findViewById(R.id.atoolbar);
        setSupportActionBar(toolbar);
        setFragment(myclassFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.myclass:
                        setFragment(myclassFragment);
                        return true;

                    case R.id.notes:
                        setFragment(notesupFragment);
                        return true;

                    case R.id.account:
                        setFragment(accountadFragment);
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
        inflater.inflate(R.menu.optadmin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.admintimetable:
                Toast.makeText(getApplicationContext(), "Time Table", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),uploadtimetable.class));
                return true;

            case R.id.security:
                Toast.makeText(getApplicationContext(), "Security", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.notifiy:
                Toast.makeText(getApplicationContext(), "Notification", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),changepassword.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}