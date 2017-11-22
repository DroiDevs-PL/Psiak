package com.example.android.psiak.Repository;

import com.example.android.psiak.Model.Dog;
import com.example.android.psiak.Model.DogFirebase;

import java.util.List;

/**
 * Created by Grzegorz Kwasniewski on 22.11.2017.
 */

public interface Repository {

    interface Dogs {

        /**
         * Fetch all dogs data from Firebase database
         */

        void getAllDogs();

        /**
         * Find single Dog object based on criteria specified in queryString
         * @param queryString
         * @return Dog object
         */

        Dog findDog(String queryString);

        /**
         * Write single dog object to "dogs" database
         * @param dogFirebase Dog object that will be saved to Firebase database
         */

        void addNewDog(DogFirebase dogFirebase);

        /**
         * Remove specified Dog object from Firebase database
         * @param dogFirebase Dog object that should be removed from database
         * @return indicate if operation was successful
         */

        boolean remove(DogFirebase dogFirebase);

    }
}
