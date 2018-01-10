package com.example.android.psiak.ui.main;

import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

import java.util.List;

/**
 * Created by Maciej Bialorucki on 07.12.17.
 */

public interface MainContract {

    interface View extends MvpView {
        void showAllDogs(List<DogFirebase> dogs);
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void getAllDogs();
        void getSortedDogs(String fieldName);
        void addNewFavouriteDog(DogFirebase dogFirebase);
        void addNewDog(DogFirebase dogFirebase);
        String generateUniqueID();    }
}
