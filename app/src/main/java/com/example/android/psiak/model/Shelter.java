package com.example.android.psiak.model;

import com.example.android.psiak.data.network.Repository;

/**
 * Created by Radek on 13.01.2018.
 */

public class Shelter implements Repository.Firebase.Identifiable{

    private String id;
    private String email;
    private String name;
    private String street;
    private String zipCode;
    private String website;
    private String telephoneNumber;
    private String city;

    public Shelter() {
    }

    // region Getters

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

    public void setCity(String city) {
        this.city = city;
    }


    // endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shelter)) return false;

        Shelter shelter = (Shelter) o;

        if (getId() != null ? !getId().equals(shelter.getId()) : shelter.getId() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(shelter.getEmail()) : shelter.getEmail() != null)
            return false;
        if (getName() != null ? !getName().equals(shelter.getName()) : shelter.getName() != null)
            return false;
        if (getStreet() != null ? !getStreet().equals(shelter.getStreet()) : shelter.getStreet() != null)
            return false;
        if (getZipCode() != null ? !getZipCode().equals(shelter.getZipCode()) : shelter.getZipCode() != null)
            return false;
        if (getWebsite() != null ? !getWebsite().equals(shelter.getWebsite()) : shelter.getWebsite() != null)
            return false;
        if (getTelephoneNumber() != null ? !getTelephoneNumber().equals(shelter.getTelephoneNumber()) : shelter.getTelephoneNumber() != null)
            return false;
        return getCity() != null ? getCity().equals(shelter.getCity()) : shelter.getCity() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getZipCode() != null ? getZipCode().hashCode() : 0);
        result = 31 * result + (getWebsite() != null ? getWebsite().hashCode() : 0);
        result = 31 * result + (getTelephoneNumber() != null ? getTelephoneNumber().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        return result;
    }

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
                '}';
    }
}
