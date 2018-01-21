package com.example.android.psiak.ui.shelters;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.psiak.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SheltersActivityFragment extends Fragment {

    public SheltersActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shelters, container, false);
    }
}
