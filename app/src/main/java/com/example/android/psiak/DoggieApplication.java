package com.example.android.psiak;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DoggieApplication extends Application {

    Retrofit retrofit;

    public Retrofit getRetrofitInstance() {
        if(retrofit != null) {
            return retrofit;
        }
        String baseUrl = "https://api.myjson.com/";
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(this.getCacheDir(),cacheSize);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache).build();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = gsonBuilder.create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    @Override
    public void onCreate() {
        retrofit = null;
        super.onCreate();
    }
}
