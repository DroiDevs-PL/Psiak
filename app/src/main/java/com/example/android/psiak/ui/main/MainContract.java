package com.example.android.psiak.ui.main;

import com.example.android.psiak.model.DogFirebase;

import java.util.List;

/**
 * Created by Maciej Bialorucki on 07.12.17.
 */

public interface MainContract {

    interface View{
        void showAllDogs(List<DogFirebase> dogs);
        void showErrorMessage(String errorMessage);
    }

    interface Presenter{
        void getAllDogs();
    }
}
