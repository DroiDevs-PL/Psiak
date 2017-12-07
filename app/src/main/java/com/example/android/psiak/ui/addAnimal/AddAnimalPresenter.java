package com.example.android.psiak.ui.addAnimal;

import com.example.android.psiak.data.network.FirebaseRepository;
import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.BasePresenter;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

public class AddAnimalPresenter
        extends BasePresenter<AddAnimalContract.View>
        implements AddAnimalContract.Presenter, FirebaseDataListener {

    private static final String TAG = AddAnimalPresenter.class.toString();

    /**
     * Repository object that will be used with this presenter
     */

    Repository.Firebase<DogFirebase> firebaseRepository;

    /**
     * Initialize AddAnimalPresenter with Firebase repository. After initialization AddAnimalPresenter object will be set as a
     * data listener object for callback from Firebase repository
     * @param repository Repository.Firebase object that will be used with this Presenter
     */

    public AddAnimalPresenter(Repository.Firebase<DogFirebase> repository) {
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
