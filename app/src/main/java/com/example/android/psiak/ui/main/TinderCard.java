package com.example.android.psiak.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.psiak.R;
import com.example.android.psiak.model.Dog;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.showAnimalDetails.ShowAnimalDetailsActivity;
import com.example.android.psiak.ui.showAnimalDetails.ShowAnimalDetailsContract;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

@Layout(R.layout.tinder_card_view)
public class TinderCard {

    public interface SwipeCallback{
        void onSwipeIn();
    }

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
    private SwipeCallback swipeCallback;

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

    public void setSwipeCallback(SwipeCallback mSwipeCallback) {
        this.swipeCallback = mSwipeCallback;
    }

    @Resolve
    private void onResolved() {
        Picasso.with(mContext)
                .load(mDogFirebase.getProfilePic())
                .error(R.drawable.dog_placeholder)
                .placeholder(R.drawable.dog_placeholder)
                .into(profileImageView);
        nameAgeTxt.setText(String.format("%s, %s", mDogFirebase.getName(), mDogFirebase.getAge()));
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
    private void onSwipeIn(){
        if(swipeCallback != null) {
            swipeCallback.onSwipeIn();
        }
    }

    @SwipeInState
    private void onSwipeInState() {
    }

    @SwipeOutState
    private void onSwipeOutState() {
    }

    @Click(R.id.profileImageView)
    private void onProfileImageClick() {
        Timber.d("ProfileImageClicked Animal ID: %s", this.mDogFirebase.getId());

        this.showAnimalDetailedView(this.mDogFirebase);
    }


    /**
     * Show activity with detailed information's about animal.
     *
     * @param dog
     */
    private void showAnimalDetailedView(DogFirebase dog)
    {
        Intent startAnimalDetailedViewActivity = new Intent(this.mContext, ShowAnimalDetailsActivity.class);
        startAnimalDetailedViewActivity.putExtra(ShowAnimalDetailsContract.View.INTENT_EXTRA_ANIMAL_ID, dog.getId());

        // Start activity
        this.mContext.startActivity(startAnimalDetailedViewActivity);
    }

    public static Point getDisplaySize(WindowManager windowManager){
        try {
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }catch (Exception e){
            e.printStackTrace();
            return new Point(0, 0);
        }
    }
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }


}