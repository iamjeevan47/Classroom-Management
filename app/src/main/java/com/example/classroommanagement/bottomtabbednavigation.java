package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class bottomtabbednavigation extends AppCompatActivity {
    SpaceNavigationView spaceNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomtabbednavigation);

        spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("T", R.drawable.timetable));
        spaceNavigationView.addSpaceItem(new SpaceItem("S", R.drawable.study));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                startActivity(new Intent(getApplicationContext(),profile.class));

            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(bottomtabbednavigation.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(bottomtabbednavigation.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}