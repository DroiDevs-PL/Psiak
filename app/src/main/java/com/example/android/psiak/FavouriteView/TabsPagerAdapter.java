package com.example.android.psiak.FavouriteView;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.psiak.R;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 4;

    Context context;

    private String[] titles;

    public TabsPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);

        this.context = context;

        titles = new String[] {
                context.getResources().getString(R.string.tab_all_animals),
                context.getResources().getString(R.string.tab_dogs),
                context.getResources().getString(R.string.tab_cats),
                context.getResources().getString(R.string.tab_others)
        };
    }

    @Override
    public int getCount() {
        return  NUM_ITEMS ;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllAnimalsFragment();
            case 1:
                return new AllAnimalsFragment();
            case 2:
                return new AllAnimalsFragment();
            case 3:
                return new AllAnimalsFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  titles[position];
    }

}
