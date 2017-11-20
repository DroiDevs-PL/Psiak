package com.example.android.psiak.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dog {

    private String weight;

    @SerializedName("location_city")
    private String location;

    private String globalId;

    private String vaccinated;

    private String attitudeDogs;

    private String attitudePeople;

    private String size;

    private String dewormed;

    private List<Photo> photos;

    private String id;

    private String keeperMail;

    private String homelessSince;

    private String description;

    private String name;

    private String age;

    private String gender;

    private String keeperPhone;

    private String sterilized;

    private String keeperName;

    private String attitudeCats;

    private String profilePic;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (weight != null ? !weight.equals(dog.weight) : dog.weight != null) return false;
        if (location != null ? !location.equals(dog.location) : dog.location != null) return false;
        if (globalId != null ? !globalId.equals(dog.globalId) : dog.globalId != null) return false;
        if (vaccinated != null ? !vaccinated.equals(dog.vaccinated) : dog.vaccinated != null)
            return false;
        if (attitudeDogs != null ? !attitudeDogs.equals(dog.attitudeDogs) : dog.attitudeDogs != null)
            return false;
        if (attitudePeople != null ? !attitudePeople.equals(dog.attitudePeople) : dog.attitudePeople != null)
            return false;
        if (size != null ? !size.equals(dog.size) : dog.size != null) return false;
        if (dewormed != null ? !dewormed.equals(dog.dewormed) : dog.dewormed != null) return false;
        if (photos != null ? !photos.equals(dog.photos) : dog.photos != null) return false;
        if (id != null ? !id.equals(dog.id) : dog.id != null) return false;
        if (keeperMail != null ? !keeperMail.equals(dog.keeperMail) : dog.keeperMail != null)
            return false;
        if (homelessSince != null ? !homelessSince.equals(dog.homelessSince) : dog.homelessSince != null)
            return false;
        if (description != null ? !description.equals(dog.description) : dog.description != null)
            return false;
        if (name != null ? !name.equals(dog.name) : dog.name != null) return false;
        if (age != null ? !age.equals(dog.age) : dog.age != null) return false;
        if (gender != null ? !gender.equals(dog.gender) : dog.gender != null) return false;
        if (keeperPhone != null ? !keeperPhone.equals(dog.keeperPhone) : dog.keeperPhone != null)
            return false;
        if (sterilized != null ? !sterilized.equals(dog.sterilized) : dog.sterilized != null)
            return false;
        if (keeperName != null ? !keeperName.equals(dog.keeperName) : dog.keeperName != null)
            return false;
        if (attitudeCats != null ? !attitudeCats.equals(dog.attitudeCats) : dog.attitudeCats != null)
            return false;
        return profilePic != null ? profilePic.equals(dog.profilePic) : dog.profilePic == null;
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
        return result;
    }

    @Override
    public String toString() {
        return "Dog{" +
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
                '}';
    }
}
