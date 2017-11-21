package com.example.android.psiak.Firebase;

import android.util.Log;

import com.example.android.psiak.Model.DogFirebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Hashtable;

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
     * @param dataListener Object that will receive notifications about change of data
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
     */

    public void writeNewDog() {

        // push() generates unique ID for dog on database
        String uniqueID = dogsReference.push().getKey();

        DogFirebase dog = new DogFirebase.DogBuilder(uniqueID, "Pies testowy").build();

        dogsReference.child(uniqueID).setValue(dog);
    }

    /**
     * Write single dog object to "dogs" database
     * @param dogFirebase Collection of data about the dog
     */

    public void writeNewDog(DogFirebase dogFirebase) {

        dogsReference.child(dogFirebase.getId()).setValue(dogFirebase);

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

                DogFirebase dogFirebase = singleRecordSnapshot.getValue(DogFirebase.class);

                dogs.add(dogFirebase);

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
