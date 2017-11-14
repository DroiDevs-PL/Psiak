package com.example.android.psiak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.navList)
    ListView navList;

    private Menu menu;

    //adding nawigation drawer
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpNavigationDrawer();


    }

    //region navigationDrawer
    private void setUpNavigationDrawer() {
        addDrawerItems();
        navList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //toDO refactor this to use id instead of position in case order changes
                switch (position) {
                    case 0: {
                        Toast.makeText(MainActivity.this, "Główna", Toast.LENGTH_SHORT).show();
                    }
                    case 1: {
                        Toast.makeText(MainActivity.this, "Fav", Toast.LENGTH_SHORT).show();
                    }
                    case 2: {
                        Toast.makeText(MainActivity.this, "Prefs", Toast.LENGTH_SHORT).show();
                    }
                    case 3: {
                        Toast.makeText(MainActivity.this, "AvailableShelters", Toast.LENGTH_SHORT).show();
                    }
                    case 4: {
                        Toast.makeText(MainActivity.this, "Procedure", Toast.LENGTH_SHORT).show();
                    }
                    case 5: {
                        Toast.makeText(MainActivity.this, "About to do", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    private void addDrawerItems() {
        String[] osArray = {"Główna", "Ulubione", "Preferencje", "Dostępne schroniska", "Procedura adopcyjna", "O nas"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        navList.setAdapter(mAdapter);
    }
    //endregion


    //region menu methods
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            Toast.makeText(this, "Tutaj będą ustawienia!", Toast.LENGTH_SHORT).show();
        }
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
