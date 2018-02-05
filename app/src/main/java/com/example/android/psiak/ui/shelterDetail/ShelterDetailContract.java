package com.example.android.psiak.ui.shelterDetail;

import com.example.android.psiak.ui.base.MvpPresenter;
import com.example.android.psiak.ui.base.MvpView;

/**
 * Created by Radek on 05.02.2018.
 */

public interface ShelterDetailContract {

    interface View extends MvpView {
        void showAddress(String street, String city);
        void showPhone(String phone);
        void showDescription(String description);
        void showDogsList();
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V> {
        void openPhoneDialer(String phoneNumber);
        void openMapWithLocation(String location);
    }
}
