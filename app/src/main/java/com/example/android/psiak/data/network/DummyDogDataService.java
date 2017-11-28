package com.example.android.psiak.data.network;

import com.example.android.psiak.model.Dog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DummyDogDataService {

    @GET("/bins/lb8xx")
    Call<List<Dog>> loadDog();

}
