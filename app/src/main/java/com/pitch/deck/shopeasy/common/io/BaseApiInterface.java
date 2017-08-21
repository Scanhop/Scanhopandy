package com.pitch.deck.shopeasy.common.io;

import com.pitch.deck.shopeasy.common.model.Navigation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by sangeetha on 9/8/17.
 */

public interface BaseApiInterface {
    //    @GET
//    Call<ProductDetail> getProductDetails(@Url String url);
    @GET
    Call<Navigation> getConfig(@Url String url);
}
