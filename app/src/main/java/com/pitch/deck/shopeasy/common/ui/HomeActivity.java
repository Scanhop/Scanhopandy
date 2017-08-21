package com.pitch.deck.shopeasy.common.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pitch.deck.shopeasy.R;
import com.pitch.deck.shopeasy.common.constants.ApplicationConstants;
import com.pitch.deck.shopeasy.common.model.NavigationItem;
import com.pitch.deck.shopeasy.common.model.NavigationList;
import com.pitch.deck.shopeasy.common.presenter.HomeScreenPresenterContract;
import com.pitch.deck.shopeasy.common.presenter.HomeScreenPresenterImpl;
import com.pitch.deck.shopeasy.common.utils.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, HomeScreenPresenterContract.HomeScreenView {

    private List<NavigationItem> mNavDrawerItemList = new ArrayList<>();
    private String mDefaultSec;
    private Toolbar mToolBar;
    private DrawerLayout mNavDrawer;
    private ListView mNavgationListView;
    private List<NavigationList> mNavigationList;
    private HomeScreenPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initPresenter();
        extractArguments();
        initViews();
        initToolbar();
        initDrawerToggle();
        initNavigationMenu();

    }

    private void initPresenter() {
        mPresenter = new HomeScreenPresenterImpl();
        mPresenter.setView(this);
    }

    private void initNavigationMenu() {
        mNavgationListView.setAdapter(new NavigationDrawerAdapter(this, mNavDrawerItemList));
        mNavgationListView.performItemClick(mNavgationListView.getAdapter().getView(mPresenter.getDefaultNavPos(mDefaultSec, mNavDrawerItemList), null, null),
                mPresenter.getDefaultNavPos(mDefaultSec, mNavDrawerItemList), mPresenter.getDefaultNavPos(mDefaultSec, mNavDrawerItemList));

    }


    private void extractArguments() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            mNavigationList = getIntent().getParcelableArrayListExtra(ApplicationConstants.BundleKeys.NAVIGATION);
            mNavDrawerItemList = mPresenter.getNavigationItemList(mNavigationList);
            mDefaultSec = getIntent().getStringExtra(ApplicationConstants.BundleKeys.DEFAULT_SECTION);
        }
    }


    private void initViews() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mNavDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavgationListView = (ListView) findViewById(R.id.navigation_list);
        mNavgationListView.setOnItemClickListener(this);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment = mPresenter.getFragment(position, mNavigationList);
        if (fragment != null) {
            addContentFragment(fragment);
        }

        closeDrawer();

    }

    private void addContentFragment(Fragment fragment) {
        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            FragmentHelper.replaceFragment(this, R.id.container, fragment);
        } else {
            FragmentHelper.replaceAndAddToBackStack(this, R.id.container, fragment, fragment.getClass().getName());
        }
    }


    private void openDrawer() {
        if (mNavDrawer != null) {
            mNavDrawer.openDrawer(GravityCompat.START);
        }
    }

    private void closeDrawer() {
        if (mNavDrawer != null) {
            mNavDrawer.closeDrawer(GravityCompat.START);
        }
    }


}
