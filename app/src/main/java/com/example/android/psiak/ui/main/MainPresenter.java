package com.example.android.psiak.ui.main;

import com.example.android.psiak.data.network.FirebaseRepository;
import com.example.android.psiak.ui.base.BasePresenter;

/**
 * Created by Maciej Bialorucki on 07.12.17.
 */

class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private final FirebaseRepository firebaseRepository;

    public MainPresenter(FirebaseRepository firebaseRepository) {
        this.firebaseRepository = firebaseRepository;
    }


    @Override
    public void getAllDogs() {

        if (isViewAttached()) {
            //TODO consider violation of MVP pattern - view shouldn't know anything about model
            view.showAllDogs(firebaseRepository.getCachedDogs());
        }
    }
}
