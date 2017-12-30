package com.example.android.psiak.ui.showAnimalDetails;

import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.data.network.Repository.Firebase;
import com.example.android.psiak.model.AnimalInterface;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.BasePresenter;
import com.example.android.psiak.ui.main.FirebaseDataListener;
import com.example.android.psiak.ui.showAnimalDetails.ShowAnimalDetailsContract.View;
import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import timber.log.Timber;


public class ShowAnimalDetailsPresenter
    extends BasePresenter<View>
    implements ShowAnimalDetailsContract.Presenter<ShowAnimalDetailsContract.View> {

  private Firebase<DogFirebase> repository;

  public ShowAnimalDetailsPresenter(Repository.Firebase<DogFirebase> repository) {
    this.repository = repository;
  }

  @Override
  public void loadAnimal(String id) {
    view.showLoader();

    this.repository.getById(id, new FirebaseDataListener() {
      @Override
      public void setDogsData(ArrayList<DogFirebase> dogsData) {

      }

      @Override
      public void setErrorMessage(DatabaseException databaseException) {
        Timber.e(databaseException);
      }

      @Override
      public void onAnimalReceived(AnimalInterface animalInterface) {
        view.hideLoader();
        view.setAnimalDetails(animalInterface);
      }
    });
  }
}
