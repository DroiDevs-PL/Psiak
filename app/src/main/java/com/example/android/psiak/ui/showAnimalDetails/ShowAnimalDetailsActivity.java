package com.example.android.psiak.ui.showAnimalDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.android.psiak.R;
import com.example.android.psiak.data.network.FirebaseRepository;
import com.example.android.psiak.model.AnimalInterface;
import com.squareup.picasso.Picasso;


public class ShowAnimalDetailsActivity extends AppCompatActivity implements ShowAnimalDetailsContract.View {

  private ShowAnimalDetailsContract.Presenter<ShowAnimalDetailsContract.View> showAnimalDetailsPresenter;


  //region ui
  @BindView(R.id.tv_AnimalHeading)
  TextView tvAnimalHeading;

  @BindView(R.id.tv_Shelter)
  TextView tvShelter;

  @BindView(R.id.tv_Description)
  TextView tvDescription;

  @BindView(R.id.iv_AnimalProfile)
  ImageView animalProfileImage;
  //endregion

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_animal_details);
    ButterKnife.bind(this);

    // Init presenter
    showAnimalDetailsPresenter = new ShowAnimalDetailsPresenter(new FirebaseRepository());
    showAnimalDetailsPresenter.attachView(this);

    // Handle intents
    Intent intentThatStartedThisActivity = getIntent();

    if (intentThatStartedThisActivity.hasExtra(INTENT_EXTRA_ANIMAL_ID)) {
      String animalId = intentThatStartedThisActivity.getStringExtra(INTENT_EXTRA_ANIMAL_ID);

      // Load animal
      showAnimalDetailsPresenter.loadAnimal(animalId);
    }
  }

  @Override
  public void setAnimalDetails(AnimalInterface animal) {

    // Set texts
    this.tvAnimalHeading.setText(String.format("%s, %s", animal.getName(), animal.getAge()));
    this.tvShelter.setText("Schronisko w ...");
    this.tvDescription.setText(animal.getDescription());

    // Set profile image
    Picasso.with(getBaseContext())
        .load(animal.getProfilePic())
        .error(R.drawable.ic_doggy)
        .placeholder(R.drawable.ic_doggy)
        .resize(this.animalProfileImage.getWidth(), this.animalProfileImage.getHeight())
        .centerCrop()
        .into(animalProfileImage);
  }

  @Override
  public void showMessage(int messageId) {

  }

  @Override
  public void showErrorMessage(String errorMessage) {

  }
}
