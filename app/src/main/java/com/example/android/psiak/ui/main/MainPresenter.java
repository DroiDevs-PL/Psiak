package com.example.android.psiak.ui.main;

import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.addAnimal.AddAnimalPresenter;
import com.example.android.psiak.ui.base.BasePresenter;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

/**
 * Created by Maciej Bialorucki on 07.12.17.
 */

class MainPresenter
    extends BasePresenter<MainContract.View>
    implements MainContract.Presenter<MainContract.View>, FirebaseDataListener {

  private static final String TAG = AddAnimalPresenter.class.toString();

  /**
   * Repository object that will be used with this presenter
   */

  Repository.Firebase<DogFirebase> firebaseRepository;

  /**
   * Initialize MainPresenter with Firebase repository. After initialization MainPresenter object
   * will be set as a data listener object for callback from Firebase repository
   *
   * @param repository Repository.Firebase object that will be used with this Presenter
   */

  public MainPresenter(Repository.Firebase<DogFirebase> repository) {
    this.firebaseRepository = repository;
    this.firebaseRepository.setDataListner(this);
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
  public void setDogsData(ArrayList<DogFirebase> dogsData) {
    if (isViewAttached()) {
      view.showAllDogs(dogsData);
    }
  }

  @Override
  public void setErrorMessage(DatabaseException databaseException) {
    view.showErrorMessage(databaseException.getMessage());
  }

  @Override
  public void onAnimalReceived(DogFirebase animalInterface) {

  }
}
