package com.example.android.psiak.AddAnimal;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public interface AddAnimalContract {

    interface View {
        void showSuccessMessage();

        void showErrorMessage();
    }

    interface Presenter {

        void save(String name, String kind);//void save(Dog dog);

    }
}
