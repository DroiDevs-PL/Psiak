package com.example.android.psiak.Model;

import com.example.android.psiak.Utils.Const;
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
    public String keeper_name;
    public String keeper_mail;
    public String keeper_phone;

    public String vaccinated;
    public String dewormed;
    public String sterilized;

    public String weight;
    public String age;

    // TODO Add properties to the constructor
    public String profile_pic;
    public String photos;

    // endregion

    // region Initializers

    /**
     * Default constructor required for calls to DataSnapshot.getValue(DogFirebase.class)
     * It will set all model properties to theirs default values
     */

    public DogFirebase() {}

    /**
     * Constructor used to fully initialize dog object
     * @param dogsData Collection of data about the dog. Hashtable is used for thread-safety
     */

    public DogFirebase(Hashtable<String, String> dogsData) {
        this.name = dogsData.containsKey(Const.NAME) ? dogsData.get(Const.NAME) : Const.NO_DATA;
        this.gender = dogsData.containsKey(Const.GENDER) ? dogsData.get(Const.GENDER) : Const.NO_DATA;
        this.description = dogsData.containsKey(Const.DESCRIPTION) ? dogsData.get(Const.DESCRIPTION) : Const.NO_DATA;
        this.size = dogsData.containsKey(Const.SIZE) ? dogsData.get(Const.SIZE) : Const.NO_DATA;
        this.location = dogsData.containsKey(Const.LOCATION) ? dogsData.get(Const.LOCATION) : Const.NO_DATA;
        this.homeless_since = dogsData.containsKey(Const.HOMELESS_SINCE) ? dogsData.get(Const.HOMELESS_SINCE) : Const.NO_DATA;
        this.attitude_people = dogsData.containsKey(Const.ATTITUDE_PEOPLE) ? dogsData.get(Const.ATTITUDE_PEOPLE) : Const.NO_DATA;
        this.attitude_dogs = dogsData.containsKey(Const.ATTITUDE_DOGS) ? dogsData.get(Const.ATTITUDE_DOGS) : Const.NO_DATA;
        this.attitude_cats = dogsData.containsKey(Const.ATTITUDE_CATS) ? dogsData.get(Const.ATTITUDE_CATS) : Const.NO_DATA;
        this.keeper_name = dogsData.containsKey(Const.KEEPER_NAME) ? dogsData.get(Const.KEEPER_NAME) : Const.NO_DATA;
        this.keeper_mail = dogsData.containsKey(Const.KEEPER_MAIL) ? dogsData.get(Const.KEEPER_MAIL) : Const.NO_DATA;
        this.keeper_phone = dogsData.containsKey(Const.KEEPER_PHONE) ? dogsData.get(Const.KEEPER_PHONE) : Const.NO_DATA;

        this.vaccinated = dogsData.containsKey(Const.VACCINATED) ? dogsData.get(Const.VACCINATED) : Const.NO_DATA;
        this.dewormed = dogsData.containsKey(Const.DEWORMED) ? dogsData.get(Const.DEWORMED) : Const.NO_DATA;
        this.sterilized = dogsData.containsKey(Const.STERILIZED) ? dogsData.get(Const.STERILIZED) : Const.NO_DATA;

        this.weight = dogsData.containsKey(Const.WEIGHT) ? dogsData.get(Const.WEIGHT) : Const.NO_DATA;
        this.age = dogsData.containsKey(Const.AGE) ? dogsData.get(Const.AGE) : Const.NO_DATA;

    }

    /**
     * This initalizer is used only for testing and will removed before the release
     * @param dogName Dog's name
     * @param description Dog's description
     */

    public DogFirebase(String dogName, String description) {
        this.name = dogName;
        this.description = description;
    }

    // endregion

}
