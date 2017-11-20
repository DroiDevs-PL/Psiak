package com.example.android.psiak.AddAnimal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.psiak.R;

import butterknife.BindView;

public class AddAnimalActivity extends AppCompatActivity implements AddAnimalContract.AddAnimalView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
    }

    @Override
    public void showSuccessMessage() {

    }

    @Override
    public void showErrorMessage() {

    }
}
