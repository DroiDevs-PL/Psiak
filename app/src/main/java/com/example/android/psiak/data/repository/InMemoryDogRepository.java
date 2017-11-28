package com.example.android.psiak.data.repository;

import com.example.android.psiak.model.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public class InMemoryDogRepository implements Repository<Dog> {

    private static InMemoryDogRepository instance;
    private final List<Dog> items;

    public static InMemoryDogRepository getInstance(){
        if(instance == null)
            instance = new InMemoryDogRepository();
        return instance;
    }

    private InMemoryDogRepository(){
        this.items = new ArrayList<>();
    }


    @Override
    public List<Dog> getAll() {
        return items;
    }

    @Override
    public Dog find(String queryString) {
        return null;
    }

    @Override
    public void add(Dog animal) {
        items.add(animal);
    }

    @Override
    public boolean remove(Dog animal) {
        return items.remove(animal);
    }

    @Override
    public void removeAll() {
        items.clear();
    }
}
