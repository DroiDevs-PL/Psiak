package com.example.android.psiak.ui.favouriteView;

import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

import io.realm.RealmResults;

public interface FavouriteViewContract {

    interface View extends MvpView {

    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        RealmResults<DogFirebase> getAllDogsFromLocalRepository();
    }
}
