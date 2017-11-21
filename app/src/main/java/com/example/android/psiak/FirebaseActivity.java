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
import com.example.android.psiak.Utils.Const;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Hashtable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirebaseActivity extends AppCompatActivity implements FirebaseDataListener {

    private static final String TAG = FirebaseActivity.class.toString();

    // region Properties

    private FirebaseHelper firebaseHelper;

    /**
     * Reference to Firebase database
     */
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    /**
     * Reference to "dogs" end point in database
     */

    private DatabaseReference dogsReference = database.getReference("dogs");

    private ArrayList<DogFirebase> dogsCollection;

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

        // TODO Use dependency injection here
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
        firebaseHelper.writeNewDog();
        Toast.makeText(getBaseContext(), "Random dog was added", Toast.LENGTH_SHORT).show();
    }

    /**
     * Add new dog to the Firebase database
     */

    @OnClick(R.id.btn_add_new_dog)
    void addNewDogDog(View view) {

        String uniqueID = dogsReference.push().getKey();

        DogFirebase dogFirebase = new DogFirebase.DogBuilder(uniqueID, etDogName.getText().toString())
                .gender(etDogGender.getText().toString())
                .age(etDogAge.getText().toString())
                .description(etDogDescription.getText().toString())
                .size(etDogSize.getText().toString())
                .weight(etDogWeight.getText().toString())
                .location(etDogLocation.getText().toString())
                .attitudePeople(etDogAttitudePeople.getText().toString())
                .attitudeDogs(etDogAttitudeDogs.getText().toString())
                .attitudeCats(etDogAttitudeCats.getText().toString())
                .keeperName(etDogKeeperPhone.getText().toString())
                .keeperMail(etDogKeeperMail.getText().toString())
                .homelessSince(etDogHomelessSince.getText().toString())
                .build();
        
        firebaseHelper.writeNewDog(dogFirebase);

        Toast.makeText(getBaseContext(), "New dog added", Toast.LENGTH_SHORT).show();
    }

    // endregion

    // region Public Methods

    @Override
    public void setDogsData(ArrayList<DogFirebase> dogsData) {
        this.dogsCollection = dogsData;

        Log.e(TAG, "Dogs count " + " " + dogsData.size());
    }

    // endregion

    // region Getters

    public ArrayList<DogFirebase> getDogsCollection() {
        return dogsCollection;
    }

    // endregion
}
