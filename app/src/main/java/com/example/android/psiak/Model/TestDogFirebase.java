package com.example.android.psiak.Model;

/**
 * Created by Grzegorz on 13.11.2017.
 */

public class TestDogFirebase {
    public String username;
    public String locationCity;

    public TestDogFirebase() {
        // Default constructor required for calls to DataSnapshot.getValue(TestDogFirebase.class)
    }

    public TestDogFirebase(String username, String email) {
        this.username = username;
        this.locationCity = email;
    }
}
