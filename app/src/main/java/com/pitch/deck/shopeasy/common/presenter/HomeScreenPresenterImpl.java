package com.pitch.deck.shopeasy.common.presenter;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.pitch.deck.shopeasy.common.constants.ApplicationConstants;
import com.pitch.deck.shopeasy.common.model.NavigationItem;
import com.pitch.deck.shopeasy.common.model.NavigationList;
import com.pitch.deck.shopeasy.scanner.BarCodeScannerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangeetha on 21/8/17.
 */

public class HomeScreenPresenterImpl implements HomeScreenPresenterContract.HomeScreenPresenter {

    private HomeScreenPresenterContract.HomeScreenView mView;

    @Override
    public void setView(HomeScreenPresenterContract.HomeScreenView view) {
        mView = view;
    }

    @Override
    public void clearView() {
        mView = null;
    }

    @Override
    public int getDefaultNavPos(String defaultSec, List<NavigationItem> navItemList) {
        if (!TextUtils.isEmpty(defaultSec)) {
            for (int i = 0; i < navItemList.size(); i++) {
                if (navItemList.get(i).title.equalsIgnoreCase(defaultSec)) {
                    return i;
                }
            }
        }
        return 0;
    }

    @Override
    public List<NavigationItem> getNavigationItemList(List<NavigationList> navigationList) {
        List<NavigationItem> mNavList = new ArrayList<>();
        for (NavigationList item : navigationList) {
            NavigationItem navItem = new NavigationItem();
            navItem.title = item.title;
            navItem.icon = item.icon;
            mNavList.add(navItem);
        }
        return mNavList;
    }

    @Override
    public Fragment getFragment(int position, List<NavigationList> navList) {
            Fragment fragment = null;
            String type = navList.get(position).type;
            if (type.equalsIgnoreCase(ApplicationConstants.NavigationType.SCANNER)) {
                fragment = new BarCodeScannerFragment();
            }
            return fragment;

    }


}
