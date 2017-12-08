package com.example.android.psiak.Firebase;

import android.util.Log;

import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.Repository.Repository;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
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
     * Reference to "dogs" endpoint in database
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
     * Default constructor
     */
    
    public FirebaseRepository() {}

    // endregion

    // region Public Methods

    @Override
    public void setDataListner(FirebaseDataListener dataListner) {
        this.firebaseDataListener = dataListner;
    }

    @Override
    public String generateUniqueID() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("dogs");
        String uniqueID = databaseReference.push().getKey();
        return uniqueID;
    }

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
        // TODO: Implement logic for find
        return null;
    }

    @Override
    public void update(DogFirebase firebaseObject) {
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(firebaseObject.getId(), firebaseObject);
        dogsReference.updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                // TODO: Inform user that data was updated successfully
            }
        });
    }

    @Override
    public void remove(DogFirebase firebaseObject) {
        dogsReference.child(firebaseObject.getId()).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                // TODO: Inform user that data about dog was removed
            }
        });
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

            if (firebaseDataListener != null) {
                firebaseDataListener.setDogsData(dogs);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            firebaseDataListener.setErrorMessage(databaseError.toException());
        }
    };

    // endregion

    // region Getters

    @Override
    public ArrayList<DogFirebase> getCachedDogs() {
        return dogs;
    }

    // endregion
}
