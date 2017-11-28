package com.example.android.psiak.data.network;

import android.content.Context;

import com.example.android.psiak.data.network.NetworkHelper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class RetrofitHelper {

    Retrofit retrofit;

<<<<<<< develop:app/src/main/java/com/example/android/psiak/DoggieApplication.java
    /**
     * Creates RetroFit instance and fetches api data
     *
     * @return RetroFit
     */
    public Retrofit getRetrofitInstance() {
        if(retrofit != null) {
            return retrofit;
        }
        String baseUrl = "https://api.myjson.com/";
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(this.getCacheDir(),cacheSize);
        OkHttpClient okHttpClient = NetworkHelper.getBuilder(this, cache).build();
=======

    public Retrofit getRetrofitInstance(Context context) {
        //this code won't be ever called
//        if (retrofit != null) {
//            return retrofit;
//        }
        String baseUrl = "https://api.myjson.com";
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        OkHttpClient okHttpClient = NetworkHelper.buildClient(context, cache);
>>>>>>> Refactor project structure:app/src/main/java/com/example/android/psiak/data/network/RetrofitHelper.java

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
<<<<<<< develop:app/src/main/java/com/example/android/psiak/DoggieApplication.java

    @Override
    public void onCreate() {
        retrofit = null;
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
=======
>>>>>>> Refactor project structure:app/src/main/java/com/example/android/psiak/data/network/RetrofitHelper.java
}
