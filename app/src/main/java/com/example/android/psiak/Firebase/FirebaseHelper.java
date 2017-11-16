package com.example.android.psiak.Firebase;

import android.util.Log;

import com.example.android.psiak.Model.TestDogFirebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Grzegorz on 13.11.2017.
 */

public class FirebaseHelper {

    private static final String TAG = FirebaseHelper.class.toString();

    // region Properties

    /**
     * Reference to Firebase database
     */
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    /**
     * Reference to "dogs" end point in database
     */
    private DatabaseReference dogsReference = database.getReference("dogs");

    // endregion

    // region Public Methods

    /**
     * Fetch all dogs data for Firebase database
     */

    public void getAllDogs() {
        dogsReference.addListenerForSingleValueEvent(dogsListener);
    }

    /**
     * Write single dog object to "dogs" database
     * @param name Dog's first name
     * @param locationCity Dog's birth place
     */

    public void writeNewDog(String name, String locationCity) {

        TestDogFirebase dog = new TestDogFirebase(name, locationCity);

        dogsReference.push().setValue(dog);
    }

    /**
     * Write single dog object to "dogs" database
     * @param name Dog's first name
     * @param category ???
     * @param description Additional inforamtions about the dog
     */

    public void writeNewDog(String name, String category, String description) {

        TestDogFirebase dog = new TestDogFirebase(name, description);

        dogsReference.push().setValue(dog);

    }

    // endregion

    // region Computed Properties

    /**
     * New listner for "dogs" end point in Firebase database
     */

    ValueEventListener dogsListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {

                TestDogFirebase testDogFirebase = messageSnapshot.getValue(TestDogFirebase.class);

                Log.e(TAG, "Dogs count " + " " + dataSnapshot.getChildrenCount() + " " + "dog name" + " " + testDogFirebase.name);

            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Getting Post failed, log a message
            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            // ...
        }
    };

    // endregion
}
