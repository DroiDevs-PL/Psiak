package com.example.android.psiak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.psiak.Firebase.FirebaseActivityContract;
import com.example.android.psiak.Firebase.FirebasePresenter;
import com.example.android.psiak.Firebase.FirebaseRepository;
import com.example.android.psiak.Model.DogFirebase;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FirebaseActivityContract.View {

    public final String TAG = MainActivity.class.getName();

    private FirebasePresenter firebasePresenter;

    //region ui components declarations

    @BindView(R.id.doggie)
    ImageView doggie;
    @BindView(R.id.noDogs)
    TextView noDogs;
    @BindView(R.id.woof)
    TextView woof;
    @BindView(R.id.navigation)
    NavigationView navList;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.swipeView)
    SwipePlaceHolderView mSwipeView;
    @BindView(R.id.noDogsLayout)
    ConstraintLayout noDogsLayout;
    @BindView(R.id.dogsAvailableLayout)
    ConstraintLayout dogsAvailableLayout;

    //endregion

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.05f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        mSwipeView.addItemRemoveListener(itemRemovedListener);

        // TODO Use dependency injection here
        firebasePresenter = new FirebasePresenter(new FirebaseRepository());
        firebasePresenter.attach(this);
        firebasePresenter.getAllDogs();

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navList.setNavigationItemSelectedListener(this);
    }

    private ItemRemovedListener itemRemovedListener = new ItemRemovedListener() {
        @Override
        public void onItemRemoved(int count) {
            if(count == 0 ){
                dogsAvailableLayout.setVisibility(View.INVISIBLE);
                noDogsLayout.setVisibility(View.VISIBLE);
                noDogs.setText("Brak dalszych wyników");
            }
        }
    };

    //region navigationDrawer

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.homepage_nav_item) {
            Snackbar.make(drawerLayout, "Główna", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.settings_nav_item) {
            Snackbar.make(drawerLayout, "Settings", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.favourites_nav_item) {
            Snackbar.make(drawerLayout, "Ulubione", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.shelters_nav_item) {
            Snackbar.make(drawerLayout, "Schroniska", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.about_nav_item) {
            Snackbar.make(drawerLayout, "O nas", Snackbar.LENGTH_LONG).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //endregion

    //region menu methods

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.settings:
                Snackbar.make(drawerLayout, "Settings", Snackbar.LENGTH_LONG).show();
                return true;

            case R.id.firebaseTest:
                Intent intent = new Intent(this, FirebaseActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchModeMenuItem = menu.findItem(R.id.settings);
        return true;
    }

    //endregion

    // region Public Methods

    @Override
    public void showAllDogs(ArrayList<DogFirebase> dogs) {
        Toast.makeText(getBaseContext(), "Firebase count " + " " + dogs.size(), Toast.LENGTH_SHORT).show();

        dogsAvailableLayout.setVisibility(View.VISIBLE);
        noDogsLayout.setVisibility(View.INVISIBLE);

        for(DogFirebase dogFirebase : dogs) {
            mSwipeView.addView(new TinderCard(MainActivity.this, dogFirebase, mSwipeView));
            Log.d(TAG, "onResponse: " + dogFirebase);
        }
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getBaseContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    // endregion
}
