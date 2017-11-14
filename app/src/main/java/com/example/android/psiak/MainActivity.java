package com.example.android.psiak;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.doggie)
    ImageView doggie;
    @BindView(R.id.noDogs)
    TextView noDogs;
    @BindView(R.id.woof)
    TextView woof;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.navigation)
    NavigationView navList;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.btn_like)
    FloatingActionButton btnLike;
    @BindView(R.id.btn_dislike)
    FloatingActionButton btnDislike;

    //Todo implement rest https://www.journaldev.com/12648/navigationview-android
    private Menu menu;

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpNavigationDrawer();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Liked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Disliked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    //region navigationDrawer
    private void setUpNavigationDrawer() {
        addDrawerItems();
        navList.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Snackbar.make(drawerLayout, item.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private void addDrawerItems() {
//        navList.setAdapter( new ArrayAdapter<String>(this, R.layout.drawer_list_item, navigationItems));
    }
    //endregion


    //region menu methods
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Snackbar.make(drawerLayout, "Settings", Snackbar.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchModeMenuItem = menu.findItem(R.id.settings);
        return true;
    }
    //endregion
}
