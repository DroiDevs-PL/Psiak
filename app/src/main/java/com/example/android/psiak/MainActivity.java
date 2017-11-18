package com.example.android.psiak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.psiak.Model.Dog;
import com.example.android.psiak.Network.DummyDogDataService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //region ui components declarations
    public final String TAG = MainActivity.class.getName();

    @BindView(R.id.doggie)
    ImageView doggie;
    @BindView(R.id.noDogs)
    TextView noDogs;
    @BindView(R.id.woof)
    TextView woof;
    @BindView(R.id.tempText)
    TextView tempText;
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
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//endregion

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Retrofit retrofit = ((DoggieApplication)getApplication()).getRetrofitInstance();
        DummyDogDataService dummyDogDataService = retrofit.create(DummyDogDataService.class);
        Call<List<Dog>> dogCall = dummyDogDataService.loadDog();
        dogCall.enqueue(new Callback<List<Dog>>() {
            @Override
            public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {
                if(response.isSuccessful()) {
                    List<Dog> dogs = response.body();
                   // String dogsList = dogs.stream().reduce("", (d1, d2) -> d1.toString() + d2.toString()));
                    String dogsListString = "";
                    for(Dog d : dogs) {
                        dogsListString = dogsListString + d + "\n";
                    }
                    tempText.setText(dogsListString);
                }
                else {
                    int httpCode = response.code();
                    tempText.setText("Error with code:" + Integer.toString(httpCode));
                }
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navList.setNavigationItemSelectedListener(this);

    }

    @OnClick(R.id.btn_like)
    void setupLikeButton(View view){
        Snackbar.make(view, "Liked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    @OnClick(R.id.btn_dislike)
    void setupDislikeButton(View view){
        Snackbar.make(view, "Disliked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

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
