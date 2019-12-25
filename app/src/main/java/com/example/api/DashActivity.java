package com.example.api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.api.Fragment.AddFragment;
import com.example.api.Fragment.DisplayFragment;
import com.example.api.Fragment.SearchFragment;
import com.example.api.Fragment.UpdateFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        loadFragment(new DisplayFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.Home:
                        fragment=new DisplayFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.Add:
                        fragment=new AddFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.Search:
                        fragment=new SearchFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.Update:
                        fragment=new UpdateFragment();
                        loadFragment(fragment);
                        break;
                }
                return true;
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
