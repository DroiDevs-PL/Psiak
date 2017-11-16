package com.example.android.psiak.Model;

/**
 * Created by Grzegorz on 13.11.2017.
 */

public class TestDogFirebase {

    // region Public Properties

    public String id;
    public String name;
    public String description;
    public String size;
    public String location;
    public String homeless_since;
    public String attitude_people;
    public String attitude_dogs;
    public String attitude_cats;
    public String profile_pic;
    public String photos;
    public String keeper_name;
    public String keeper_mail;
    public String keeper_phone;

    public Boolean vaccinated;
    public Boolean dewormed;
    public Boolean sterilized;

    public int weight;
    public int age;

    // endregion

    // region Initializers

    public TestDogFirebase() {
        // Default constructor required for calls to DataSnapshot.getValue(TestDogFirebase.class)
    }

    public TestDogFirebase(String dogName, String description) {
        this.name = dogName;
        this.description = description;
    }

    // endregion
}
