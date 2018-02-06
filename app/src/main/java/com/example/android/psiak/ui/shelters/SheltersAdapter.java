package com.example.android.psiak.ui.shelters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.psiak.R;
import com.example.android.psiak.model.Shelter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Radek on 21.01.2018.
 */

public class  SheltersAdapter extends RecyclerView.Adapter<SheltersAdapter.SheltersViewHolder> {

    public ArrayList<Shelter> getShelters() {
        return shelters;
    }

    private ArrayList<Shelter> shelters;
    private SheltersActivityFragment.ShelterItemListener shelterItemListener;

    public void setShelters(ArrayList<Shelter> shelters) {
        this.shelters = shelters;
    }

    public SheltersAdapter(ArrayList<Shelter> shelters,
                           SheltersActivityFragment.ShelterItemListener shelterItemListener) {
        super();
        this.shelters = shelters;
        this.shelterItemListener = shelterItemListener;
    }

    @Override
    public SheltersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.shelter_list_item, parent, false);
        return new SheltersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SheltersViewHolder holder, int position) {
        Shelter shelter = shelters.get(position);
        holder.itemView.setOnClickListener(v -> shelterItemListener.onTaskClick(shelter));
        holder.shelterName.setText(shelter.getName());
        String address = shelter.getStreet();
        holder.shelterAddress.setText(address);
    }

    @Override
    public int getItemCount() {
        return shelters.size();
    }

    public static class SheltersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_shelter_name)
        TextView shelterName;

        @BindView(R.id.tv_shelter_address)
        TextView shelterAddress;

        public SheltersViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
