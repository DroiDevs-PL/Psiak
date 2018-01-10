package com.example.android.psiak.ui.favouriteView;

import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

public interface FavouriteViewContract {

    interface View extends MvpView {

    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void getAllDogsFromLocalRepository();
    }
}
