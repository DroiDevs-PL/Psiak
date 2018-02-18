package com.example.android.psiak;

import android.content.Context;

import com.example.android.psiak.data.local.DogsLocalRepository;
import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.model.Dog;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.favouriteView.AnimalsFragment;
import com.example.android.psiak.ui.favouriteView.FavouritePresenter;
import com.example.android.psiak.ui.favouriteView.FavouriteViewContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.realm.RealmResults;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavouritePresenterTest {

    @Mock
    private FavouriteViewContract.View view;
    @Mock
    private Repository.LocalRepository localRepository;
    private FavouritePresenter favouritePresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        favouritePresenter = new FavouritePresenter(localRepository);
        favouritePresenter.attachView(view);
    }

    @Test
    public void show_no_animals_after_database_fetch() {
        favouritePresenter.getAllAnimalsFromLocalRepository();
        verify(view).showErrorMessage("Error");
    }

    @Test
    public void show_animals_after_database_fetch() {

        RealmResults<DogFirebase> dogsFirebase = mockRealmResults();
        when(localRepository.getAll()).thenReturn(dogsFirebase);

        favouritePresenter.getAllAnimalsFromLocalRepository();

        verify(view).showFavouriteAnimals(localRepository.getAll());
    }

    @SuppressWarnings("unchecked")
    private RealmResults<DogFirebase> mockRealmResults() {
        return mock(RealmResults.class);
    }
}
