package com.example.android.psiak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.psiak.Model.Dog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dog dog1 = Dog.builder()
                    .setAge(10)
                    .setCategory("pies")
                    .setDescription("duży pies")
                    .setGender("M")
                    .setLocationCity("Warszawa")
                    .setItemName("Burek")
                    .build();

        Log.d("Dog1",dog1.toString());
        Gson gson = new Gson();
        String dogAsJson = gson.toJson(dog1);
        Log.d("DogAsJson",dogAsJson);

        Dog dog2 = null;
        TypeAdapter<Dog> dogTypeAdapter = Dog.typeAdapter(gson);
        try {
            dog2 = dogTypeAdapter.fromJson(provideJSON());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("Dog2",dog2.toString());
        Log.d("Equals", Boolean.toString(dog1.equals(dog2)));

    }

    private String provideJSON(){
        return "{\"age\":10,\"category\":\"pies\",\"description\":\"duży pies\",\"gender\":\"M\",\"itemName\":\"Burek\",\"locationCity\":\"Warszawa\"}";
    }
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
        this.menu=menu;
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchModeMenuItem = menu.findItem(R.id.settings);
        return true;
    }
}
