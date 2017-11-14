package com.example.android.psiak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.android.psiak.Firebase.FirebaseHelper;

public class FirebaseTesting extends AppCompatActivity {

    // region Properties

    private FirebaseHelper firebaseHelper;

    private Button btnRandomDog;

    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_testing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseHelper = new FirebaseHelper();

        btnRandomDog = (Button) findViewById(R.id.btn_add_random_dog);

        btnRandomDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseHelper.writeNewDog("Papik", "Warszawa");
            }
        });

    }
}
