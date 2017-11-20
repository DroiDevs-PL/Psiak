package com.example.android.psiak.Repository;

import com.example.android.psiak.Model.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public class InMemoryRepository implements Repository {

    private static InMemoryRepository instance;
    private final List<Dog> items;

    public static InMemoryRepository getInstance(){
        if(instance == null)
            instance = new InMemoryRepository();
        return instance;
    }

    private InMemoryRepository(){
        this.items = new ArrayList<>();
    }

    @Override
    public List<Dog> getAll() {
        return items;
    }

    @Override
    public Dog findAnimal(String queryString) {
        return null;
    }

    @Override
    public void add(Dog dog) {
        items.add(dog);
    }

    @Override
    public boolean remove(Dog dog) {
        return items.remove(dog);
    }

    @Override
    public void removeAll() {
        items.clear();
    }
}
