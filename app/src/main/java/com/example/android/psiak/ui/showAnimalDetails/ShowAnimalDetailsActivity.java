package com.example.android.psiak.ui.showAnimalDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.android.psiak.R;
import com.example.android.psiak.data.network.FirebaseRepository;
import com.example.android.psiak.data.network.dog.DogFirebaseRepository;
import com.example.android.psiak.model.DogFirebase;
import com.squareup.picasso.Picasso;


public class ShowAnimalDetailsActivity extends AppCompatActivity implements ShowAnimalDetailsContract.View {

  //region ui
  @BindView(R.id.tv_AnimalHeading)
  TextView tvAnimalHeading;
  @BindView(R.id.tv_Shelter)
  TextView tvShelter;
  @BindView(R.id.tv_Description)
  TextView tvDescription;
  @BindView(R.id.iv_AnimalProfile)
  ImageView animalProfileImage;
  @BindView(R.id.layout_ShowAnimalDetails)
  LinearLayout lShowAnimalDetails;
  @BindView(R.id.layout_AnimalLoader)
  RelativeLayout lAnimalLoader;
  //endregion

  private ShowAnimalDetailsContract.Presenter<ShowAnimalDetailsContract.View> showAnimalDetailsPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_animal_details);
    ButterKnife.bind(this);

    // Init presenter
    showAnimalDetailsPresenter = new ShowAnimalDetailsPresenter(new DogFirebaseRepository());
//    showAnimalDetailsPresenter = new ShowAnimalDetailsPresenter(new FirebaseRepository());
    showAnimalDetailsPresenter.attachView(this);

    // Handle intents
    Intent intentThatStartedThisActivity = getIntent();

    if (intentThatStartedThisActivity.hasExtra(INTENT_EXTRA_ANIMAL_ID)) {
      String animalId = intentThatStartedThisActivity.getStringExtra(INTENT_EXTRA_ANIMAL_ID);

      // Load animal
      this.showLoader();
      showAnimalDetailsPresenter.loadAnimal(animalId);
    }
  }

  @Override
  public void showLoader() {
    this.lShowAnimalDetails.setVisibility(LinearLayout.INVISIBLE);
    this.lAnimalLoader.setVisibility(RelativeLayout.VISIBLE);
  }

  @Override
  public void hideLoader() {
    this.lAnimalLoader.setVisibility(RelativeLayout.INVISIBLE);
    this.lShowAnimalDetails.setVisibility(LinearLayout.VISIBLE);
  }

  @Override
  public void setAnimalDetails(final DogFirebase animal) {
    // Set texts
    this.tvAnimalHeading.setText(String.format("%s, %s", animal.getName(), animal.getAge()));
    this.tvShelter.setText("Schronisko w ..."); // TODO: Add shelter info here
    this.tvDescription.setText(animal.getDescription());

    this.animalProfileImage.getViewTreeObserver().addOnGlobalLayoutListener(
        new OnGlobalLayoutListener() {
          @Override
          public void onGlobalLayout() {
            // Ensure we call this only once
            animalProfileImage.getViewTreeObserver()
                .removeOnGlobalLayoutListener(this);

            // Set profile image
            Picasso.with(getBaseContext())
                .load(animal.getProfilePic())
                .resize(animalProfileImage.getWidth(), animalProfileImage.getHeight())
                .centerCrop()
                .into(animalProfileImage);
          }
        }
    );
  }

  @Override
  public void showMessage(int messageId) {

  }

  @Override
  public void showErrorMessage(String errorMessage) {

  }
}
