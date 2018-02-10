package com.example.android.psiak.ui.main;

import android.content.Context;

import com.example.android.psiak.model.Animal;
import com.example.android.psiak.model.AnimalType;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Bialorucki on 07.12.17.
 */

public interface MainContract {

    interface View extends MvpView {
        void showAllDogs(List<DogFirebase> dogs);
        void showAnimals(List<Animal> animals);
        void getAnimals();
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {

        void getAllDogs(Context context);
        void getSortedDogs(String fieldName, Context context);
        void setDogsWithoutDuplicates(ArrayList<DogFirebase> dogsData);
        void addNewFavouriteDog(DogFirebase dogFirebase);

        void getAnimalsForShelter(AnimalType animalType,String shelterName);
        void getAllAnimals(AnimalType animalType);
        void addNewFavouriteAnimal(Animal animal);
        void getAllAnimalsForShelter(String shelterName);
        void getAllResetDogs();
        void refreshAnimalsData();
    }
}
