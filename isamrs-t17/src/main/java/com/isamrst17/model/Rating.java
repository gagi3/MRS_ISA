package com.isamrst17.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "rating")
public class Rating {

  public enum Star {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int value;

    Star(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
    public void setValue(int value) {
      this.value = value;
    }
    public Star valueOf(int value) {
      if (value == 1) {
        this.value = 1;
        return Star.ONE;
      } else if (value == 2) {
        this.value = 2;
        return Star.TWO;
      } else if (value == 3) {
        this.value = 3;
        return Star.THREE;
      } else if (value == 4) {
        this.value = 4;
        return Star.FOUR;
      } else if (value == 5) {
        this.value = 5;
        return Star.FIVE;
      } else {
        return null;
      }
    }
  };

  @Id
  @GeneratedValue
  //@Column(name="rating_id")
  private Long id;

  private Star rating;

//  //@Column(name="theatre_rating")
//  private Star theatreRating;
//  //@Column(name="show_rating")
//  private Star showRating;

  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  //@JoinTable(name="rating_user", joinColumns = @JoinColumn(name="rating_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
  private User user;
//  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//  //@JoinTable(name="rating_theatre", joinColumns = @JoinColumn(name="rating_id"), inverseJoinColumns = @JoinColumn(name="theatre_id"))
//  private Theatre theatre;
//  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//  //@JoinTable(name="rating_show", joinColumns = @JoinColumn(name="rating_id"), inverseJoinColumns = @JoinColumn(name="show_id"))
//  private Show show;

  public Rating() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

//  public Star getTheatreRating() {
//    return theatreRating;
//  }
//
//  public void setTheatreRating(Star theatreRating) {
//    this.theatreRating = theatreRating;
//  }
//
//  public Star getShowRating() {
//    return showRating;
//  }
//
//  public void setShowRating(Star showRating) {
//    this.showRating = showRating;
//  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

//  public Theatre getTheatre() {
//    return theatre;
//  }
//
//  public void setTheatre(Theatre theatre) {
//    this.theatre = theatre;
//  }
//
//  public Show getShow() {
//    return show;
//  }
//
//  public void setShow(Show show) {
//    this.show = show;
//  }


  public Star getRating() {
    return rating;
  }

  public void setRating(Star rating) {
    this.rating = rating;
  }
}
