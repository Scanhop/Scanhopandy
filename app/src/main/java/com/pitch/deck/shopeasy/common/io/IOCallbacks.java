package com.pitch.deck.shopeasy.common.io;

/**
 * Created by sangeetha on 18/8/17.
 */

public class IOCallbacks {

    public interface RestAPICallbackListner {

        void onResponseError(String Error);

        <T> void onResponseSuccess(T response);
    }
}
