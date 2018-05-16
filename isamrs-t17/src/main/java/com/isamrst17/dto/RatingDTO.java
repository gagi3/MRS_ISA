package com.isamrst17.dto;

import com.isamrst17.model.Rating;
import com.isamrst17.model.Rating.Star;

public class RatingDTO {

  private Long id;
  private Star showRating;
  private Star screeningRating;
  private UserDTO user;

  public RatingDTO() {
  }

  public RatingDTO(Rating rating) {
    this.id = rating.getId();
    this.showRating = rating.getShowRating();
    this.screeningRating = rating.getScreeningRating();
    this.user = new UserDTO(rating.getUser());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Star getShowRating() {
    return showRating;
  }

  public void setShowRating(Star showRating) {
    this.showRating = showRating;
  }

  public Star getScreeningRating() {
    return screeningRating;
  }

  public void setScreeningRating(Star screeningRating) {
    this.screeningRating = screeningRating;
  }

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }
}
