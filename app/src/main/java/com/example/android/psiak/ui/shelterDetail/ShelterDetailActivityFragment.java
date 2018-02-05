package com.example.android.psiak.ui.shelterDetail;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.psiak.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShelterDetailActivityFragment extends Fragment {

    public ShelterDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shelter_detail, container, false);
    }
}
