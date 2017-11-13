package com.example.android.psiak.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dog implements Parcelable
{

    @SerializedName("age")
    @Expose
    private int age;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("favourite")
    @Expose
    private String favourite;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("itemName")
    @Expose
    private String itemName;
    @SerializedName("location_city")
    @Expose
    private String locationCity;
    @SerializedName("sterilized")
    @Expose
    private String sterilized;
    @SerializedName("vaccinated")
    @Expose
    private String vaccinated;
    public final static Parcelable.Creator<Dog> CREATOR = new Creator<Dog>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Dog createFromParcel(Parcel in) {
            return new Dog(in);
        }

        public Dog[] newArray(int size) {
            return (new Dog[size]);
        }

    }
            ;

    protected Dog(Parcel in) {
        this.age = ((int) in.readValue((int.class.getClassLoader())));
        this.category = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.favourite = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.itemName = ((String) in.readValue((String.class.getClassLoader())));
        this.locationCity = ((String) in.readValue((String.class.getClassLoader())));
        this.sterilized = ((String) in.readValue((String.class.getClassLoader())));
        this.vaccinated = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Dog() {
    }

    /**
     *
     * @param locationCity
     * @param itemName
     * @param category
     * @param description
     * @param age
     * @param image
     * @param gender
     * @param vaccinated
     * @param sterilized
     * @param favourite
     */
    public Dog(int age, String category, String description, String favourite, String gender, String image, String itemName, String locationCity, String sterilized, String vaccinated) {
        super();
        this.age = age;
        this.category = category;
        this.description = description;
        this.favourite = favourite;
        this.gender = gender;
        this.image = image;
        this.itemName = itemName;
        this.locationCity = locationCity;
        this.sterilized = sterilized;
        this.vaccinated = vaccinated;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getSterilized() {
        return sterilized;
    }

    public void setSterilized(String sterilized) {
        this.sterilized = sterilized;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(age);
        dest.writeValue(category);
        dest.writeValue(description);
        dest.writeValue(favourite);
        dest.writeValue(gender);
        dest.writeValue(image);
        dest.writeValue(itemName);
        dest.writeValue(locationCity);
        dest.writeValue(sterilized);
        dest.writeValue(vaccinated);
    }

    public int describeContents() {
        return 0;
    }

}