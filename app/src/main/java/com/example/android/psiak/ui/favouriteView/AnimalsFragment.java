package com.example.android.psiak.ui.favouriteView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.psiak.R;
import com.example.android.psiak.data.local.DogsLocalRepository;
import com.example.android.psiak.model.DogFirebase;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class AnimalsFragment
        extends Fragment
        implements FavouriteViewContract.View  {

    // region Properties

    @BindView(R.id.favourites_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.favourites_root_layout)
    CoordinatorLayout rootLayout;

    /**
     * Presenter for this view
     */

    private FavouriteViewContract.Presenter<FavouriteViewContract.View> favouritePresenter;

    private DogAdapter dogAdapter;
    private GridLayoutManager layoutManager;




    // endregion

    // region View Lifecycle

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_all_animals, container, false);
        ButterKnife.bind(this, view);

        // TODO: Dependency Injection
        favouritePresenter = new FavouritePresenter(new DogsLocalRepository(getContext()));
        favouritePresenter.attachView(this);
        RealmResults<DogFirebase> dogsCollection = favouritePresenter.getAllDogsFromLocalRepository();

        Bundle bundle = getArguments();
        if(bundle != null){
            String animalType = bundle.getString("animalsToShow");
            dogsCollection = dogsCollection.where().contains("type",animalType).findAll();

        }
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dogAdapter = new DogAdapter(getContext(), layoutManager, rootLayout, dogsCollection);

        recyclerView.setAdapter(dogAdapter);

        return view;
    }

    // endregion

    // region Public Methods

    @Override
    public void showMessage(int messageId) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    // endregion
}
