package com.example.android.psiak;

import android.content.Context;

import com.example.android.psiak.data.network.FirebaseDataListener;
import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.model.AnimalType;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.main.MainActivity;
import com.example.android.psiak.ui.main.MainContract;
import com.example.android.psiak.ui.main.MainPresenter;
import com.google.firebase.database.DatabaseException;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import io.realm.RealmResults;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FirebasePresenterTest {

    private MainContract.View mockView;
    private MockFirebaseRepository mockFirebaseRepository;
    private MockLocalRepository mockLocalRepository;
    private MainPresenter mainPresenter;

    @Before
    public void init() {
        mockView = mock(MainActivity.class);
        mockFirebaseRepository = new MockFirebaseRepository();
        mockLocalRepository = new MockLocalRepository();
        mainPresenter = new MainPresenter(mockFirebaseRepository, mockLocalRepository);
        mainPresenter.attachView(mockView);
    }

    @Test
    public void show_all_dogs_after_fetch() throws Exception {
//        mainPresenter.getAllDogs();
//        verify(mockView).showAllDogs(mockFirebaseRepository.getCachedDogs());
    }

    @Test
    public void show_all_dogs_after_callback() throws Exception {
        mainPresenter.setDogsData(mockFirebaseRepository.getCachedDogs());
        verify(mockView).showAllDogs(mockFirebaseRepository.getCachedDogs());
    }

    @Test
    public void show_error_message() throws Exception {
        DatabaseException databaseException = new DatabaseException("Exception");
        mainPresenter.setErrorMessage(databaseException);
        verify(mockView).showErrorMessage(databaseException.getMessage());
    }
}


class MockFirebaseRepository implements Repository.Firebase<DogFirebase> {

    public DogFirebase dogPlaceholder;

    private FirebaseDataListener dataListener;

    private ArrayList<DogFirebase> dogs = new ArrayList<DogFirebase>();

    @Override
    public void setDataListner(FirebaseDataListener dataListner) {
        this.dataListener = dataListner;
    }

    @Override
    public void getAllObjects() {
        dataListener.setDogsData(dogs);
    }

    @Override
    public DogFirebase find(String queryString) {
        return null;
    }

    @Override
    public void getById(String id, FirebaseDataListener callback) {

    }

    @Override
    public void addNew(DogFirebase dogFirebase) {
        this.dogPlaceholder = dogFirebase;
    }

    @Override
    public void remove(DogFirebase dogFirebase) {

    }

    @Override
    public void update(DogFirebase firebaseObject) {

    }

    @Override
    public ArrayList<DogFirebase> getCachedDogs() {

        DogFirebase dogFirebase = new DogFirebase.DogBuilder("1", "Fafik").build();

        dogs.add(dogFirebase);

        return dogs;
    }

    @Override
    public ArrayList<DogFirebase> getCachedAnimals(AnimalType animalType, String shelter_name) {
        return null;
    }

    @Override
    public String generateUniqueID() {
        return null;
    }
}

class MockLocalRepository implements Repository.LocalRepository {
    @Override
    public RealmResults<DogFirebase> getAll() {
        return null;
    }

    @Override
    public DogFirebase get(String id) {
        return null;
    }

    @Override
    public void add(DogFirebase dogFirebase) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(DogFirebase dogFirebase) {

    }

    @Override
    public boolean checkIfEmpty(String id) {
        return false;
    }
}
