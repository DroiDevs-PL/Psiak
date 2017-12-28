package com.example.android.psiak.ui.main;

import com.example.android.psiak.model.AnimalInterface;
import com.example.android.psiak.model.DogFirebase;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

public interface FirebaseDataListener {

    /**
     * Callback method from FirebaseRepository called after data was successfully fetch from database
     * @param dogsData Collection of DogFirebase object fetched from Firebase database
     */
    void setDogsData(ArrayList<DogFirebase> dogsData);

    /**
     * Callback method from FirebaseRepository called after fetching data from database failed
     * @param databaseException Database exception passed to listener object
     */
    void setErrorMessage(DatabaseException databaseException);

    /**
     * Called when Animal was successfully returned by from database.
     * @param animalInterface
     */
    void onAnimalReceived(AnimalInterface animalInterface);
}
