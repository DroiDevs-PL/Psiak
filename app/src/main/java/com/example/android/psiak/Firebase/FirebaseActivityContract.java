package com.example.android.psiak.Firebase;

import com.example.android.psiak.Model.DogFirebase;

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
