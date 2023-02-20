package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnav.fragments.AnalyticsFragment;
import com.example.bottomnav.fragments.HomeFragment;
import com.example.bottomnav.fragments.PaymentsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle actionBarDrawerToggle;
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        replaceFragment(new HomeFragment(),"ffrs");


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int selectedItemId = item.getItemId();
                Fragment fragment;

                if (selectedItemId == R.id.menu_home) {
                    fragment = new HomeFragment();

                } else if (selectedItemId == R.id.menu_analytics) {
                    fragment = new AnalyticsFragment();

                } else {
                    fragment = new PaymentsFragment();

                }
                replaceFragment(fragment, "rffe");
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayoutFragmentContainer, fragment , tag)
                .commit();
    }
}
