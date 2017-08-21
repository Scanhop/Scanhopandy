package com.pitch.deck.shopeasy.common.interpreter;

import com.pitch.deck.shopeasy.common.io.ApiClientUtil;
import com.pitch.deck.shopeasy.common.io.BaseApiInterface;
import com.pitch.deck.shopeasy.common.io.IOCallbacks;
import com.pitch.deck.shopeasy.common.io.RestApiResponseCallback;
import com.pitch.deck.shopeasy.common.model.Navigation;

import retrofit2.Call;

/**
 * Created by sangeetha on 18/8/17.
 */

public class SplashScreenInterpreter {

    public void getConfigData(String url, IOCallbacks.RestAPICallbackListner listner) {
        BaseApiInterface apiInterface = ApiClientUtil.getInstance().getApiClient().create(BaseApiInterface.class);
        Call<Navigation> config = apiInterface.getConfig(url);
        config.enqueue(new RestApiResponseCallback<Navigation>(listner));
    }
}
