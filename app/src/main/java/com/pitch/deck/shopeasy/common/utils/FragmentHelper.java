package com.pitch.deck.shopeasy.common.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by sangeetha on 21/8/17.
 */

public class FragmentHelper {

    public static void replaceAndAddToBackStack(final FragmentActivity activity, final int containerId,
                                                final Fragment fragment, String tag) {
        try {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(containerId, fragment);
            transaction.addToBackStack(tag);
            transaction.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }


    public static void replaceFragment(final FragmentActivity activity, final int containerId,
                                       final Fragment fragment) {
        try {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(containerId, fragment);
            transaction.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

}
