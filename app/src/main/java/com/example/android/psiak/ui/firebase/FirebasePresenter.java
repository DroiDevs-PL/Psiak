package com.example.android.psiak.ui.firebase;

import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.BasePresenter;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

public class FirebasePresenter
        extends BasePresenter<FirebaseActivityContract.View>
        implements FirebaseActivityContract.Presenter, FirebaseDataListener {

    private static final String TAG = FirebasePresenter.class.toString();

    /**
     * Repository object that will be used with this presenter
     */

    FirebaseRepository firebaseRepository;

    /**
     * Initialize FirebasePresenter with Firebase repository. After initialization FirebasePresenter object will be set as a
     * data listener object for callback from Firebase repository
     * @param repository Repository.Firebase object that will be used with this Presenter
     */

    public FirebasePresenter(FirebaseRepository repository) {
        this.firebaseRepository = repository;
        this.firebaseRepository.setDataListner(this);
    }

    @Override
    public String generateUniqueID() {
        String uniqueID = firebaseRepository.generateUniqueID();
        return uniqueID;
    }

    @Override
    public void getAllDogs() {

        ArrayList<DogFirebase> dogsData = firebaseRepository.getCachedDogs();

        if (dogsData.size() > 0 && isViewAttached()) {
            view.showAllDogs(dogsData);
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

    @Override
    public void setErrorMessage(DatabaseException databaseException) {
        view.showErrorMessage(databaseException.getMessage());
    }
}
