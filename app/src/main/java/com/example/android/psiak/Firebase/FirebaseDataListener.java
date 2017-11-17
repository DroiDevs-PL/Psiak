package com.example.android.psiak.Firebase;

import com.example.android.psiak.Model.DogFirebase;

import java.util.ArrayList;

/**
 * Created by grzegorz.kwasniewski on 17.11.2017.
 */

public interface FirebaseDataListener {
    void setDogsData(ArrayList<DogFirebase> dogsData);
}
