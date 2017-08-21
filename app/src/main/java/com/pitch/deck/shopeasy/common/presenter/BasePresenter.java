package com.pitch.deck.shopeasy.common.presenter;

/**
 * Created by sangeetha on 18/8/17.
 */

public interface BasePresenter<T> {
    void setView(T view);

    void clearView();


}
