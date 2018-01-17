package com.example.android.psiak.data.network;

import com.example.android.psiak.model.DogFirebase;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maciej Bialorucki on 08.01.18.
 */

public class SortingStrategyFactory {

    private static final Map<String, Comparator<DogFirebase>> strategies = new HashMap<>();
    private static final Comparator<DogFirebase> defaultSortingStrategy = (d1, d2) -> d1.getName().compareTo(d2.getName());

    static {
        strategies.put("płeć", (d1, d2) -> d1.getGender().compareTo(d2.getGender()));
        strategies.put("gender", (d1, d2) -> d1.getGender().compareTo(d2.getGender()));
        strategies.put("wiek", (d1, d2) -> d1.getAge().compareTo(d2.getAge()));
        strategies.put("age", (d1, d2) -> d1.getAge().compareTo(d2.getAge()));
        strategies.put("waga",(d1,d2) -> d1.getWeight().compareTo(d2.getWeight()));
        strategies.put("weight",(d1,d2)->d1.getWeight().compareTo(d2.getWeight()));
        strategies.put("wielkość",(d1,d2)->d1.getSize().compareTo(d2.getSize()));
        strategies.put("size",(d1,d2)->d1.getSize().compareTo(d2.getSize()));
    }

    public static Comparator<DogFirebase> getStrategyForField(String fieldName) {
        return strategies.get(fieldName) == null ? defaultSortingStrategy : strategies.get(fieldName);
    }
}
