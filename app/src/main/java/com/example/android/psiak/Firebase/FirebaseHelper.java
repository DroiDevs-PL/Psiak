package com.example.android.psiak.Firebase;

import com.example.android.psiak.Model.TestDogFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Grzegorz on 13.11.2017.
 */

public class FirebaseHelper {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("dogs");

    public void writeNewDog(String dogID, String name, String locationCity) {
        TestDogFirebase user = new TestDogFirebase(name, locationCity);

        databaseReference.child(dogID).setValue(user);
    }
}
