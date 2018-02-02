package com.example.android.psiak.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by Maciej Bialorucki on 02.02.18.
 */

public class Animal {

    @Expose
    private String weight;
    @Expose
    private String location;
    @Expose
    private String globalId;
    @Expose
    private String vaccinated;
    @Expose
    private String attitudeDogs;
    @Expose
    private String attitudePeople;
    @Expose
    private String size;
    @Expose
    private String dewormed;

    private List<Photo> photos;
    @Expose
    private String id;
    @Expose
    private String keeperMail;
    @Expose
    private String homelessSince;
    @Expose
    private String description;
    @Expose
    private String name;
    @Expose
    private String age;
    @Expose
    private String gender;
    @Expose
    private String keeperPhone;
    @Expose
    private String sterilized;
    @Expose
    private String keeperName;
    @Expose
    private String attitudeCats;
    @Expose
    private String profilePic;

    AnimalType type;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getAttitudeDogs() {
        return attitudeDogs;
    }

    public void setAttitudeDogs(String attitudeDogs) {
        this.attitudeDogs = attitudeDogs;
    }

    public String getAttitudePeople() {
        return attitudePeople;
    }

    public void setAttitudePeople(String attitudePeople) {
        this.attitudePeople = attitudePeople;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDewormed() {
        return dewormed;
    }

    public void setDewormed(String dewormed) {
        this.dewormed = dewormed;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeeperMail() {
        return keeperMail;
    }

    public void setKeeperMail(String keeperMail) {
        this.keeperMail = keeperMail;
    }

    public String getHomelessSince() {
        return homelessSince;
    }

    public void setHomelessSince(String homelessSince) {
        this.homelessSince = homelessSince;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKeeperPhone() {
        return keeperPhone;
    }

    public void setKeeperPhone(String keeperPhone) {
        this.keeperPhone = keeperPhone;
    }

    public String getSterilized() {
        return sterilized;
    }

    public void setSterilized(String sterilized) {
        this.sterilized = sterilized;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    public String getAttitudeCats() {
        return attitudeCats;
    }

    public void setAttitudeCats(String attitudeCats) {
        this.attitudeCats = attitudeCats;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (weight != null ? !weight.equals(animal.weight) : animal.weight != null) return false;
        if (location != null ? !location.equals(animal.location) : animal.location != null)
            return false;
        if (globalId != null ? !globalId.equals(animal.globalId) : animal.globalId != null)
            return false;
        if (vaccinated != null ? !vaccinated.equals(animal.vaccinated) : animal.vaccinated != null)
            return false;
        if (attitudeDogs != null ? !attitudeDogs.equals(animal.attitudeDogs) : animal.attitudeDogs != null)
            return false;
        if (attitudePeople != null ? !attitudePeople.equals(animal.attitudePeople) : animal.attitudePeople != null)
            return false;
        if (size != null ? !size.equals(animal.size) : animal.size != null) return false;
        if (dewormed != null ? !dewormed.equals(animal.dewormed) : animal.dewormed != null)
            return false;
        if (photos != null ? !photos.equals(animal.photos) : animal.photos != null) return false;
        if (id != null ? !id.equals(animal.id) : animal.id != null) return false;
        if (keeperMail != null ? !keeperMail.equals(animal.keeperMail) : animal.keeperMail != null)
            return false;
        if (homelessSince != null ? !homelessSince.equals(animal.homelessSince) : animal.homelessSince != null)
            return false;
        if (description != null ? !description.equals(animal.description) : animal.description != null)
            return false;
        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
        if (age != null ? !age.equals(animal.age) : animal.age != null) return false;
        if (gender != null ? !gender.equals(animal.gender) : animal.gender != null) return false;
        if (keeperPhone != null ? !keeperPhone.equals(animal.keeperPhone) : animal.keeperPhone != null)
            return false;
        if (sterilized != null ? !sterilized.equals(animal.sterilized) : animal.sterilized != null)
            return false;
        if (keeperName != null ? !keeperName.equals(animal.keeperName) : animal.keeperName != null)
            return false;
        if (attitudeCats != null ? !attitudeCats.equals(animal.attitudeCats) : animal.attitudeCats != null)
            return false;
        if (profilePic != null ? !profilePic.equals(animal.profilePic) : animal.profilePic != null)
            return false;
        return type == animal.type;
    }

    @Override
    public int hashCode() {
        int result = weight != null ? weight.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (globalId != null ? globalId.hashCode() : 0);
        result = 31 * result + (vaccinated != null ? vaccinated.hashCode() : 0);
        result = 31 * result + (attitudeDogs != null ? attitudeDogs.hashCode() : 0);
        result = 31 * result + (attitudePeople != null ? attitudePeople.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (dewormed != null ? dewormed.hashCode() : 0);
        result = 31 * result + (photos != null ? photos.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (keeperMail != null ? keeperMail.hashCode() : 0);
        result = 31 * result + (homelessSince != null ? homelessSince.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (keeperPhone != null ? keeperPhone.hashCode() : 0);
        result = 31 * result + (sterilized != null ? sterilized.hashCode() : 0);
        result = 31 * result + (keeperName != null ? keeperName.hashCode() : 0);
        result = 31 * result + (attitudeCats != null ? attitudeCats.hashCode() : 0);
        result = 31 * result + (profilePic != null ? profilePic.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight='" + weight + '\'' +
                ", location='" + location + '\'' +
                ", globalId='" + globalId + '\'' +
                ", vaccinated='" + vaccinated + '\'' +
                ", attitudeDogs='" + attitudeDogs + '\'' +
                ", attitudePeople='" + attitudePeople + '\'' +
                ", size='" + size + '\'' +
                ", dewormed='" + dewormed + '\'' +
                ", photos=" + photos +
                ", id='" + id + '\'' +
                ", keeperMail='" + keeperMail + '\'' +
                ", homelessSince='" + homelessSince + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", keeperPhone='" + keeperPhone + '\'' +
                ", sterilized='" + sterilized + '\'' +
                ", keeperName='" + keeperName + '\'' +
                ", attitudeCats='" + attitudeCats + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", type=" + type +
                '}';
    }
}
