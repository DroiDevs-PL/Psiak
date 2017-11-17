package com.example.android.psiak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.android.psiak.Firebase.FirebaseHelper;
import com.example.android.psiak.Firebase.FirebaseDataListener;
import com.example.android.psiak.Model.DogFirebase;

import java.util.ArrayList;
import java.util.Hashtable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirebaseTesting extends AppCompatActivity implements FirebaseDataListener {

    private static final String TAG = FirebaseTesting.class.toString();

    // region Properties

    private FirebaseHelper firebaseHelper;

    @BindView(R.id.btn_add_random_dog)
    Button btnRandomDog;
    @BindView(R.id.btn_add_new_dog)
    Button btnAddNewDog;

    @BindView(R.id.et_dog_name)
    EditText etDogName;
    @BindView(R.id.et_dog_gender)
    EditText etDogGender;
    @BindView(R.id.et_dog_age)
    EditText etDogAge;
    @BindView(R.id.et_dog_description)
    EditText etDogDescription;
    @BindView(R.id.et_dog_size)
    EditText etDogSize;
    @BindView(R.id.et_dog_weight)
    EditText etDogWeight;
    @BindView(R.id.et_dog_location)
    EditText etDogLocation;
    @BindView(R.id.et_dog_attitude_people)
    EditText etDogAttitudePeople;
    @BindView(R.id.et_dog_attitude_dogs)
    EditText etDogAttitudeDogs;
    @BindView(R.id.et_dog_attitude_cats)
    EditText etDogAttitudeCats;
    @BindView(R.id.et_dog_keeper_name)
    EditText etDogKeeperName;
    @BindView(R.id.et_dog_keeper_phone)
    EditText etDogKeeperPhone;
    @BindView(R.id.et_dog_keeper_mail)
    EditText etDogKeeperMail;
    @BindView(R.id.et_dog_homeless_since)
    EditText etDogHomelessSince;
    @BindView(R.id.sw_dog_vaccinated)
    Switch swDogVaccinated;
    @BindView(R.id.sw_dog_dewormed)
    Switch swDogDewormed;
    @BindView(R.id.sw_dog_sterilized)
    Switch swDogSterilized;

    // endregion

    // region Activity Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_testing);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseHelper = new FirebaseHelper(this);

        firebaseHelper.getAllDogs();

    }

    // endregion

    // region Private Methods

    /**
     * Add random dog to the Firebase database
     */

    @OnClick(R.id.btn_add_random_dog)
    void addRandomDog(View view) {
        firebaseHelper.writeNewDog("Papik", "Warszawa");
        Toast.makeText(getBaseContext(), "Random dog was added", Toast.LENGTH_SHORT).show();
    }

    /**
     * Add new dog to the Firebase database
     */

    @OnClick(R.id.btn_add_new_dog)
    void addNewDogDog(View view) {

        Hashtable<String, String> dogData = new Hashtable<>();

        dogData.put("name", etDogName.getText().toString());
        dogData.put("gender", etDogGender.getText().toString());
        dogData.put("age", etDogAge.getText().toString());
        dogData.put("description", etDogDescription.getText().toString());
        dogData.put("size", etDogSize.getText().toString());
        dogData.put("weight", etDogWeight.getText().toString());
        dogData.put("location", etDogLocation.getText().toString());
        dogData.put("attitude_people", etDogAttitudePeople.getText().toString());
        dogData.put("attitude_dogs", etDogAttitudeDogs.getText().toString());
        dogData.put("attitude_cats", etDogAttitudeCats.getText().toString());
        dogData.put("keeper_name", etDogKeeperName.getText().toString());
        dogData.put("keeper_phone", etDogKeeperPhone.getText().toString());
        dogData.put("keeper_mail", etDogKeeperMail.getText().toString());
        dogData.put("homeless_since", etDogHomelessSince.getText().toString());
        
        firebaseHelper.writeNewDog(dogData);

        Toast.makeText(getBaseContext(), "New dog added", Toast.LENGTH_SHORT).show();
    }

    // endregion

    // region Public Methods

    @Override
    public void setDogsData(ArrayList<DogFirebase> dogsData) {
        Log.e(TAG, "Dogs count " + " " + dogsData.size());
    }

    // endregion
}
