package com.example.android.psiak.Firebase;

import android.util.Log;

import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.Repository.Repository;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Grzegorz on 23.11.2017.
 */

public class FirebasePresenter
        extends BasePresenter<FirebaseActivityContract.View>
        implements FirebaseActivityContract.Presenter, FirebaseDataListener {

    private static final String TAG = FirebasePresenter.class.toString();

    FirebaseRepository firebaseRepository;

    /**
     * List for caching all dogs objects fetched from Firebase database
     */
    private ArrayList<DogFirebase> dogs = new ArrayList<DogFirebase>();

    public FirebasePresenter() {
        this.firebaseRepository = new FirebaseRepository(this);
    }

    @Override
    public void getAllDogs() {
        if (dogs.size() > 0) {
            if (isViewAttached()) {
                view.showAllDogs(this.dogs);
            }
        } else {
            firebaseRepository.getAllDogs();
        }
    }

    @Override
    public void addNewDog(DogFirebase dogFirebase) {
        firebaseRepository.addNewDog(dogFirebase);
    }

    @Override
    public void setDogsData(ArrayList<DogFirebase> dogsData) {
        this.dogs = dogsData;

        if (isViewAttached()) {
            view.showAllDogs(this.dogs);
        }
    }
}
