package com.example.android.psiak.ui.addAnimal;

import com.example.android.psiak.ui.base.BasePresenter;
import com.example.android.psiak.model.Dog;
import com.example.android.psiak.data.repository.Repository;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public class AddAnimalPresenter extends BasePresenter<AddAnimalContract.View> implements AddAnimalContract.Presenter {

    private Repository repository;

    //can by easily injected via Dagger
    public AddAnimalPresenter(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void save(String name, String age) {
        if (name == null || name.equals("") || age == null || age.equals("")) {
            view.showErrorMessage();
            return;
        }
        Dog dog = new Dog();
        dog.setName(name);
        dog.setAge(age);
        repository.add(dog);
        view.showSuccessMessage();
    }
}
