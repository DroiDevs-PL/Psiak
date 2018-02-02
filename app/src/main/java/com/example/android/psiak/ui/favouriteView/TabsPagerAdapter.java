package com.example.android.psiak.ui.favouriteView;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.psiak.R;
import com.example.android.psiak.model.AnimalType;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    // region Properties

    private int TABS_ITEMS_COUNT = 3;

    private Context context;

    private String[] tabsTitles;

    // endregion

    // region Initializers

    /**
     * Default initializer for TabsPagerAdapter
     * @param fragmentManager Fragment Manager passed from calling Activity
     * @param context Context of the app passed from calling Activity
     */

    public TabsPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);

        this.context = context;

        tabsTitles = new String[] {
                context.getResources().getString(R.string.tab_dogs),
                context.getResources().getString(R.string.tab_cats),
                context.getResources().getString(R.string.tab_others)
        };
    }

    // endregion

    // region Public Methods

    @Override
    public int getCount() {
        return TABS_ITEMS_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return createFragment("dog");
            case 1:
                return createFragment("cat");
            case 2:
                return createFragment("other");
            default:
                return null;
        }
    }

    @NonNull
    private Fragment createFragment(String animalsType) {
        AnimalsFragment fragment = new AnimalsFragment();
        Bundle animalsToshow = new Bundle();
        animalsToshow.putString("animalsToShow", animalsType);
        fragment.setArguments(animalsToshow);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  tabsTitles[position];
    }

    // endregion

}
