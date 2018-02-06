package com.example.android.psiak.ui.shelters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.psiak.R;
import com.example.android.psiak.data.network.FirebaseRepository;
import com.example.android.psiak.data.network.Repository;
import com.example.android.psiak.model.Shelter;
import com.example.android.psiak.ui.shelterDetail.ShelterDetailActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class SheltersActivityFragment extends Fragment
        implements SheltersViewContract.View{

    // region Properties

    @BindView(R.id.rv_shelters)
    RecyclerView recyclerView;

    /**
     * Presenter for this view
     */

    private SheltersViewContract.Presenter<SheltersViewContract.View> sheltersPresenter;

    private SheltersAdapter sheltersAdapter;


    public SheltersActivityFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shelters, container, false);
        ButterKnife.bind(this, view);
        Repository.Firebase<Shelter> shelterFirebase = new FirebaseRepository<>(FirebaseRepository.SHELTER_ENDPOINT, Shelter.class);
        sheltersPresenter = new SheltersPresenter(shelterFirebase);
        sheltersPresenter.attachView(this);

        ArrayList<Shelter> shelters = new ArrayList<>();
        sheltersAdapter = new SheltersAdapter(shelters, s -> sheltersPresenter.openShelterDetails(s));
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(sheltersAdapter);
        sheltersPresenter.getAllSheltersFromRemoteRepository();
        return view;
    }

    @Override
    public void showShelters(ArrayList<Shelter> dogsData) {
        Log.d("PIES", dogsData.get(0).toString());
        sheltersAdapter.setShelters(dogsData);
        sheltersAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSheltersDetailsUi(Shelter shelter) {
        Intent intent = new Intent(getContext(), ShelterDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ShelterDetailActivity.KEY_SHELTER, shelter);
        intent.putExtra(ShelterDetailActivity.EXTRA_SHELTER, bundle);
        startActivity(intent);
    }


    @Override
    public void showMessage(int messageId) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sheltersPresenter.detachView();
    }

    public interface ShelterItemListener {
        void onTaskClick(Shelter clickedShelter);
    }
}
