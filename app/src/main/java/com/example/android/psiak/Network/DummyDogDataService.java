package com.example.android.psiak.Network;

import com.example.android.psiak.Model.Dog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Radek on 15.11.2017.
 */

public interface DummyDogDataService {

    @GET("/bins/clzq7fsdfs")
    Call<List<Dog>> loadDog();

}
