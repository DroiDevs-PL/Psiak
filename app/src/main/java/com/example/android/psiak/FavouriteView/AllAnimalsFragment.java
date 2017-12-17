package com.example.android.psiak.FavouriteView;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.psiak.Firebase.DogsLocalRepository;
import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.R;
import com.example.android.psiak.Repository.Repository;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class AllAnimalsFragment extends Fragment {

    // region Properties

    @BindView(R.id.favourites_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.favourites_root_layout)
    CoordinatorLayout rootLayout;

    private DogAdapter dogAdapter;
    private LinearLayoutManager layoutManager;

    private Repository.LocalRepository localRepository;


    // endregion

    // region View Lifecycle

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_all_animals, container, false);
        ButterKnife.bind(this, view);

        // TODO: Use Presenter
        localRepository = new DogsLocalRepository();
        RealmResults<DogFirebase> dogsCollection = localRepository.getAll();

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dogAdapter = new DogAdapter(getContext(), layoutManager, rootLayout, dogsCollection);

        recyclerView.setAdapter(dogAdapter);

        return view;
    }

    // endregion

}
