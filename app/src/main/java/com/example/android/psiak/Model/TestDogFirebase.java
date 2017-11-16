package com.example.android.psiak.Model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Grzegorz on 13.11.2017.
 */

@IgnoreExtraProperties
public class TestDogFirebase {

    // region Public Properties /

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

    public Boolean vaccinated = false;
    public Boolean dewormed = false;
    public Boolean sterilized = false;

    public int weight;
    public int age;

    // endregion

    // region Initializers

    /**
     * Default constructor required for calls to DataSnapshot.getValue(TestDogFirebase.class)
     * It will set all model properties to theirs default values
     */

    private TestDogFirebase() {}

    public TestDogFirebase(String dogName, String description) {
        this.name = dogName;
        this.description = description;
    }

    // endregion

}
