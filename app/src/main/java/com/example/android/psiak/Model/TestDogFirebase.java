package com.example.android.psiak.Model;

/**
 * Created by Grzegorz on 13.11.2017.
 */

public class TestDogFirebase {

    // region Public Properties

    public String dogName;
    public String dogLocationCity;
    public String category;
    public String description;

    // endregion

    // region Initializers

    public TestDogFirebase() {
        // Default constructor required for calls to DataSnapshot.getValue(TestDogFirebase.class)
    }

    public TestDogFirebase(String dogName, String dogLocationCity) {
        this.dogName = dogName;
        this.dogLocationCity = dogLocationCity;
    }

    public TestDogFirebase(String dogName, String category, String description) {
        this.dogName = dogName;
        this.category = category;
        this.description = description;
    }

    // endregion
}
