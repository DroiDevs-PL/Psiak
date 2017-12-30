package com.example.android.psiak.ui.showAnimalDetails;

import com.example.android.psiak.model.AnimalInterface;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;


public interface ShowAnimalDetailsContract {
  interface View extends MvpView {
    String INTENT_EXTRA_ANIMAL_ID = "animal_id";

    void setAnimalDetails(AnimalInterface animal);

    void showLoader();
    void hideLoader();
  }

  interface Presenter<V extends MvpView> extends MvpPresenter<V> {
    void loadAnimal(String id);
  }
}
