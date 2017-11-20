package com.example.android.psiak.AddAnimal;

import com.example.android.psiak.BasePresenter;
import com.example.android.psiak.Model.Dog;
import com.example.android.psiak.Repository.Repository;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public class AddAnimalPresenter extends BasePresenter<AddAnimalContract.View> implements AddAnimalContract.Presenter {

    private Repository repository;

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
