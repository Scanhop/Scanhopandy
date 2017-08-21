package com.pitch.deck.shopeasy.common.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pitch.deck.shopeasy.R;
import com.pitch.deck.shopeasy.common.model.NavigationItem;
import com.pitch.deck.shopeasy.common.views.TintableImageView;

import java.util.List;

/**
 * Created by sangeetha on 21/8/17.
 */

public class NavigationDrawerAdapter extends ArrayAdapter<NavigationItem> {

    private LayoutInflater mInflator;

    public NavigationDrawerAdapter(Context context, List<NavigationItem> navList) {
        super(context, 0, navList);
        mInflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflator.inflate(R.layout.nav_drawer_item, parent, false);
            holder.navTitle = (TextView) convertView.findViewById(R.id.nav_menu_title);
            holder.navIcon = (TintableImageView) convertView.findViewById(R.id.nav_menu_icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        setNavigationItem(holder, getItem(position));
        return convertView;
    }

    private void setNavigationItem(ViewHolder holder, NavigationItem item) {
        holder.navTitle.setText(item.title);
        //Glide.with(getContext()).load(item.icon).into(holder.navIcon);

    }

    private class ViewHolder {
        public TextView navTitle;
        public TintableImageView navIcon;
    }
}
