package com.example.android.psiak.AddAnimal;

import com.example.android.psiak.BasePresenter;
import com.example.android.psiak.Model.Dog;

/**
 * Created by Maciej Bialorucki on 20.11.17.
 */

public interface AddAnimalContract {

    interface View {
        void showSuccessMessage();

        void showErrorMessage();
    }

    interface Presenter {

        void save(String name, String kind);//void save(Dog dog);

    }
}
