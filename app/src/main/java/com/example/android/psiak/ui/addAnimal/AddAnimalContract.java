package com.example.android.psiak.ui.addAnimal;

import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.BasePresenter;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

import java.util.ArrayList;

public interface AddAnimalContract {

    interface View extends MvpView {
        void showAllDogs(ArrayList<DogFirebase> dogs);
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void getAllDogs();
        void addNewDog(DogFirebase dogFirebase);
        String generateUniqueID();
    }
}
