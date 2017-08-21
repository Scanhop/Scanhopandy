package com.pitch.deck.shopeasy.common.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sangeetha on 18/8/17.
 */

public class Navigation implements Parcelable {

    @SerializedName("default_section")
    public String defaultSec;
    public List<NavigationList> navigation;

    protected Navigation(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Navigation> CREATOR = new Creator<Navigation>() {
        @Override
        public Navigation createFromParcel(Parcel in) {
            return new Navigation(in);
        }

        @Override
        public Navigation[] newArray(int size) {
            return new Navigation[size];
        }
    };
}
