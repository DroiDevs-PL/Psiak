package com.example.android.psiak.ui.shelterDetail;

import android.net.Uri;

import com.example.android.psiak.model.Shelter;
import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

/**
 * Created by Radek on 05.02.2018.
 */

public interface ShelterDetailContract {

    interface View extends MvpView {
        void showDialer(Uri phoneUri);
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void openDialer(Shelter shelter);
    }
}
