package com.pitch.deck.shopeasy.common.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sangeetha on 18/8/17.
 */

public class NavigationList {

    public String title;
    public String type;
    @SerializedName("navigate_to")
    public String navigateTo;
}
