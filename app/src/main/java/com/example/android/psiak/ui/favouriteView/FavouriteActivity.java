package com.example.android.psiak.ui.favouriteView;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.android.psiak.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteActivity extends AppCompatActivity {

    private static final String TAG = FavouriteActivity.class.toString();

    // region Private Properties

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.favourites_view_pager)
    ViewPager viewPager;
    @BindView(R.id.favourites_tabs)
    TabLayout tabLayout;

    private TabsPagerAdapter myAdapter;

    // endregion

    // region Activity Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!= null){
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        myAdapter = new TabsPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    // endregion
}
