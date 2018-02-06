package com.example.android.psiak.ui.shelterDetail;

import android.net.Uri;

import com.example.android.psiak.model.Shelter;
import com.example.android.psiak.ui.base.BasePresenter;

/**
 * Created by Radek on 05.02.2018.
 */

public class ShelterDetailPresenter extends BasePresenter<ShelterDetailContract.View>
        implements ShelterDetailContract.Presenter<ShelterDetailContract.View> {

    @Override
    public void attachView(ShelterDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if(view != null) {
            view = null;
        }
    }

    @Override
    public boolean isViewAttached() {
        return false;
    }

    @Override
    public void openDialer(Shelter shelter) {
        Uri uri =  Uri.parse("tel:" + shelter.getTelephoneNumber());
        view.showDialer(uri);
    }
}
