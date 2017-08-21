package com.pitch.deck.shopeasy.common.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.pitch.deck.shopeasy.R;
import com.pitch.deck.shopeasy.common.constants.ApplicationConstants;
import com.pitch.deck.shopeasy.common.model.Navigation;
import com.pitch.deck.shopeasy.common.presenter.SplashScreenPresenterContract;
import com.pitch.deck.shopeasy.common.presenter.SplashScreenPresenterImpl;

public class SplashActivity extends AppCompatActivity implements SplashScreenPresenterContract.SplashView {

    private SplashScreenPresenterImpl mPresenter;
    private FrameLayout mSplashContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViews();
        initPresenter();
        downloadConfig();
    }

    private void initViews() {
        mSplashContainer = (FrameLayout) findViewById(R.id.splash_container);
    }

    private void initPresenter() {
        mPresenter = new SplashScreenPresenterImpl();
        mPresenter.setView(this);

    }

    private void downloadConfig() {
        mPresenter.downloadConfig(getResources().getString(R.string.config_url));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.clearView();
    }

    @Override
    public void onDownloadFailed(String error) {
        Snackbar snackbar = Snackbar.make(mSplashContainer, R.string.no_network_msg, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.textColorPrimary));
        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        snackbar.show();

    }

    @Override
    public void onConfigDownloaded(Navigation navigation) {
        launchHomeScreen(navigation);

    }

    private void launchHomeScreen(Navigation navigation) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(ApplicationConstants.BundleKeys.NAVIGATION, navigation);
        intent.putExtra(ApplicationConstants.BundleKeys.DEFAULT_SECTION, navigation.defaultSec);
        startActivity(intent);
        finish();
    }
}
