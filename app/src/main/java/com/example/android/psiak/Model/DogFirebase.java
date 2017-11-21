package com.example.android.psiak.Model;

import com.example.android.psiak.Utils.Const;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Hashtable;

/**
 * Created by Grzegorz on 13.11.2017.
 */

@IgnoreExtraProperties
public class DogFirebase {

    // region Public Properties

    private String id;
    private String name;
    private String gender;
    private String description;
    private String size;
    private String location;
    private String homelessSince;
    private String attitudePeople;
    private String attitudeDogs;
    private String attitudeCats;
    private String keeperName;
    private String keeperMail;
    private String keeperPhone;

    private String vaccinated;
    private String dewormed;
    private String sterilized;

    private String weight;
    private String age;

    // TODO Add properties to the constructor
    private String profilePic;
    private String photos;

    // endregion

    // region Initializers

    /**
     * Default constructor required for calls to DataSnapshot.getValue(DogFirebase.class)
     * It will set all model properties to theirs default values
     */

    private DogFirebase() {}

    /**
     * Constructor used to fully initialize dog object
     * @param dogBuilder Collection of data about the dog. Hashtable is used for thread-safety
     */

    private DogFirebase(DogBuilder dogBuilder) {

        this.id = dogBuilder.id;
        this.name = dogBuilder.name;
        this.gender = dogBuilder.gender;
        this.description = dogBuilder.description;
        this.size = dogBuilder.size;
        this.location = dogBuilder.location;
        this.homelessSince = dogBuilder.homelessSince;
        this.attitudePeople = dogBuilder.attitudePeople;
        this.attitudeDogs = dogBuilder.attitudeDogs;
        this.attitudeCats = dogBuilder.attitudeCats;
        this.keeperName = dogBuilder.keeperName;
        this.keeperMail = dogBuilder.keeperMail;
        this.keeperPhone = dogBuilder.keeperPhone;

        this.vaccinated = dogBuilder.vaccinated;
        this.dewormed = dogBuilder.dewormed;
        this.sterilized = dogBuilder.sterilized;

        this.weight = dogBuilder.weight;
        this.age = dogBuilder.age;

    }

    // endregion

    // region Getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public String getHomelessSince() {
        return homelessSince;
    }

    public String getAttitudePeople() {
        return attitudePeople;
    }

    public String getAttitudeDogs() {
        return attitudeDogs;
    }

    public String getAttitudeCats() {
        return attitudeCats;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public String getKeeperMail() {
        return keeperMail;
    }

    public String getKeeperPhone() {
        return keeperPhone;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public String getDewormed() {
        return dewormed;
    }

    public String getSterilized() {
        return sterilized;
    }

    public String getWeight() {
        return weight;
    }

    public String getAge() {
        return age;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getPhotos() {
        return photos;
    }

    // end region

    public static class DogBuilder {

        // set final for required fields
        private final String id;
        private final String name;

        private String gender;
        private String description;
        private String size;
        private String location;
        private String homelessSince;
        private String attitudePeople;
        private String attitudeDogs;
        private String attitudeCats;
        private String keeperName;
        private String keeperMail;
        private String keeperPhone;

        private String vaccinated;
        private String dewormed;
        private String sterilized;

        private String weight;
        private String age;

        // TODO Add properties to the constructor
        private String profilePic;
        private String photos;

        public DogBuilder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public DogBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public DogBuilder description(String description) {
            this.description = description;
            return this;
        }

        public DogBuilder size(String size) {
            this.size = size;
            return this;
        }

        public DogBuilder location(String location) {
            this.location = location;
            return this;
        }

        public DogBuilder homelessSince(String homelessSince) {
            this.homelessSince = homelessSince;
            return this;
        }

        public DogBuilder attitudePeople(String attitudePeople) {
            this.attitudePeople = attitudePeople;
            return this;
        }

        public DogBuilder attitudeDogs(String attitudeDogs) {
            this.attitudeDogs = attitudeDogs;
            return this;
        }

        public DogBuilder attitudeCats(String attitudeCats) {
            this.attitudeCats = attitudeCats;
            return this;
        }

        public DogBuilder keeperName(String keeperName) {
            this.keeperName = keeperName;
            return this;
        }

        public DogBuilder keeperMail(String keeperMail) {
            this.keeperMail = keeperMail;
            return this;
        }


        public DogBuilder keeperPhone(String keeperPhone) {
            this.keeperPhone = keeperPhone;
            return this;
        }

        public DogBuilder vaccinated(String vaccinated) {
            this.vaccinated = vaccinated;
            return this;
        }

        public DogBuilder dewormed(String dewormed) {
            this.dewormed = dewormed;
            return this;
        }

        public DogBuilder sterilized(String sterilized) {
            this.sterilized = sterilized;
            return this;
        }

        public DogBuilder weight(String weight) {
            this.weight = weight;
            return this;
        }

        public DogBuilder age(String age) {
            this.age = age;
            return this;
        }

        public DogFirebase build() {
            return new DogFirebase(this);
        }
    }

}
