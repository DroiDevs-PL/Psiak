package com.example.android.psiak.data.network;

import com.example.android.psiak.model.AnimalType;
import com.example.android.psiak.model.DogFirebase;

import java.util.ArrayList;

import io.realm.RealmResults;

public interface Repository {

    interface Firebase<Type> {

        /**
         * Generate unique ID for object that will be stored in database
         * @return Unique ID
         */

        String generateUniqueID();

        /**
         * Set object for callback methods
         * @param dataListner Object that will listen about data change in repository.
         *                    Object must implement FirebaseDataListner Interface
         */

        void setDataListner(FirebaseDataListener dataListner);

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
         * Find entity by given ID.
         *
         * @param id
         * @param callback
         */
        void getById(String id, final FirebaseDataListener callback);

        /**
         * Write single object to specified end point in database
         * @param firebaseObject Object that will be saved to Firebase database
         */

        void addNew(Type firebaseObject);

        /**
         * Update data at specified end point in Firebase database
         * @param firebaseObject Object that will override data at specified location
         */

        void update(Type firebaseObject);

        /**
         * Remove specified Dog object from Firebase database
         * @param firebaseObject Object that should be removed from database
         * @return indicate if operation was successful
         */

        void remove(Type firebaseObject);

        /**
         * Get collection of dogs that was cached after fetching from Firebase database
         * @return Dogs collection
         */

        ArrayList<Type> getCachedDogs();

        ArrayList<DogFirebase> getCachedAnimals(AnimalType animalType, String shelter_name);
         interface Identifiable {
            String getId();
            void setId(String id);
        }

    }

    interface LocalRepository {
        RealmResults<DogFirebase> getAll();
        DogFirebase get(String id);
        void add(DogFirebase dogFirebase);
        void delete(String id);
        void delete(DogFirebase dogFirebase);
        boolean checkIfEmpty(String id);
    }
}


