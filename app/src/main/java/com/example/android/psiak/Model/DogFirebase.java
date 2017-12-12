package com.example.android.psiak.Model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
@IgnoreExtraProperties
public class DogFirebase implements RealmModel{

    // region Public Properties

    @PrimaryKey
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

    private Boolean vaccinated;
    private Boolean dewormed;
    private Boolean sterilized;

    private String weight;
    private String age;

    private String profilePic;
    private RealmList<Photo> photos;

    private boolean isFavourite;

    // endregion

    // region Initializers

    /**
     * Default constructor required for calls to DataSnapshot.getValue(DogFirebase.class)
     * It will set all model properties to theirs default values
     */

    public DogFirebase() {}

    /**
     * Constructor used to fully initialize Dog object
     * @param dogBuilder DogBuilder object used to create new instance of Dog object
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

        this.isFavourite = dogBuilder.isFavourite;
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

    public Boolean getVaccinated() { return vaccinated; }

    public Boolean getDewormed() {
        return dewormed;
    }

    public Boolean getSterilized() {
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

    public RealmList<Photo> getPhotos() {
        return photos;
    }

    public boolean isFavourite() { return isFavourite; }

    // endregion

    // region Setters

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    //endregion


    // region DogBuilder

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

        private Boolean vaccinated;
        private Boolean dewormed;
        private Boolean sterilized;

        private String weight;
        private String age;

        private String profilePic;
        private List<String> photos;

        private boolean isFavourite;

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

        public DogBuilder vaccinated(Boolean vaccinated) {
            this.vaccinated = vaccinated;
            return this;
        }

        public DogBuilder dewormed(Boolean dewormed) {
            this.dewormed = dewormed;
            return this;
        }

        public DogBuilder sterilized(Boolean sterilized) {
            this.sterilized = sterilized;
            return this;
        }

        public DogBuilder profilePic(String profilePic) {
            this.profilePic = profilePic;
            return this;
        }

        public DogBuilder photos(List<String> photos) {
            this.photos = photos;
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

        public DogBuilder isFavourite(boolean isFavourite) {
            this.isFavourite = isFavourite;
            return this;
        }

        public DogFirebase build() {
            return new DogFirebase(this);
        }
    }

    // endregion

    // region Equals Implementation

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DogFirebase that = (DogFirebase) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null)
            return false;
        if (homelessSince != null ? !homelessSince.equals(that.homelessSince) : that.homelessSince != null)
            return false;
        if (attitudePeople != null ? !attitudePeople.equals(that.attitudePeople) : that.attitudePeople != null)
            return false;
        if (attitudeDogs != null ? !attitudeDogs.equals(that.attitudeDogs) : that.attitudeDogs != null)
            return false;
        if (attitudeCats != null ? !attitudeCats.equals(that.attitudeCats) : that.attitudeCats != null)
            return false;
        if (keeperName != null ? !keeperName.equals(that.keeperName) : that.keeperName != null)
            return false;
        if (keeperMail != null ? !keeperMail.equals(that.keeperMail) : that.keeperMail != null)
            return false;
        if (keeperPhone != null ? !keeperPhone.equals(that.keeperPhone) : that.keeperPhone != null)
            return false;
        if (vaccinated != null ? !vaccinated.equals(that.vaccinated) : that.vaccinated != null)
            return false;
        if (dewormed != null ? !dewormed.equals(that.dewormed) : that.dewormed != null)
            return false;
        if (sterilized != null ? !sterilized.equals(that.sterilized) : that.sterilized != null)
            return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (profilePic != null ? !profilePic.equals(that.profilePic) : that.profilePic != null)
            return false;
        return photos != null ? photos.equals(that.photos) : that.photos == null;
    }

    // endregion

    // region HashCode Implementation

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (homelessSince != null ? homelessSince.hashCode() : 0);
        result = 31 * result + (attitudePeople != null ? attitudePeople.hashCode() : 0);
        result = 31 * result + (attitudeDogs != null ? attitudeDogs.hashCode() : 0);
        result = 31 * result + (attitudeCats != null ? attitudeCats.hashCode() : 0);
        result = 31 * result + (keeperName != null ? keeperName.hashCode() : 0);
        result = 31 * result + (keeperMail != null ? keeperMail.hashCode() : 0);
        result = 31 * result + (keeperPhone != null ? keeperPhone.hashCode() : 0);
        result = 31 * result + (vaccinated != null ? vaccinated.hashCode() : 0);
        result = 31 * result + (dewormed != null ? dewormed.hashCode() : 0);
        result = 31 * result + (sterilized != null ? sterilized.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (profilePic != null ? profilePic.hashCode() : 0);
        result = 31 * result + (photos != null ? photos.hashCode() : 0);
        return result;
    }

    // endregion

    // region toString Implementation

    @Override
    public String toString() {
        return "DogFirebase{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", location='" + location + '\'' +
                ", homelessSince='" + homelessSince + '\'' +
                ", attitudePeople='" + attitudePeople + '\'' +
                ", attitudeDogs='" + attitudeDogs + '\'' +
                ", attitudeCats='" + attitudeCats + '\'' +
                ", keeperName='" + keeperName + '\'' +
                ", keeperMail='" + keeperMail + '\'' +
                ", keeperPhone='" + keeperPhone + '\'' +
                ", vaccinated='" + vaccinated + '\'' +
                ", dewormed='" + dewormed + '\'' +
                ", sterilized='" + sterilized + '\'' +
                ", weight='" + weight + '\'' +
                ", age='" + age + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", photos='" + photos + '\'' +
                '}';
    }

    // endregion
}
