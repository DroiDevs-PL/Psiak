package com.example.android.psiak.data.repository;

import java.util.List;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public interface Repository<T> {

    List<T> getAll();
    T find(String queryString);
    void add(T animal);
    boolean remove(T animal);
    void removeAll();
}
