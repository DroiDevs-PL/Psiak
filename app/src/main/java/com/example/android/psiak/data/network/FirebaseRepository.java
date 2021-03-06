package com.example.android.psiak.data.network;

import com.example.android.psiak.model.AnimalType;
import com.example.android.psiak.model.DogFirebase;
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

public class FirebaseRepository<T extends Repository.Firebase.Identifiable>
        implements Repository.Firebase<T> {

    // region Properties

    /**
     * Reference to Firebase database
     */

    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    /**
     * Reference to "dogs" endpoint in database
     */

    private DatabaseReference dogsReference;

    /**
     * Callback that will be invoked when all dogs data will be
     * fetched from Firebase database
     */

    private FirebaseDataListener<T> firebaseDataListener;

    /**
     * List for storing all dogs objects fetched from Firebase database
     */

    private ArrayList<T> dogs = new ArrayList<>();

    private final Class<T> typeParameterClass;

    private String endpoint;

    // endregion

    // region Initializers

    /**
     * Default constructor
     */
    
    public FirebaseRepository(String endpoint, Class<T> typeParameterClass) {
        this.endpoint = endpoint;
        dogsReference  = database.getReference(endpoint);
        this.typeParameterClass = typeParameterClass;
    }

    // endregion

    public static final String SHELTER_ENDPOINT = "shelters";
    public static final String AVAILABLE_DOGS_ENDPOINT = "dogs";


    // region Public Methods

    @Override
    public void setDataListner(FirebaseDataListener dataListner) {
        this.firebaseDataListener = dataListner;
    }

    @Override
    public String generateUniqueID() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(endpoint);
        String uniqueID = databaseReference.push().getKey();
        return uniqueID;
    }

    @Override
    public void getAllObjects() {
        dogsReference.addListenerForSingleValueEvent(dogsListener);
    }

    @Override
    public void addNew(T dogFirebase) {
        dogsReference.child(dogFirebase.getId()).setValue(dogFirebase);
    }

    @Override
    public T find(String queryString) {
        // TODO: Implement logic for find
        return null;
    }

    @Override
    public void getById(String id, FirebaseDataListener callback) {

    }

    @Override
    public void update(T firebaseObject) {
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
    public void remove(T firebaseObject) {
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
                T dogFirebase = singleRecordSnapshot.getValue(typeParameterClass);
                dogFirebase.setId(singleRecordSnapshot.getKey());
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
    public ArrayList<T> getCachedDogs() {
        return dogs;
    }

    @Override
    public ArrayList<DogFirebase> getCachedAnimals(AnimalType animalType, String shelter_name) {
        return null;
    }

    // endregion

}
