package com.example.android.psiak.Firebase;

import com.example.android.psiak.Model.Dog;
import com.example.android.psiak.Model.DogFirebase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzegorz on 23.11.2017.
 */

public interface FirebaseActivityContract {

    interface View {
        void showAllDogs(ArrayList<DogFirebase> dogs);
    }

    interface Presenter {
        void getAllDogs();
        void addNewDog(DogFirebase dogFirebase);
    }
}
