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

        DogFirebase dogFirebase = new DogFirebase.DogBuilder("1", "Fafik")
                .gender("male")
                .age("2")
                .description("desc")
                .size("small")
                .weight("10")
                .location("Gdańsk")
                .attitudePeople("good")
                .attitudeDogs("good")
                .attitudeCats("good")
                .keeperName("Marcin")
                .keeperPhone("1")
                .keeperMail("test@test.pl")
                .homelessSince("2016-09-01")
                .build();

        assertEquals(dogFirebase.getName(), "Fafik");
        assertEquals(dogFirebase.getGender(), "male");
        assertEquals(dogFirebase.getAge(), "2");
        assertEquals(dogFirebase.getDescription(), "desc");
        assertEquals(dogFirebase.getSize(), "small");
        assertEquals(dogFirebase.getWeight(), "10");
        assertEquals(dogFirebase.getLocation(), "Gdańsk");
        assertEquals(dogFirebase.getAttitudePeople(), "good");
        assertEquals(dogFirebase.getAttitudeDogs(), "good");
        assertEquals(dogFirebase.getAttitudeCats(), "good");
        assertEquals(dogFirebase.getKeeperName(), "Marcin");
        assertEquals(dogFirebase.getKeeperPhone(), "1");
        assertEquals(dogFirebase.getKeeperMail(), "test@test.pl");
        assertEquals(dogFirebase.getHomelessSince(), "2016-09-01");
    }
}
