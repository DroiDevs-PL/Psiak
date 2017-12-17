package com.example.android.psiak.Firebase;

import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.Model.DogFirebaseFields;
import com.example.android.psiak.Repository.Repository;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmResults;
import timber.log.Timber;

//TODO Provide way of keeping track of RalmAsynTasks and closing them

public class DogsLocalRepository implements Repository.LocalRepository {

    private Realm realm;

    public DogsLocalRepository() {
        realm = Realm.getDefaultInstance();
    }


    @Override
    public RealmResults<DogFirebase> getAll() {
        RealmResults<DogFirebase> results = realm.where(DogFirebase.class).findAll();
        return results;
    }

    @Override
    public DogFirebase get(String id) {
        RealmResults<DogFirebase> results = realm.where(DogFirebase.class)
                .equalTo(DogFirebaseFields.ID, id).findAll();
        return results.get(0);
    }

    @Override
    public void add(final DogFirebase dogFirebase) {
        RealmAsyncTask realmAsyncTask = realm.executeTransactionAsync(
                (bgRealm) -> { bgRealm.insert(dogFirebase); },
                () -> { Timber.d("Saved " + dogFirebase); },
                (throwable) -> { Timber.d(throwable.toString()); }
                );
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(DogFirebase dogFirebase) {
    }

    @Override
    public void finalize() {
        realm.close();
    }
}
