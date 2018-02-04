package com.example.android.psiak.ui.shelters;

import com.example.android.psiak.data.network.FirebaseDataListener;
import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.model.Shelter;
import com.example.android.psiak.ui.base.BasePresenter;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

/**
 * Created by Radek on 04.02.2018.
 */

class SheltersPresenter extends BasePresenter<SheltersViewContract.View>
        implements SheltersViewContract.Presenter<SheltersViewContract.View>,
                    FirebaseDataListener<Shelter> {

    Repository.Firebase<Shelter> remoteRepository;

    public SheltersPresenter(Repository.Firebase<Shelter> remoteRepository) {
        this.remoteRepository = remoteRepository;
        this.remoteRepository.setDataListner(this);
    }

    @Override
    public void setDogsData(ArrayList<Shelter> dogsData) {
        if(isViewAttached()) {
            view.showShelters(dogsData);
        }
    }

    @Override
    public void setErrorMessage(DatabaseException databaseException) {

    }

    @Override
    public void getAllSheltersFromRemoteRepository() {
        remoteRepository.getAllObjects();
    }


    @Override
    public void attachView(SheltersViewContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        super.detachView();
        view = null;
    }
}
