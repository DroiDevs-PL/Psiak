package com.example.android.psiak.ui.firebase;

import com.example.android.psiak.model.DogFirebase;

import java.util.ArrayList;

public interface FirebaseActivityContract {

    interface View {
        void showAllDogs(ArrayList<DogFirebase> dogs);
        void showErrorMessage(String errorMessage);
    }

    interface Presenter {
        void getAllDogs();
        void addNewDog(DogFirebase dogFirebase);
        String generateUniqueID();
    }
}
