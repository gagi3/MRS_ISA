package com.isamrst17.dto;

import com.isamrst17.model.Rating;
import com.isamrst17.model.Theatre;
import com.isamrst17.model.Theatre.TheatreType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TheatreDTO {

  private Long id;

  private String name;
  private AddressDTO address;
  private String desc;
  private TheatreType theatreType;
  private Double rating;

  public TheatreType getTheatreType() {
    return theatreType;
  }

  public void setTheatreType(TheatreType theatreType) {
    this.theatreType = theatreType;
  }

  public TheatreDTO() {
  }

  public Double avg(Set<Rating> ratings) {
    Double sum = 0.0;
    for (Rating rating : ratings) {
      sum += rating.getRating().getValue();
    }
    return sum/ratings.size();
  }
  public TheatreDTO(Theatre theatre) {
    this.id = theatre.getId();
    this.name = theatre.getTheatreName();
    this.address = new AddressDTO(theatre.getAddress());
    this.desc = theatre.getTheatreDesc();
    this.theatreType = theatre.getTheatreType();
    this.rating = avg(theatre.getRatings());
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
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

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
