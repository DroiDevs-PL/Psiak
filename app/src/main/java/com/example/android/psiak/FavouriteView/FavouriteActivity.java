package com.example.android.psiak.FavouriteView;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android.psiak.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteActivity extends AppCompatActivity {

    // region Private Properties

    //@BindView(R.id.favourites_recycler_view)
    //RecyclerView recyclerView;
    @BindView(R.id.favourites_root_layout)
    ConstraintLayout rootLayout;

    private DogAdapter dogAdapter;
    private LinearLayoutManager layoutManager;

    ViewPager viewPager;
    TabsPagerAdapter myAdapter;


    // endregion

    // region Activity Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        viewPager = (ViewPager) findViewById(R.id.vpPager);
        myAdapter = new TabsPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(myAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        //ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        dogAdapter = new DogAdapter(this, layoutManager, rootLayout);

        //recyclerView.setAdapter(dogAdapter);
    }

    // endregion
}
