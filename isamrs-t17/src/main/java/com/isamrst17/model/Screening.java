package com.isamrst17.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Screening {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Show show;

  @ManyToOne
  private Theatre theatre;

  private Date date;

  @OneToMany(mappedBy = "screening", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  private Set<Rating> ratings = new HashSet<>();

  @OneToMany(mappedBy = "screening", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  private Set<Ticket> tickets = new HashSet<>();

  public Screening() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Show getShow() {
    return show;
  }

  public void setShow(Show show) {
    this.show = show;
  }

  public Theatre getTheatre() {
    return theatre;
  }

  public void setTheatre(Theatre theatre) {
    this.theatre = theatre;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Set<Rating> getRatings() {
    return ratings;
  }

  public void setRatings(Set<Rating> ratings) {
    this.ratings = ratings;
  }

  public Set<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
  }
}

