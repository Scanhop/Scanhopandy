package com.pitch.deck.shopeasy.common.presenter;

import android.support.v4.app.Fragment;

import com.pitch.deck.shopeasy.common.model.NavigationItem;
import com.pitch.deck.shopeasy.common.model.NavigationList;

import java.util.List;

/**
 * Created by sangeetha on 21/8/17.
 */

public class HomeScreenPresenterContract {


    public interface HomeScreenPresenter extends BasePresenter<HomeScreenView> {

        int getDefaultNavPos(String defaultSec, List<NavigationItem> navItemList);

        List<NavigationItem> getNavigationItemList(List<NavigationList> navigationList);

        Fragment getFragment(int position, List<NavigationList> navList);
    }

    public interface HomeScreenView {

    }
}
