package com.example.android.psiak.Utils;

import com.google.gson.TypeAdapterFactory;

public abstract class AutoValueGsonFactory implements TypeAdapterFactory {

    // Static factory method to access the package
    // private generated implementation
    public static TypeAdapterFactory create() {
        return new AutoValueGson_AutoValueGsonFactory();
    }
}