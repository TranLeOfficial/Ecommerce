package com.example.ecommerceuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.ecommerceuser.Activity.Login;
import com.example.ecommerceuser.Fragment.AlarmFragment;
import com.example.ecommerceuser.Fragment.CategoryFragment;
import com.example.ecommerceuser.Fragment.HomeFragment;
import com.example.ecommerceuser.Fragment.ProfileFragment;
import com.example.ecommerceuser.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Bien
    BottomNavigationView botMenuNavi;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        AnhXa();
        setSupportActionBar(toolbar);
//        Hide or show item
        menu = navigationView.getMenu();
        menu.findItem(R.id.nav_home).setVisible(true);
        menu.findItem(R.id.nav_login).setVisible(true);
        menu.findItem(R.id.nav_alarm).setVisible(true);
        menu.findItem(R.id.nav_cate).setVisible(true);
        menu.findItem(R.id.nav_logout).setVisible(true);
        menu.findItem(R.id.nav_profile).setVisible(true);
        menu.findItem(R.id.nav_search).setVisible(true);

//        --------------------------- NavigationView Drawer Menu--------------------------
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        //navigationView.setCheckedItem(R.id.nav_home);


        //        --------------------------- BottomNavigation Menu--------------------------
        botMenuNavi = findViewById(R.id.bottom_menu);
        botMenuNavi.setOnNavigationItemSelectedListener(botMenuListener);
    }
    //        --------------------------- BottomNavigation Menu--------------------------

    private BottomNavigationView.OnNavigationItemSelectedListener botMenuListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId())
            {
                case R.id.bot_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.bot_cate:
                    selectedFragment = new CategoryFragment();
                    break;
                case R.id.bot_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.bot_alarm:
                    selectedFragment = new AlarmFragment();
                    break;
                case R.id.bot_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_bot_menu, selectedFragment).commit();
            return true;
        }
    };

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void AnhXa() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolBar);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                break;
            case R.id.nav_login:
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
                break;
            case R.id.nav_cate:
                break;
            case R.id.nav_alarm:
                break;
            case R.id.nav_logout:
                break;
            case R.id.nav_profile:
                break;
            case R.id.nav_search:
                break;
            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}