package com.example.android.psiak.Firebase;

import android.util.Log;

import com.example.android.psiak.Model.DogFirebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Grzegorz on 13.11.2017.
 * Helper class for storing all functions related to Firebase operations
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

    /**
     * Callback that will be invoked when all dogs data will be
     * fetched from Firebase database
     */

    private FirebaseDataListener firebaseDataListener;

    /**
     * List for storing all dogs objects fetched from Firebase database
     */

    private ArrayList<DogFirebase> dogs = new ArrayList<DogFirebase>();

    // endregion

    // region Initializers

    /**
     *
     * @param dataListener Object that will receive notifications about data change
     *                     fetched from Firebase database
     */
    public FirebaseHelper(FirebaseDataListener dataListener) {
        this.firebaseDataListener = dataListener;
    }

    // endregion

    // region Public Methods

    /**
     * Fetch all dogs data from Firebase database
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

        DogFirebase dog = new DogFirebase(name, locationCity);

        // push() generates unique ID for dog on database
        dogsReference.push().setValue(dog);
    }

    /**
     * Write single dog object to "dogs" database
     * @param name Dog's first name
     * @param category ???
     * @param description Additional inforamtions about the dog
     */

    public void writeNewDog(String name, String category, String description) {

        DogFirebase dog = new DogFirebase(name, description);

        dogsReference.push().setValue(dog);

    }

    // endregion

    // region Computed Properties

    /**
     * New listener for "dogs" end point in Firebase database
     */

    ValueEventListener dogsListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot singleRecordSnapshot: dataSnapshot.getChildren()) {

                DogFirebase testDogFirebase = singleRecordSnapshot.getValue(DogFirebase.class);
                testDogFirebase.id = singleRecordSnapshot.getKey();

                dogs.add(testDogFirebase);

            }

            Log.e(TAG, "Dogs count " + " " + dataSnapshot.getChildrenCount());

            firebaseDataListener.setDogsData(dogs);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Getting Dogs failed, log a message
            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
        }
    };

    // endregion

    // region Getters

    public ArrayList<DogFirebase> getDogs() {
        return dogs;
    }

    // endregion
}
