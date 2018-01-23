package com.example.android.psiak.data.network;

import com.example.android.psiak.model.DogFirebase;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DummyDogDataService {

    @GET("/bins/10jqvj")
    Call<List<DogFirebase>> loadDog();

}
