package com.example.android.psiak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.psiak.Firebase.FirebaseHelper;

public class FirebaseTesting extends AppCompatActivity {

    // region Properties

    private FirebaseHelper firebaseHelper;

    private Button btnRandomDog;
    private Button btnAddNewDog;

    private EditText etDogName;
    private EditText etDogCateory;
    private EditText etDogDescription;

    // endregion

    // region Activity Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_testing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseHelper = new FirebaseHelper();

        setupAllEditText();

        setupAddRandomDogButton();

        setupAddNewDogButton();

    }

    // endregion

    // region Private Methods

    /**
     * Assign all EditText objects that activity use
     */

    private void setupAllEditText() {
        etDogName = (EditText) findViewById(R.id.et_dog_name);
        etDogCateory = (EditText) findViewById(R.id.et_dog_category);
        etDogDescription = (EditText) findViewById(R.id.et_dog_description);
    }

    /**
     * Assign button for adding random dog and create OnClickListner
     */

    private void setupAddRandomDogButton() {
        btnRandomDog = (Button) findViewById(R.id.btn_add_random_dog);

        btnRandomDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseHelper.writeNewDog("Papik", "Warszawa");
                Toast.makeText(getBaseContext(), "Random dog was added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Assign button for adding new dog and create OnClickListner
     */

    private void setupAddNewDogButton() {
        btnAddNewDog = (Button) findViewById(R.id.btn_add_new_dog);

        btnAddNewDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dogName = etDogName.getText().toString();
                String dogCategory = etDogCateory.getText().toString();
                String dogDescription = etDogDescription.getText().toString();

                firebaseHelper.writeNewDog(dogName, dogCategory, dogDescription);

                Toast.makeText(getBaseContext(), "New dog added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // endregion
}
