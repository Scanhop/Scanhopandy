package com.pitch.deck.shopeasy.common.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sangeetha on 18/8/17.
 */

public class NavigationList implements Parcelable {

    public String title;
    public String icon;
    public String type;
    @SerializedName("navigate_to")
    public String navigateTo;

    protected NavigationList(Parcel in) {
        title = in.readString();
        icon = in.readString();
        type = in.readString();
        navigateTo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(icon);
        dest.writeString(type);
        dest.writeString(navigateTo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NavigationList> CREATOR = new Creator<NavigationList>() {
        @Override
        public NavigationList createFromParcel(Parcel in) {
            return new NavigationList(in);
        }

        @Override
        public NavigationList[] newArray(int size) {
            return new NavigationList[size];
        }
    };
}
