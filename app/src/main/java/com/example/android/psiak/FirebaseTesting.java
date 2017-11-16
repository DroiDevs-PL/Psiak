package com.example.android.psiak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.psiak.Firebase.FirebaseHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirebaseTesting extends AppCompatActivity {

    // region Properties

    private FirebaseHelper firebaseHelper;

    @BindView(R.id.btn_add_random_dog)
    Button btnRandomDog;
    @BindView(R.id.btn_add_new_dog)
    Button btnAddNewDog;

    @BindView(R.id.et_dog_name)
    EditText etDogName;
    @BindView(R.id.et_dog_category)
    EditText etDogCateory;
    @BindView(R.id.et_dog_description)
    EditText etDogDescription;

    // endregion

    // region Activity Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_testing);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseHelper = new FirebaseHelper();

    }

    // endregion

    // region Private Methods


    /**
     * Add random dog to the firebase database
     */

    @OnClick(R.id.btn_add_random_dog)
    void addRandomDog(View view) {
        firebaseHelper.writeNewDog("Papik", "Warszawa");
        Toast.makeText(getBaseContext(), "Random dog was added", Toast.LENGTH_SHORT).show();
    }

    /**
     * Add random dog to the firebase database
     */

    @OnClick(R.id.btn_add_new_dog)
    void addNewDogDog(View view) {
        String dogName = etDogName.getText().toString();
        String dogCategory = etDogCateory.getText().toString();
        String dogDescription = etDogDescription.getText().toString();

        firebaseHelper.writeNewDog(dogName, dogCategory, dogDescription);

        Toast.makeText(getBaseContext(), "New dog added", Toast.LENGTH_SHORT).show();
    }

    // endregion
}
