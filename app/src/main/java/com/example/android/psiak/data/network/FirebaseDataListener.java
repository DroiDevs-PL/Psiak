package com.example.android.psiak.data.network;

import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

public interface FirebaseDataListener<T> {

    /**
     * Callback method from FirebaseRepository called after data was successfully fetch from database
     * @param dogsData Collection of DogFirebase object fetched from Firebase database
     */
    void setDogsData(ArrayList<T> dogsData);

    /**
     * Callback method from FirebaseRepository called after fetching data from database failed
     * @param databaseException Database exception passed to listener object
     */
    void setErrorMessage(DatabaseException databaseException);

    /**
     * Called when Animal was successfully returned by from database.
     * @param animalInterface
     */
}
