package com.example.android.psiak.ui.main;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.psiak.R;
import com.example.android.psiak.model.Dog;
import com.example.android.psiak.model.DogFirebase;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.squareup.picasso.Picasso;

@Layout(R.layout.tinder_card_view)
public class TinderCard {

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt;

    private Dog mDog;
    private DogFirebase mDogFirebase;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;

    public TinderCard(Context context, DogFirebase dog, SwipePlaceHolderView swipeView) {
        mContext = context;
        mDogFirebase = dog;
        mSwipeView = swipeView;
    }

    public TinderCard(Context context, Dog dog, SwipePlaceHolderView swipeView) {
        mContext = context;
        mDog = dog;
        mSwipeView = swipeView;
    }

    @Resolve
    private void onResolved() {
        Picasso.with(mContext)
                .load(mDogFirebase.getProfilePic())
                .error(R.drawable.ic_doggy)
                .placeholder(R.drawable.ic_doggy)
                .into(profileImageView);
        nameAgeTxt.setText(mDogFirebase.getName() + ", " + mDogFirebase.getAge());
        locationNameTxt.setText(mDogFirebase.getLocation());
    }

    @SwipeOut
    private void onSwipedOut() {
        mSwipeView.addView(this);

    }

    @SwipeCancelState
    private void onSwipeCancelState() {
    }

    @SwipeIn
    private void onSwipeIn() {
    }

    @SwipeInState
    private void onSwipeInState() {
    }

    @SwipeOutState
    private void onSwipeOutState() {
    }

}