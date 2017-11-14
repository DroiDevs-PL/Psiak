package com.example.android.psiak.Firebase;

import com.example.android.psiak.Model.TestDogFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Grzegorz on 13.11.2017.
 */

public class FirebaseHelper {

    // region Properties

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference dogsReference = database.getReference("dogs");

    // endregion

    /**
     * Write single dog object to "dogs" database
     * @param name Dog's first name
     * @param locationCity Dog's birth place
     */

    public void writeNewDog(String name, String locationCity) {
        TestDogFirebase dog = new TestDogFirebase(name, locationCity);

        dogsReference.push().setValue(dog);
    }
}
