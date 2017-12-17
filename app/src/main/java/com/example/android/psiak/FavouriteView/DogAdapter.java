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

    private final static String TAG = DogAdapter.class.toString();

    // region Properties

    Repository.LocalRepository localRepository;

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
                      CoordinatorLayout coordinatorLayout,
                      Repository.LocalRepository localRepository ) {
        super();
        this.context = context;
        this.linearLayoutManager = layoutManager;
        this.coordinatorLayout = coordinatorLayout;
        this.localRepository = localRepository;
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

        // TODO: This will throw an error - ID for DogFirebase object is something like -dfdererer, not 1..2..3
        //dogFirebase = localRepository.get(Integer.toString(position));

        holder.dogName.setText("Balon");
        holder.dogAge.setText("2");
    }

    @Override
    public int getItemCount() {
        return localRepository.getAll().size();
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
