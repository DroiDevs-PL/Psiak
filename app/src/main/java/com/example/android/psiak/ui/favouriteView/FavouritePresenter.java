package com.example.android.psiak.ui.favouriteView;


import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.ui.addAnimal.AddAnimalPresenter;
import com.example.android.psiak.ui.base.BasePresenter;

class FavouritePresenter
        extends BasePresenter<FavouriteViewContract.View>
        implements FavouriteViewContract.Presenter<FavouriteViewContract.View> {

    private static final String TAG = AddAnimalPresenter.class.toString();

    /**
     * Repository object that will be used with this presenter
     */

    Repository.LocalRepository localRepository;

    // region Constructors

    /**
     * Initialize FavouritePresenter with local repository.
     * @param localRepository Repository.LocalRepository object that will be used with this Presenter
     */

    public FavouritePresenter(Repository.LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    // endregion

    // region Public Methods

    @Override
    public void getAllDogsFromLocalRepository() {

    }

    // endregion
}
