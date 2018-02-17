package com.example.android.psiak.ui.favouriteView;

import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

import io.realm.RealmResults;

public interface FavouriteViewContract {

    interface View extends MvpView {
        void showFavouriteAnimals(RealmResults<DogFirebase> animals);
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void getAllAnimalsFromLocalRepository();
    }
}
