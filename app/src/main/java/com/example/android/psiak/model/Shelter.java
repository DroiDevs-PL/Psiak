package com.example.android.psiak.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.psiak.data.network.Repository;

/**
 * Created by Radek on 13.01.2018.
 */

public class Shelter implements Repository.Firebase.Identifiable, Parcelable{

    private String id;
    private String email;
    private String name;
    private String street;
    private String zipCode;
    private String website;
    private String telephoneNumber;
    private String city;
    private String about;
   // private String photo;

    public Shelter() {
    }

    // region Getters

    protected Shelter(Parcel in) {
        id = in.readString();
        email = in.readString();
        name = in.readString();
        street = in.readString();
        zipCode = in.readString();
        website = in.readString();
        telephoneNumber = in.readString();
        city = in.readString();
        about = in.readString();
    }


    public String getId() { return id; }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getWebsite() {
        return website;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getAbout() { return about; }

   // public String getPhoto() { return photo; }

    // endregion

    // region Setters

    public void setId(String id) { this.id = id; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setCity(String city) {
        this.city = city;
    }

  //  public void setPhoto(String photo) { this.photo = photo; }

    // endregion

    @Override
    public String toString() {
        return "Shelter{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", website='" + website + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", about='" + city + '\'' +
                '}';
    }

    public static final Creator<Shelter> CREATOR = new Creator<Shelter>() {
        @Override
        public Shelter createFromParcel(Parcel in) {
            return new Shelter(in);
        }

        @Override
        public Shelter[] newArray(int size) {
            return new Shelter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(email);
        dest.writeString(name);
        dest.writeString(street);
        dest.writeString(zipCode);
        dest.writeString(website);
        dest.writeString(telephoneNumber);
        dest.writeString(city);
        dest.writeString(about);
    }
}
