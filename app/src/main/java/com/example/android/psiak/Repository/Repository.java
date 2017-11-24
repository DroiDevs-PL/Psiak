package com.example.android.psiak.Repository;

import com.example.android.psiak.Model.Dog;
import com.example.android.psiak.Model.DogFirebase;

import java.util.List;

/**
 * Created by Grzegorz Kwasniewski on 22.11.2017.
 */

public interface Repository {

    interface Firebase<Type> {

        /**
         * Fetch all data from Firebase database form specified endpoint
         */

        void getAllObjects();

        /**
         * Find single Dog object based on criteria specified in queryString
         * @param queryString
         * @return Firebase object
         */

        Type find(String queryString);

        /**
         * Write single dog object to "dogs" database
         * @param firebaseObject Object that will be saved to Firebase database
         */

        void addNew(Type firebaseObject);

        /**
         * Remove specified Dog object from Firebase database
         * @param firebaseObject Object that should be removed from database
         * @return indicate if operation was successful
         */

        boolean remove(Type firebaseObject);

    }
}
