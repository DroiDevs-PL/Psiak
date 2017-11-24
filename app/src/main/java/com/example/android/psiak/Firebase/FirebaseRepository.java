package com.example.android.psiak.Firebase;

import android.util.Log;

import com.example.android.psiak.Model.Dog;
import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.Repository.Repository;
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

public class FirebaseRepository implements Repository.Firebase<DogFirebase> {

    private static final String TAG = FirebaseRepository.class.toString();

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
    public FirebaseRepository(FirebaseDataListener dataListener) {
        this.firebaseDataListener = dataListener;
    }

    // endregion

    // region Public Methods

    @Override
    public void getAllObjects() {
        dogsReference.addListenerForSingleValueEvent(dogsListener);
    }

    @Override
    public void addNew(DogFirebase dogFirebase) {
        dogsReference.child(dogFirebase.getId()).setValue(dogFirebase);
    }

    @Override
    public DogFirebase find(String queryString) {
        // TODO: Implement logic for findDog(String queryString)
        return null;
    }

    @Override
    public boolean remove(DogFirebase dogFirebase) {
        // TODO: Implement logic for remove(DogFirebase dogFirebase)
        return false;
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

            Log.e(TAG, "Firebase count " + " " + dataSnapshot.getChildrenCount());

            firebaseDataListener.setDogsData(dogs);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Getting Firebase failed, log a message
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
