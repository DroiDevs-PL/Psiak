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

    /**
     * Repository object that will be used with this presenter
     */

    Repository.Firebase firebaseRepository;

    /**
     * Initialize FirebasePresenter with specified repository. After initialization FirebasePresenter object will be set as a
     * data listner object for callback from repository
     * @param repository Repository.Dog object that will be used with this Presenter
     */

    public FirebasePresenter(Repository.Firebase repository) {
        this.firebaseRepository = repository;
        this.firebaseRepository.setDataListner(this);
    }

    @Override
    public void getAllDogs() {

        ArrayList<DogFirebase> dogsData = firebaseRepository.getCachedDogs();

        if (dogsData.size() > 0) {
            if (isViewAttached()) {
                view.showAllDogs(dogsData);
            }
        } else {
            firebaseRepository.getAllObjects();
        }
    }

    @Override
    public void addNewDog(DogFirebase dogFirebase) {
        firebaseRepository.addNew(dogFirebase);
    }

    @Override
    public void setDogsData(ArrayList<DogFirebase> dogsData) {
        if (isViewAttached()) {
            view.showAllDogs(dogsData);
        }
    }
}