package com.pitch.deck.shopeasy.common.presenter;

import com.pitch.deck.shopeasy.common.interpreter.SplashScreenInterpreter;
import com.pitch.deck.shopeasy.common.io.IOCallbacks;
import com.pitch.deck.shopeasy.common.model.Navigation;

/**
 * Created by sangeetha on 18/8/17.
 */

public class SplashScreenPresenterImpl implements SplashScreenPresenterContract.SplashScreenPresenter, IOCallbacks.RestAPICallbackListner {


    private SplashScreenPresenterContract.SplashView mView;

    @Override
    public void setView(SplashScreenPresenterContract.SplashView view) {
        mView = view;
    }

    @Override
    public void clearView() {
        mView = null;
    }

    @Override
    public void downloadConfig(String url) {
        SplashScreenInterpreter interpreter = new SplashScreenInterpreter();
        interpreter.getConfigData(url, this);
    }

    @Override
    public void onResponseError(String error) {
        mView.onDownloadFailed(error);
    }

    @Override
    public <T> void onResponseSuccess(T response) {
        Navigation configuration = (Navigation) response;
        mView.onConfigDownloaded(configuration);
    }
}
