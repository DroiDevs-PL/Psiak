package com.example.android.psiak.ui.shelters;

import com.example.android.psiak.model.Shelter;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Created by Radek on 04.02.2018.
 */

public interface SheltersViewContract {

    interface View extends MvpView {
        public void showShelters(ArrayList<Shelter> dogsData);
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void getAllSheltersFromRemoteRepository();
    }
}
