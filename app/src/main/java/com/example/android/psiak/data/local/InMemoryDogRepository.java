package com.example.android.psiak.data.local;

import com.example.android.psiak.data.network.FirebaseDataListener;
import com.example.android.psiak.model.AnimalType;
import com.example.android.psiak.model.Dog;
import com.example.android.psiak.model.DogFirebase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public class InMemoryDogRepository implements com.example.android.psiak.data.network.Repository.Firebase<DogFirebase> {

    private static InMemoryDogRepository instance;
    private final ArrayList<DogFirebase> items;

    private InMemoryDogRepository(){
        this.items = new ArrayList<>();
    }

    public static InMemoryDogRepository getInstance(){
        if(instance == null)
            instance = new InMemoryDogRepository();
        return instance;
    }


    @Override
    public String generateUniqueID() {
        return null;
    }

    @Override
    public void setDataListner(FirebaseDataListener dataListner) {

    }

    @Override
    public void getAllObjects() {

    }

    @Override
    public DogFirebase find(String queryString) {
        return null;
    }

    @Override
    public void getById(String id, FirebaseDataListener callback) {

    }

    @Override
    public void addNew(DogFirebase firebaseObject) {
        items.add(firebaseObject);
    }

    @Override
    public void update(DogFirebase firebaseObject) {

    }

    @Override
    public void remove(DogFirebase firebaseObject) {

    }

    @Override
    public ArrayList<DogFirebase> getCachedDogs() {
        return items;
    }

    @Override
    public ArrayList<DogFirebase> getCachedAnimals(AnimalType animalType, String shelter_name) {
        return null;
    }


}
