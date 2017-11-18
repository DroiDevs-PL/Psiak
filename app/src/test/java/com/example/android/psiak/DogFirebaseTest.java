package com.example.android.psiak;

import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.Utils.Const;

import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

/**
 * Created by grzegorz.kwasniewski on 18.11.2017.
 *
 * Class For Testing DogFirebase Object
 */


public class DogFirebaseTest {

    @Test
    public void valid_DogFirebase_Initialization() throws Exception {

        Hashtable<String, String> dogData = new Hashtable<>();

        dogData.put(Const.NAME, "Fafik");
        dogData.put(Const.GENDER, "male");
        dogData.put(Const.AGE, "2");
        dogData.put(Const.DESCRIPTION, "desc");
        dogData.put(Const.SIZE, "small");
        dogData.put(Const.WEIGHT, "10");
        dogData.put(Const.LOCATION, "Gdańsk");
        dogData.put(Const.ATTITUDE_PEOPLE, "good");
        dogData.put(Const.ATTITUDE_DOGS, "good");
        dogData.put(Const.ATTITUDE_CATS, "good");
        dogData.put(Const.KEEPER_NAME, "Marcin");
        dogData.put(Const.KEEPER_PHONE, "111111111");
        dogData.put(Const.KEEPER_MAIL, "test@test.pl");
        dogData.put(Const.HOMELESS_SINCE, "2016-09-01");

        DogFirebase dogFirebase = new DogFirebase(dogData);

        assertEquals(dogFirebase.name, "Fafik");
        assertEquals(dogFirebase.gender, "male");
        assertEquals(dogFirebase.age, "2");
        assertEquals(dogFirebase.description, "desc");
        assertEquals(dogFirebase.size, "small");
        assertEquals(dogFirebase.weight, "10");
        assertEquals(dogFirebase.location, "Gdańsk");
        assertEquals(dogFirebase.attitude_people, "good");
        assertEquals(dogFirebase.attitude_dogs, "good");
        assertEquals(dogFirebase.attitude_cats, "good");
        assertEquals(dogFirebase.keeper_name, "Marcin");
        assertEquals(dogFirebase.keeper_phone, "111111111");
        assertEquals(dogFirebase.keeper_mail, "test@test.pl");
        assertEquals(dogFirebase.homeless_since, "2016-09-01");
    }

    @Test
    public void valid_DogFirebase_Initialization_With_Default_Values() throws Exception {

        Hashtable<String, String> dogData = new Hashtable<>();

        DogFirebase dogFirebase = new DogFirebase(dogData);

        assertEquals(dogFirebase.name, Const.NO_DATA);
        assertEquals(dogFirebase.gender, Const.NO_DATA);
        assertEquals(dogFirebase.age, Const.NO_DATA);
        assertEquals(dogFirebase.description, Const.NO_DATA);
        assertEquals(dogFirebase.size, Const.NO_DATA);
        assertEquals(dogFirebase.weight, Const.NO_DATA);
        assertEquals(dogFirebase.location, Const.NO_DATA);
        assertEquals(dogFirebase.attitude_people, Const.NO_DATA);
        assertEquals(dogFirebase.attitude_dogs, Const.NO_DATA);
        assertEquals(dogFirebase.attitude_cats, Const.NO_DATA);
        assertEquals(dogFirebase.keeper_name, Const.NO_DATA);
        assertEquals(dogFirebase.keeper_phone, Const.NO_DATA);
        assertEquals(dogFirebase.keeper_mail, Const.NO_DATA);
        assertEquals(dogFirebase.homeless_since, Const.NO_DATA);
    }
}
