package com.isamrst17.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Rating {

  public enum Star {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int value;

    private Star(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  };

  @Id
  @GeneratedValue
  private Long id;

  private Star screeningRating;
  private Star showRating;

  @ManyToOne
  private User user;
  @ManyToOne
  private Screening screening;
  @ManyToOne
  private Show show;

  public Rating() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Star getScreeningRating() {
    return screeningRating;
  }

  public void setScreeningRating(Star screeningRating) {
    this.screeningRating = screeningRating;
  }

  public Star getShowRating() {
    return showRating;
  }

  public void setShowRating(Star showRating) {
    this.showRating = showRating;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Screening getScreening() {
    return screening;
  }

  public void setScreening(Screening screening) {
    this.screening = screening;
  }

  public Show getShow() {
    return show;
  }

  public void setShow(Show show) {
    this.show = show;
  }
}
