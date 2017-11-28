package com.example.android.psiak.ui.addAnimal;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.psiak.R;
import com.example.android.psiak.data.repository.InMemoryDogRepository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAnimalActivity extends AppCompatActivity implements AddAnimalContract.View {

    @BindView(R.id.add_dog_btn)
    Button addDog;

    @BindView(R.id.dog_name_et)
    EditText dogName;

    @BindView(R.id.dog_age_et)
    EditText dogAge;
    private AddAnimalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        ButterKnife.bind(this);

        //can be easily inject via Dagger
        this.presenter = new AddAnimalPresenter(InMemoryDogRepository.getInstance());
        presenter.attach(this);
    }

    @OnClick(R.id.add_dog_btn)
    void handleOnClickDogAdd() {
        presenter.save(dogName.getText().toString(), dogAge.getText().toString());
    }

    @Override
    public void showSuccessMessage() {
        Snackbar.make(addDog.getRootView(), "Successfully added!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessage() {
        Snackbar.make(addDog.getRootView(), "Dog name and dog age cannot be empty!", Snackbar.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.detach();
    }
}
