package com.example.android.psiak.Model;

import android.content.res.Resources;

import com.google.firebase.database.IgnoreExtraProperties;
import java.util.Hashtable;

/**
 * Created by Grzegorz on 13.11.2017.
 */

@IgnoreExtraProperties
public class DogFirebase {

    // region Public Properties

    public String id;
    public String name;
    public String gender;
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

    public String vaccinated;
    public String dewormed;
    public String sterilized;

    public String weight;
    public String age;

    // endregion

    // region Initializers

    /**
     * Default constructor required for calls to DataSnapshot.getValue(DogFirebase.class)
     * It will set all model properties to theirs default values
     */

    private DogFirebase() {}

    public DogFirebase(Hashtable<String, String> dogsData) {
        this.name = dogsData.containsKey("name") ? dogsData.get("name") : "no data";
        this.gender = dogsData.containsKey("gender") ? dogsData.get("gender") : "no data";
        this.description = dogsData.containsKey("description") ? dogsData.get("description") : "no data";
        this.size = dogsData.containsKey("size") ? dogsData.get("size") : "no data";
        this.location = dogsData.containsKey("location") ? dogsData.get("location") : "no data";
        this.homeless_since = dogsData.containsKey("homeless_since") ? dogsData.get("homeless_since") : "no data";
        this.attitude_people = dogsData.containsKey("attitude_people") ? dogsData.get("attitude_people") : "no data";
        this.attitude_dogs = dogsData.containsKey("attitude_dogs") ? dogsData.get("attitude_dogs") : "no data";
        this.attitude_cats = dogsData.containsKey("attitude_cats") ? dogsData.get("attitude_cats") : "no data";
        this.keeper_name = dogsData.containsKey("keeper_name") ? dogsData.get("keeper_name") : "no data";
        this.keeper_mail = dogsData.containsKey("keeper_mail") ? dogsData.get("keeper_mail") : "no data";
        this.keeper_phone = dogsData.containsKey("keeper_phone") ? dogsData.get("keeper_phone") : "no data";

        this.vaccinated = dogsData.containsKey("vaccinated") ? dogsData.get("vaccinated") : "no data";
        this.dewormed = dogsData.containsKey("dewormed") ? dogsData.get("dewormed") : "no data";
        this.sterilized = dogsData.containsKey("sterilized") ? dogsData.get("sterilized") : "no data";

        this.weight = dogsData.containsKey("weight") ? dogsData.get("weight") : "no data";
        this.age = dogsData.containsKey("age") ? dogsData.get("age") : "no data";

    }

    public DogFirebase(String dogName, String description) {
        this.name = dogName;
        this.description = description;
    }

    // endregion

}
