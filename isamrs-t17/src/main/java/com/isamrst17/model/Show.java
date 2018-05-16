package com.isamrst17.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Show {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String desc;

  @OneToMany
  private Set<Rating> ratings = new HashSet<>();

  @OneToMany
  private Set<Screening> screenings = new HashSet<>();

  public Show() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Set<Rating> getRatings() {
    return ratings;
  }

  public void setRatings(Set<Rating> ratings) {
    this.ratings = ratings;
  }

  public Set<Screening> getScreenings() {
    return screenings;
  }

  public void setScreenings(Set<Screening> screenings) {
    this.screenings = screenings;
  }
}

