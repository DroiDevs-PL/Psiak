package com.example.android.psiak.ui.shelters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.psiak.R;
import com.example.android.psiak.data.network.FirebaseDataListener;
import com.example.android.psiak.data.network.FirebaseRepository;
import com.example.android.psiak.model.Shelter;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class SheltersActivityFragment extends Fragment implements FirebaseDataListener<Shelter> {

    @BindView(R.id.rv_shelters)
    RecyclerView recyclerView;

    private SheltersAdapter sheltersAdapter;


    public SheltersActivityFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shelters, container, false);
        ButterKnife.bind(this, view);
        FirebaseRepository<Shelter> shelterFirebaseRepository =
                new FirebaseRepository<>(FirebaseRepository.SHELTER_ENDPOINT, Shelter.class);
        shelterFirebaseRepository.setDataListner(this);
        shelterFirebaseRepository.getAllObjects();
        ArrayList<Shelter> shelters = new ArrayList<>();

        sheltersAdapter = new SheltersAdapter(shelters, getContext());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(sheltersAdapter);

        return view;
    }

    @Override
    public void setDogsData(ArrayList<Shelter> dogsData) {
        Log.d("PIES", dogsData.get(0).toString());
        sheltersAdapter.setShelters(dogsData);
        sheltersAdapter.notifyDataSetChanged();
    }

    @Override
    public void setErrorMessage(DatabaseException databaseException) {

    }
}
