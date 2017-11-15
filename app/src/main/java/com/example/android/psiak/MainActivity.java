package com.example.android.psiak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.psiak.Model.Dog;
import com.example.android.psiak.Network.DummyDogDataService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public final String TAG = MainActivity.class.getName();

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
                    textView.setText(dogsListString);

                }
                else {
                    int httpCode = response.code();
                    textView.setText(Integer.toString(httpCode));
                }
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });

    }

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
