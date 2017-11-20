package com.example.android.psiak.Repository;

import com.example.android.psiak.Model.Dog;

import java.util.List;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public interface Repository {

    List<Dog> getAll();
    Dog findAnimal(String queryString);
    void add(Dog dog);
    boolean remove(Dog dog);
    void removeAll();
}
