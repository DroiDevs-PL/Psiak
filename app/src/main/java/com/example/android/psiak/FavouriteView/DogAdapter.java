package com.example.android.psiak.FavouriteView;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.psiak.Model.DogFirebase;
import com.example.android.psiak.R;
import com.example.android.psiak.Repository.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DogAdapter
        extends RecyclerView.Adapter<DogAdapter.DogsViewHolder> {

    // region Properties

    private final static String TAG = DogAdapter.class.toString();

    Repository.Realm databaseHelper;

    private DogFirebase dogFirebase;
    private Context context;
    private LinearLayoutManager linearLayoutManager;
    private CoordinatorLayout coordinatorLayout;

    // endregion

    // region Constructors

    /**
     * Default constructor for DogAdapter used in RecyclerView
     * @param context Context of the app
     * @param layoutManager LayoutManager used to specify how items in RecyclerView should be placed
     * @param coordinatorLayout Root layout of the view that will be displaying RecyclerView
     */

    public DogAdapter(Context context,
                      LinearLayoutManager layoutManager,
                      CoordinatorLayout coordinatorLayout) {
        super();
        this.context = context;
        this.linearLayoutManager = layoutManager;
        this.coordinatorLayout = coordinatorLayout;
    }

    // endregion

    // region Public Methods

    @Override
    public DogsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.dog_card_view, parent, false);

        return new DogsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DogsViewHolder holder, int position) {

        //dogFirebase = databaseHelper.getItemAt(position);

        holder.dogName.setText("Masło");
        holder.dogAge.setText("4");
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    // endregion

    // region Inner Class

    /**
     * Custom implementation for ViewHolder
     */

    public static class DogsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dog_card_view)
        View dogCardView;
        @BindView(R.id.dog_card_view_iv_dog_image)
        ImageView dogImage;
        @BindView(R.id.dog_card_view_tv_dog_name)
        TextView dogName;
        @BindView(R.id.dog_card_view_tv_dog_age)
        TextView dogAge;

        public DogsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    // endregion
}
