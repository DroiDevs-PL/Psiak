package com.example.android.psiak.ui.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirebaseActivity
        extends AppCompatActivity
        implements FirebaseActivityContract.View {

    private static final String TAG = FirebaseActivity.class.toString();

    // region Properties

    private FirebasePresenter firebasePresenter;

    @BindView(R.id.btn_show_all_dogs)
    Button btnShowAllDogs;
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
        firebasePresenter = new FirebasePresenter(new FirebaseRepository());
        firebasePresenter.attach(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (firebasePresenter != null)
            firebasePresenter.detach();
    }

    // endregion

    // region Private Methods

    /**
     * Get all Dog's objects form database
     */

    @OnClick(R.id.btn_show_all_dogs)
    void getAllDogs(View view) {
        firebasePresenter.getAllDogs();
    }

    /**
     * Add new dog to the Firebase database
     */

    @OnClick(R.id.btn_add_new_dog)
    void addNewDogDog(View view) {

        String uniqueID = firebasePresenter.generateUniqueID();

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
                .dewormed(swDogDewormed.isChecked())
                .sterilized(swDogSterilized.isChecked())
                .vaccinated(swDogVaccinated.isChecked())
                .build();
        
        firebasePresenter.addNewDog(dogFirebase);

        Toast.makeText(getBaseContext(), "New dog added", Toast.LENGTH_SHORT).show();
    }

    // endregion

    // region Public Methods

    @Override
    public void showAllDogs(ArrayList<DogFirebase> dogs) {
        Toast.makeText(getBaseContext(), "Firebase count " + " " + dogs.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getBaseContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    // endregion
}
