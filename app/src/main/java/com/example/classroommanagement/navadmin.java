package com.example.classroommanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

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

        setFragment(myclassFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

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
}