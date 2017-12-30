package com.example.android.psiak.ui.addAnimal;

import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

public interface AddAnimalContract {

    interface View extends MvpView {

    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void addNewDog(DogFirebase dogFirebase);
        String generateUniqueID();
    }
}
