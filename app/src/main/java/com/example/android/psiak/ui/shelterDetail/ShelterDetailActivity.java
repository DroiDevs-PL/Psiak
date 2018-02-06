package com.example.android.psiak.ui.shelterDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.android.psiak.R;
import com.example.android.psiak.model.Shelter;
import com.example.android.psiak.ui.shelters.SheltersViewContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShelterDetailActivity
            extends AppCompatActivity
            implements SheltersViewContract.View{

    public final static String EXTRA_SHELTER = "com.example.android.psiak.extra.SHELTER_DATA";
    //TODO Naming convention for keys
    public final static String KEY_SHELTER = "KEY_SHELTER";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        ButterKnife.bind(this);
    }

    @Override
    public void showMessage(int messageId) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    public void showShelters(ArrayList<Shelter> dogsData) {

    }

    @Override
    public void showSheltersDetailsUi(Shelter shelter) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
