package com.example.appclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.appclient.databinding.ActivityMain2Binding;
import com.example.appclient.fragment.AccountFragment;
import com.example.appclient.fragment.GalleryFragment;
import com.example.appclient.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {
    ActivityMain2Binding binding;
    private TextView drawer_profile_name, drawer_profile_standName;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId())
                    {
                        case R.id.nav_home:
                            addFragment(new HomeFragment());
                            return true;
                        case R.id.nav_leaderboard:
                            addFragment(new GalleryFragment());
                            return true;
                        case R.id.nav_account:
                            addFragment(new AccountFragment());
                            return true;
                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.contentMain.bottomNv.setOnNavigationItemSelectedListener(
                onNavigationItemSelectedListener
        );

        DrawerLayout drawer = binding.drawerLayout;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                binding.appBarMain.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close );
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        drawer_profile_name = navigationView.getHeaderView(0).findViewById(R.id.nav_drawer_tvName);
        drawer_profile_standName = navigationView.getHeaderView(0).findViewById(R.id.nav_drawer_standName);
        String name = "test";
        drawer_profile_name.setText(name);
        drawer_profile_standName.setText(name.toUpperCase().substring(0,1));
        addFragment(new HomeFragment());
    }
    public void onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_home){
            addFragment(new HomeFragment());

        } else if (id == R.id.nav_account) {
            addFragment(new AccountFragment());

        } else if (id == R.id.nav_leaderboard) {
            addFragment(new GalleryFragment());

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
    private void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.appBarMain.contentMain.mainFrame.getId(),fragment);
        transaction.commit();
    }
}