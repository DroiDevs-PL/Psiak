package com.example.android.psiak;

import android.app.Application;

import com.example.android.psiak.Network.NetworkHelper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class DoggieApplication extends Application {

    Retrofit retrofit;

    /**
     * Creates RetroFit instance and fetches api data
     *
     * @return RetroFit
     */
    public Retrofit getRetrofitInstance() {
        if(retrofit != null) {
            return retrofit;
        }
        String baseUrl = "https://api.myjson.com";
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(this.getCacheDir(),cacheSize);
        OkHttpClient okHttpClient = NetworkHelper.buildClient(this, cache);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
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
        Timber.plant(new Timber.DebugTree());
    }
}
