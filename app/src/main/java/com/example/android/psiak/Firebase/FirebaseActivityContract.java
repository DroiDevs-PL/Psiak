package com.example.android.psiak.Firebase;

import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.ui.base.BasePresenter;
import com.example.android.psiak.ui.base.MvpView;

import java.util.ArrayList;

public interface FirebaseActivityContract {

    interface View extends MvpView {
        void showAllDogs(ArrayList<DogFirebase> dogs);
        void showErrorMessage(String errorMessage);
    }

    interface Presenter {
        void getAllDogs();
        void addNewFavouriteDog(DogFirebase dogFirebase);
        void addNewDog(DogFirebase dogFirebase);
        String generateUniqueID();
    }
}
