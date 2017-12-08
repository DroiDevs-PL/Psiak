package com.example.android.psiak.ui.addAnimal;

import com.example.android.psiak.model.DogFirebase;

import java.util.ArrayList;

public interface AddAnimalContract {

    interface View {
        void showAllDogs(ArrayList<DogFirebase> dogs);

    }

    interface Presenter {
        void getAllDogs();
        void addNewDog(DogFirebase dogFirebase);
        String generateUniqueID();
    }
}
