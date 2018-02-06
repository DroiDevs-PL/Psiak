package com.example.android.psiak.ui.shelterDetail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.psiak.R;
import com.example.android.psiak.model.Shelter;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShelterDetailActivityFragment extends Fragment
    implements ShelterDetailContract.View{

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

    ShelterDetailPresenter presenter;

    public ShelterDetailActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shelter_detail, container, false);
        ButterKnife.bind(this, view);
        Intent intent = getActivity().getIntent();
        presenter = new ShelterDetailPresenter();
        presenter.attachView(this);
        if(intent == null) {
            return view;
        }
        final Shelter shelter = handleIntent(intent);
        loadMockLogo();

        phoneIcon.setOnClickListener(v -> {
            presenter.openDialer(shelter);
        });

        return view;
    }

    @Override
    public void showDialer(Uri phoneUri) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(phoneUri);
        if (i.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(i);
        }
    }

    @NonNull
    private Shelter handleIntent(Intent intent) {
        Shelter shelter;Bundle shelterBundle = intent.getBundleExtra(ShelterDetailActivity.EXTRA_SHELTER);
        shelter = shelterBundle.getParcelable(ShelterDetailActivity.KEY_SHELTER);
        if(shelter.getTelephoneNumber() != null && !shelter.getTelephoneNumber().isEmpty()) {
            phoneTextView.setText(shelter.getTelephoneNumber());
        } else {
            phoneTextView.setVisibility(View.GONE);
        }
        String addressString = shelter.getCity() + ", " + shelter.getStreet();
        address.setText(addressString);
        return shelter;
    }

    private void loadMockLogo() {
        InputStream bitmap=null;
        Bitmap bit=null;
        try {
            bitmap=getActivity().getAssets().open("schronisko.jpg");
            bit= BitmapFactory.decodeStream(bitmap);
            logo.setImageBitmap(bit);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bitmap!=null) {
                try {
                    bitmap.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void showMessage(int messageId) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }
}
