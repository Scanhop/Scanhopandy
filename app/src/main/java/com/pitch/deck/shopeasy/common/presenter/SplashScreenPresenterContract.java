package com.pitch.deck.shopeasy.common.presenter;

import com.pitch.deck.shopeasy.common.model.Navigation;

/**
 * Created by sangeetha on 18/8/17.
 */

public class SplashScreenPresenterContract {

    public interface SplashScreenPresenter extends BasePresenter<SplashScreenPresenterContract.SplashView> {

        void downloadConfig(String url);
    }

    public interface SplashView extends BaseView{

        void onConfigDownloaded(Navigation navigation);
    }
}
