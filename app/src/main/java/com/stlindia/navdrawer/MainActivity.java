package com.stlindia.navdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavController navController;
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Navigation Control Object Which accepts two argument activity and ID OF Host Fragment
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.blankFragment1);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //Create Up Button In action bar
        // NavigationUI.setupActionBarWithNavController(this,navController,drawer);

        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            navController.navigate(R.id.blankFragment);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //gets the Current destination of navController
        int current = navController.getCurrentDestination().getId();

        if (id == R.id.nav_camera) {
            // Handle the camera action

            //Navigation controller controls the navigation From Home Fragment to Destination Fragment
            //And also checks if the current destination is selected then it will not add to its stack
            if (R.id.fragmentImport != current) {
                navController.navigate(R.id.fragmentImport);
            }


        } else if (id == R.id.nav_gallery) {

            // navController.navigate(R.id.action_fragmentImport_to_fragmentGallery);
            //It does the Same as above code
            if (R.id.fragmentGallery != current) {
                navController.navigate(R.id.fragmentGallery);
            }


        } else if (id == R.id.nav_slideshow) {

            //navController.navigate(R.id.action_fragmentGallery_to_fragmentSlideShow);
            if (R.id.fragmentSlideShow != current) {
                navController.navigate(R.id.fragmentSlideShow);
            }

        } else if (id == R.id.nav_manage) {

            //navController.navigate(R.id.action_fragmentSlideShow_to_fragmentTools);
            if (R.id.fragmentTools != current) {
                navController.navigate(R.id.fragmentTools);
            }

        } else if (id == R.id.nav_share) {

            if (R.id.fragmentShare != current) {
                navController.navigate(R.id.fragmentShare);
            }

        } else if (id == R.id.nav_send) {
            if (R.id.fragmentSend != current) {
                navController.navigate(R.id.fragmentSend);
            }
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
