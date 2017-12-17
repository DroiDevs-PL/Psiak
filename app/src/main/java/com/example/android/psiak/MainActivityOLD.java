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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.psiak.Model.Dog;
import com.example.android.psiak.Network.DummyDogDataService;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

public class MainActivityOLD extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //region ui components declarations
    public final String TAG = MainActivity.class.getName();

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

        //region Swipe View init
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.05f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));
        mSwipeView.addItemRemoveListener(new ItemRemovedListener() {

            @Override
            public void onItemRemoved(int count) {
                if(count ==0 ){
                    dogsAvailableLayout.setVisibility(View.INVISIBLE);
                    noDogsLayout.setVisibility(View.VISIBLE);
                    noDogs.setText(R.string.no_more_results);
                }
            }
        });
        //endregion

        Retrofit retrofit = ((DoggieApplication)getApplication()).getRetrofitInstance();
        DummyDogDataService dummyDogDataService = retrofit.create(DummyDogDataService.class);
        Call<List<Dog>> dogCall = dummyDogDataService.loadDog();
        dogCall.enqueue(new Callback<List<Dog>>() {
            @Override
            public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {
                if(response.isSuccessful()) {
                    dogsAvailableLayout.setVisibility(View.VISIBLE);
                    noDogsLayout.setVisibility(View.INVISIBLE);
                    List<Dog> dogs = response.body();
                    String dogsListString = "";
                    for(Dog dog : dogs) {
                        mSwipeView.addView(new TinderCard(MainActivityOLD.this, dog, mSwipeView));
                        Timber.d(TAG, "onResponse: " + dog);
                    }
                }
                else {
                    dogsAvailableLayout.setVisibility(View.INVISIBLE);
                    noDogsLayout.setVisibility(View.VISIBLE);
                    int httpCode = response.code();
                    noDogs.setText(Integer.toString(httpCode));
                }
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                Timber.e(TAG, t.getMessage());
            }
        });

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navList.setNavigationItemSelectedListener(this);
    }

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
}
