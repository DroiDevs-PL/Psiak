package com.example.android.psiak.model;

/**
 * Created by Maciej Bialorucki on 01.02.18.
 */

public enum AnimalType {

    DOGS,
    CATS,
    OTHERS;

    public static AnimalType fromString(String name) {
        switch (name) {
            case "dogs":
            case "psy":
                return DOGS;
            case "cats":
            case "koty":
                return CATS;
            case "others":
            case "inne":
                return OTHERS;
            default:
                return DOGS;
        }
    }

    }
