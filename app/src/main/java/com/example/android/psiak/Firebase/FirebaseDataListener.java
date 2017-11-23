package com.example.android.psiak.Firebase;

import com.example.android.psiak.Model.DogFirebase;

import java.util.ArrayList;

/**
 * Created by grzegorz.kwasniewski on 17.11.2017.
 */

public interface FirebaseDataListener {

    /**
     * Callback method from FirebaseRepository
     * @param dogsData Collection of DogFirebase object fetched from Firebase database
     */
    void setDogsData(ArrayList<DogFirebase> dogsData);
}
