package com.isamrst17.dto;

import com.isamrst17.model.Rating;
import com.isamrst17.model.Rating.Star;

public class RatingDTO {

  private Long id;
//  private Integer showRating;
//  private Integer theatreRating;
  private Integer rating;

  public RatingDTO() {
  }

  public RatingDTO(Rating rating) {
    this.id = rating.getId();
//    this.showRating = rating.getRating().getValue();
//    this.theatreRating = rating.getTheatreRating().getValue();
    this.rating = rating.getRating().getValue();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  //  public Integer getShowRating() {
//    return showRating;
//  }
//
//  public void setShowRating(Integer showRating) {
//    this.showRating = showRating;
//  }
//
//  public Integer getTheatreRating() {
//    return theatreRating;
//  }
//
//  public void setTheatreRating(Integer theatreRating) {
//    this.theatreRating = theatreRating;
//  }
}
