package com.example.android.psiak.ui.shelterDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.psiak.R;
import com.example.android.psiak.model.Shelter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShelterDetailActivityFragment extends Fragment {

    @BindView(R.id.iv_shelter_logo)
    ImageView logo;
    @BindView(R.id.icon_phone)
    ImageView phoneIcon;
    @BindView(R.id.tv_phone)
    TextView phoneTextView;
    @BindView(R.id.tv_phone_label)
    TextView phoneLabel;
    @BindView(R.id.icon_map)
    ImageView mapIcon;
    @BindView(R.id.tv_address)
    TextView address;
    @BindView(R.id.tv_address_label)
    TextView addressLabel;

    public ShelterDetailActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shelter_detail, container, false);
        ButterKnife.bind(this, view);
        Intent intent = getActivity().getIntent();
        if(intent != null) {
            Bundle shelterBundle = intent.getBundleExtra(ShelterDetailActivity.EXTRA_SHELTER);
            Shelter shelter = shelterBundle.getParcelable(ShelterDetailActivity.KEY_SHELTER);
            if(shelter.getTelephoneNumber() != null && !shelter.getTelephoneNumber().isEmpty()) {
                phoneTextView.setText(shelter.getTelephoneNumber());
            } else {
                phoneTextView.setVisibility(View.GONE);
            }
            String addressString = shelter.getCity() + ", " + shelter.getStreet();
            address.setText(addressString);
        }

        return view;
    }
}
