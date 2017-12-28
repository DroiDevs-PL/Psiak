package com.example.android.psiak.model;

import java.util.List;

/**
 * Created by Sebastian Kaluzny on 28.12.17.
 */

public interface AnimalInterface {
  public String getId();

  public String getName();

  public String getGender();

  public String getDescription();

  public String getSize();

  public String getLocation();

  public String getHomelessSince();

  public String getAttitudePeople();

  public String getAttitudeDogs();

  public String getAttitudeCats();

  public String getKeeperName();

  public String getKeeperMail();

  public String getKeeperPhone();

  public Boolean getVaccinated();

  public Boolean getDewormed();

  public Boolean getSterilized();

  public String getWeight();

  public String getAge();

  public String getProfilePic();

  public List<String> getPhotos();
}
