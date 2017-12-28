package com.example.android.psiak;

import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.ui.addAnimal.AddAnimalActivity;
import com.example.android.psiak.ui.addAnimal.AddAnimalContract;
import com.example.android.psiak.ui.addAnimal.AddAnimalPresenter;
import com.example.android.psiak.ui.main.FirebaseDataListener;
import com.example.android.psiak.model.DogFirebase;
import com.google.firebase.database.DatabaseException;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FirebasePresenterTest {

    private AddAnimalContract.View mockView;
    private MockFirebaseRepository mockFirebaseRepository;
    private AddAnimalPresenter firebasePresenter;

    @Before
    public void init() {
        mockView = mock(AddAnimalActivity.class);
        mockFirebaseRepository = new MockFirebaseRepository();
        firebasePresenter = new AddAnimalPresenter(mockFirebaseRepository);
        firebasePresenter.attachView(mockView);
    }

    @Test
    public void show_all_dogs_after_fetch() throws Exception{
        firebasePresenter.getAllDogs();
        verify(mockView).showAllDogs(mockFirebaseRepository.getCachedDogs());
    }

    @Test
    public void show_all_dogs_after_callback() throws Exception{
        firebasePresenter.setDogsData(mockFirebaseRepository.getCachedDogs());
        verify(mockView).showAllDogs(mockFirebaseRepository.getCachedDogs());
    }

    @Test
    public void add_new_dog() throws Exception {
        DogFirebase dogFirebase = new DogFirebase.DogBuilder("1", "Fafik").build();
        firebasePresenter.addNewDog(dogFirebase);

        assertNotNull(mockFirebaseRepository.dogPlaceholder);
    }

    @Test
    public void show_error_message() throws Exception {
        DatabaseException databaseException = new DatabaseException("Exception");
        firebasePresenter.setErrorMessage(databaseException);
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
    public String generateUniqueID() {
        return null;
    }
}
