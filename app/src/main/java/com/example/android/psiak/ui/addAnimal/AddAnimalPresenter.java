package com.example.android.psiak.ui.addAnimal;

import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.ui.base.BasePresenter;

public class AddAnimalPresenter
        extends BasePresenter<AddAnimalContract.View>
        implements AddAnimalContract.Presenter<AddAnimalContract.View> {

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
    }

    @Override
    public String generateUniqueID() {
        String uniqueID = firebaseRepository.generateUniqueID();
        return uniqueID;
    }


    @Override
    public void addNewDog(DogFirebase dogFirebase) {
        firebaseRepository.addNew(dogFirebase);
    }


}
