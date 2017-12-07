package com.example.android.psiak.FavouriteView;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.psiak.R;

/**
 * Created by serwis on 07.12.2017.
 */

public class AllAnimalsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_all_animals, container, false);
        return view;
    }

}
