package com.pitch.deck.shopeasy.common.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sangeetha on 18/8/17.
 */

public class Navigation {

    @SerializedName("default_section")
    public String defaultSec;
    public List<NavigationList> navigation;


}
