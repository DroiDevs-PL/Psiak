package com.example.android.psiak.ui.main;

import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.data.network.SortingStrategyFactory;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.addAnimal.AddAnimalPresenter;
import com.example.android.psiak.ui.base.BasePresenter;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;
import java.util.Collections;

import io.realm.RealmResults;
import timber.log.Timber;

class MainPresenter
        extends BasePresenter<MainContract.View>
        implements MainContract.Presenter<MainContract.View> , FirebaseDataListener {

        private static final String TAG = AddAnimalPresenter.class.toString();

    /**
     * Repository object that will be used with this presenter
     */

    Repository.Firebase firebaseRepository;
    Repository.LocalRepository localRepository;

    /**
     * Initialize FirebasePresenter with Firebase repository. After initialization FirebasePresenter object will be set as a
     * data listener object for callback from Firebase repository
     * @param repository Repository.Firebase object that will be used with this Presenter
     * @param localRepository Repository.LocalRepository object that will be used with this Presenter
     */

    public MainPresenter(Repository.Firebase repository, Repository.LocalRepository localRepository) {
        this.firebaseRepository = repository;
        this.localRepository = localRepository;
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
    public void getSortedDogs(String fieldName) {
        ArrayList<DogFirebase> dogsData = firebaseRepository.getCachedDogs();
        Collections.sort(dogsData, SortingStrategyFactory.getStrategyForField(fieldName));
        if(isViewAttached()){
            view.showAllDogs(dogsData);
        }
    }

    @Override
    public void addNewFavouriteDog(DogFirebase dogFirebase) {

        dogFirebase.setFavourite(true);
        localRepository.add(dogFirebase);

        Timber.d("Save "  + dogFirebase.getName());

        RealmResults<DogFirebase> dogs = localRepository.getAll();

        for(DogFirebase d : dogs) {
            Timber.d(d.toString());
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
