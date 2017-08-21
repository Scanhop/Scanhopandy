package com.pitch.deck.shopeasy.common.ui;

import android.os.Bundle;
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

import com.pitch.deck.shopeasy.R;
import com.pitch.deck.shopeasy.common.constants.ApplicationConstants;
import com.pitch.deck.shopeasy.common.model.Navigation;

import java.util.List;

public class HomeActivity extends BaseActivity {

    private NavigationView mNaviagtionView;
    private List<Navigation> mNavigationList;
    private String mDefaultSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        extractArguments();
        initViews();
        initToolbar();
        initDrawerToggle();
        initNavigationMenu();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void initNavigationMenu() {
        
    }

    private void extractArguments() {
        if(getIntent() != null && getIntent().getExtras() != null) {
            mNavigationList = (List<Navigation>) getIntent().getSerializableExtra(ApplicationConstants.BundleKeys.NAVIGATION);
            mDefaultSec = getIntent().getStringExtra(ApplicationConstants.BundleKeys.DEFAULT_SECTION);
        }
    }


    private void initViews() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mNaviagtionView = (NavigationView) findViewById(R.id.nav_view);
        mNavDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
