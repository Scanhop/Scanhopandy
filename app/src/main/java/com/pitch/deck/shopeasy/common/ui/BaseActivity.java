package com.pitch.deck.shopeasy.common.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pitch.deck.shopeasy.R;

public class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolBar;
    protected DrawerLayout mNavDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initToolbar() {
        setSupportActionBar(mToolBar);
    }

    protected void initDrawerToggle() {
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mNavDrawer, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mNavDrawer.post(new Runnable() {
            @Override
            public void run() {
                //calling sync state is necessary or else your hamburger icon wont show up
                toggle.syncState();
            }
        });

        //Setting the actionbarToggle to drawer layout
        mNavDrawer.addDrawerListener(toggle);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
