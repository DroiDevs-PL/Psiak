package com.example.android.psiak.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@AutoValue public abstract class Dog{

    abstract int age();
    abstract String category();
    abstract String description();
    @Nullable abstract String favourite();
    abstract String gender();
    @Nullable abstract String image();
    abstract String itemName();
    abstract String locationCity();
    @Nullable abstract Boolean sterilized();
    @Nullable abstract Boolean vaccinated();


    public static Builder builder(){
        return new AutoValue_Dog.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder setAge(int age);
        public abstract Builder setCategory(String category);
        public abstract Builder setDescription(String description);
        public abstract Builder setFavourite(String favourite);
        public abstract Builder setGender(String gender);
        public abstract Builder setImage(String image);
        public abstract Builder setItemName(String itemName);
        public abstract Builder setLocationCity(String locationCity);
        public abstract Builder setSterilized(Boolean sterilized);
        public abstract Builder setVaccinated(Boolean vaccinated);
        public abstract Dog build();
    }

    public static TypeAdapter<Dog> typeAdapter(Gson gson){
        return new AutoValue_Dog.GsonTypeAdapter(gson);
    }

}
