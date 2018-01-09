package com.example.android.psiak.ui.showAnimalDetails;

import com.example.android.psiak.data.network.dog.DogRepositoryInterface;
import com.example.android.psiak.model.DogFirebase;
import com.example.android.psiak.ui.base.BasePresenter;
import com.example.android.psiak.ui.showAnimalDetails.ShowAnimalDetailsContract.View;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class ShowAnimalDetailsPresenter
    extends BasePresenter<View>
    implements ShowAnimalDetailsContract.Presenter<ShowAnimalDetailsContract.View> {

  private DogRepositoryInterface dogRepository;

  public ShowAnimalDetailsPresenter(DogRepositoryInterface dogRepository) {
    this.dogRepository = dogRepository;
  }

  @Override
  public void loadAnimal(String id) {
    view.showLoader();

    dogRepository.getById(id)
        .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<DogFirebase>() {
          @Override
          public void accept(DogFirebase dog) throws Exception {
            view.hideLoader();
            view.setAnimalDetails(dog);
          }
        }, new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            Timber.e(throwable);
          }
        });
  }
}
