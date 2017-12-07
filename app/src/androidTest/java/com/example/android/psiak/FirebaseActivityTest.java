package com.example.android.psiak;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.android.psiak.ui.addAnimal.AddAnimalActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * Class For Running Instrumentation Tests For FirebaseActivty
 */

@RunWith(AndroidJUnit4.class)
public class FirebaseActivityTest {

    private AddAnimalActivity firebaseActivity;

    @Rule
    public ActivityTestRule<AddAnimalActivity> rule  = new  ActivityTestRule<>(AddAnimalActivity.class);

    @Before
    public void setActivity() {
        firebaseActivity = rule.getActivity();
    }

    @Test
    public void all_Views_Are_Bind() throws Exception {

        Button btnAddNewDog = firebaseActivity.findViewById(R.id.btn_add_new_dog);
        Button btnShowAllDogs = firebaseActivity.findViewById(R.id.btn_show_all_dogs);

        EditText etDogName = firebaseActivity.findViewById(R.id.et_dog_name);
        EditText etDogGender = firebaseActivity.findViewById(R.id.et_dog_gender);
        EditText etDogAge = firebaseActivity.findViewById(R.id.et_dog_age);
        EditText etDogDescription = firebaseActivity.findViewById(R.id.et_dog_description);
        EditText etDogSize = firebaseActivity.findViewById(R.id.et_dog_size);
        EditText etDogWeight = firebaseActivity.findViewById(R.id.et_dog_weight);
        EditText etDogLocation = firebaseActivity.findViewById(R.id.et_dog_location);
        EditText etDogAttitudePeople = firebaseActivity.findViewById(R.id.et_dog_attitude_people);
        EditText etDogAttitudeDogs = firebaseActivity.findViewById(R.id.et_dog_attitude_dogs);
        EditText etDogAttitudeCats = firebaseActivity.findViewById(R.id.et_dog_attitude_cats);
        EditText etDogKeeperName = firebaseActivity.findViewById(R.id.et_dog_keeper_name);
        EditText etDogKeeperPhone = firebaseActivity.findViewById(R.id.et_dog_keeper_phone);
        EditText etDogKeeperMail = firebaseActivity.findViewById(R.id.et_dog_keeper_mail);
        EditText etDogHomelessSince = firebaseActivity.findViewById(R.id.et_dog_homeless_since);

        Switch swDogVaccinated = firebaseActivity.findViewById(R.id.sw_dog_vaccinated);
        Switch swDogDewormed = firebaseActivity.findViewById(R.id.sw_dog_dewormed);
        Switch swDogSterilized = firebaseActivity.findViewById(R.id.sw_dog_sterilized);

        assertThat(btnAddNewDog, notNullValue());
        assertThat(btnShowAllDogs, notNullValue());

        assertThat(etDogName, notNullValue());
        assertThat(etDogGender, notNullValue());
        assertThat(etDogAge, notNullValue());
        assertThat(etDogDescription, notNullValue());
        assertThat(etDogSize, notNullValue());
        assertThat(etDogWeight, notNullValue());
        assertThat(etDogLocation, notNullValue());
        assertThat(etDogAttitudePeople, notNullValue());
        assertThat(etDogAttitudeDogs, notNullValue());
        assertThat(etDogAttitudeCats, notNullValue());
        assertThat(etDogKeeperName, notNullValue());
        assertThat(etDogKeeperPhone, notNullValue());
        assertThat(etDogKeeperMail, notNullValue());
        assertThat(etDogHomelessSince, notNullValue());

        assertThat(swDogVaccinated, notNullValue());
        assertThat(swDogDewormed, notNullValue());
        assertThat(swDogSterilized, notNullValue());

    }
}
