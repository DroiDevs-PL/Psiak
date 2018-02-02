package com.example.android.psiak.ui.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.psiak.R;
import com.example.android.psiak.data.local.DogsLocalRepository;
import com.example.android.psiak.data.network.FirebaseRepository;
import com.example.android.psiak.model.AnimalType;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.aboutUs.AboutUsActivity;
import com.example.android.psiak.ui.addAnimal.AddAnimalActivity;
import com.example.android.psiak.ui.favouriteView.FavouriteActivity;
import com.example.android.psiak.ui.settings.SettingsActivity;
import com.example.android.psiak.utils.GooglePlayUtils;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MainContract.View, SharedPreferences.OnSharedPreferenceChangeListener {


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

    //ButterKnife don't work with menu items
    Spinner sortSpinner;

    private MainPresenter mainPresenter;

    //endregion
    private Menu menu;

    private ItemRemovedListener itemRemovedListener = new ItemRemovedListener() {
        @Override
        public void onItemRemoved(int count) {
            if (count == 0) {
                dogsAvailableLayout.setVisibility(View.INVISIBLE);
                noDogsLayout.setVisibility(View.VISIBLE);
                noDogs.setText(R.string.no_more_results);
            }
        }
    };

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
        mainPresenter = new MainPresenter(new FirebaseRepository(), new DogsLocalRepository(this));
        mainPresenter.attachView(this);
        mainPresenter.getAllDogs();

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navList.setNavigationItemSelectedListener(this);

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
//todo uncomment before release
        GooglePlayUtils.app_launched(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    private void configureSortSpinner() {
        final MenuItem item = menu.findItem(R.id.sort);
        sortSpinner = (Spinner) item.getActionView();
        ArrayAdapter<CharSequence> sortAdapter = ArrayAdapter.createFromResource(this, R.array.sort_criteria_array, android.R.layout.simple_spinner_item);
        sortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter(sortAdapter);
        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = sortSpinner.getSelectedItem().toString();
                mSwipeView.removeAllViews();
                mainPresenter.getSortedDogs(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //region navigationDrawer

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int menuItemId = item.getItemId();
        Intent intent;

        switch (menuItemId) {
            case R.id.homepage_nav_item:
                Snackbar.make(drawerLayout, "Główna", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.settings_nav_item:
                intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.favourites_nav_item:
                intent = new Intent(MainActivity.this, FavouriteActivity.class);
                startActivity(intent);
                break;
            case R.id.shelters_nav_item:
                Snackbar.make(drawerLayout, "Schroniska", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.about_nav_item:
                Intent aboutIntent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(aboutIntent);
                break;

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
            case R.id.firebaseTest:
                Intent intent = new Intent(this, AddAnimalActivity.class);
                startActivity(intent);
                return true;
            case R.id.refresh:
                mSwipeView.removeAllViews();
                mainPresenter.getAllDogs();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        configureSortSpinner();
        return true;
    }

    //endregion

    // region Public Methods

    @Override
    public void showAllDogs(List<DogFirebase> dogs) {
        Toast.makeText(getBaseContext(), "Firebase count " + " " + dogs.size(), Toast.LENGTH_SHORT).show();

        dogsAvailableLayout.setVisibility(View.VISIBLE);
        noDogsLayout.setVisibility(View.INVISIBLE);

        for (final DogFirebase dogFirebase : dogs) {
            TinderCard tinderCard = new TinderCard(MainActivity.this, dogFirebase, mSwipeView);
            TinderCard.SwipeCallback swipeCallback = () -> mainPresenter.addNewFavouriteDog(dogFirebase);
            tinderCard.setSwipeCallback(swipeCallback);
            mSwipeView.addView(tinderCard);
            Timber.d("onResponse: " + dogFirebase.getName());
        }
    }

    @Override
    public void showMessage(int messageId) {
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getBaseContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Log.d("MainActivity.class","Preference changed " + key);
        if(key.equals(getString(R.string.animal_preference_key))) {
            String animal_type = sharedPreferences.getString(key, getString(R.string.animal_default_value));
            String shelter_name = sharedPreferences.getString(getString(R.string.shelter_preference_key),getString(R.string.shelter_default_value));
            //TODO implement presenter call for animal type filtering
            mSwipeView.removeAllViews();
        }else if(key.equals(getString(R.string.shelter_preference_key))){
            //TODO implement presenter call for shelter change
        }

    }

    private void setupSharedPreferences(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //TODO implment getting data from shared preferences and updating animals list
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }
    // endregion
}
