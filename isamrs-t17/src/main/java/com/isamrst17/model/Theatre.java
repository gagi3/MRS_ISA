package com.isamrst17.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
//@Table(name = "theatre")
public class Theatre {

  public enum TheatreType {
    CINEMA, PLAYHOUSE
  }

  @Id
  @GeneratedValue
  //@Column(name = "theatre_id")
  private Long id;

  //@Column(name = "name")
  private String theatreName;
  @OneToOne
  //@JoinTable(name = "theatre_address", joinColumns = @JoinColumn(name = "theatre_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
  private Address address;
  //@Column(name = "desc")
  private String theatreDesc;
//  @Enumerated(EnumType.STRING)
  private TheatreType theatreType;

  @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  //@JoinTable(name="screening_ratings", joinColumns = @JoinColumn(name="screening_id"), inverseJoinColumns = @JoinColumn(name="rating_id"))
  private Set<Rating> ratings = new HashSet<>();

  public TheatreType getTheatreType() {
    return theatreType;
  }

  public void setTheatreType(TheatreType theatreType) {
    this.theatreType = theatreType;
  }

  public TheatreAdmin getTheatreAdmin() {
    return theatreAdmin;
  }

  public void setTheatreAdmin(TheatreAdmin theatreAdmin) {
    this.theatreAdmin = theatreAdmin;
  }

  @ManyToOne

  private TheatreAdmin theatreAdmin;

  @OneToMany(mappedBy = "theatre", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  //@JoinTable(name = "theatre_screenings", joinColumns = @JoinColumn(name = "theatre_id"), inverseJoinColumns = @JoinColumn(name = "screening_id"))
  private Set<Screening> screenings = new HashSet<>();

  @OneToMany(mappedBy = "theatre", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  //@JoinTable(name = "theatre_rooms", joinColumns = @JoinColumn(name = "theatre_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
  private Set<Room> rooms = new HashSet<>();

//  @ManyToMany(mappedBy = "theatres")
//  //@JoinTable(name = "theatre_shows", joinColumns = @JoinColumn(name = "theatre_id"), inverseJoinColumns = @JoinColumn(name = "show_id"))
//  private Set<Show> shows = new HashSet<>();

  public Theatre() {
  }

  public Set<Rating> getRatings() {
    return ratings;
  }

  public void setRatings(Set<Rating> ratings) {
    this.ratings = ratings;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTheatreName() {
    return theatreName;
  }

  public void setTheatreName(String theatreName) {
    this.theatreName = theatreName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getTheatreDesc() {
    return theatreDesc;
  }

  public void setTheatreDesc(String theatreDesc) {
    this.theatreDesc = theatreDesc;
  }

  public Set<Screening> getScreenings() {
    return screenings;
  }

  public void setScreenings(Set<Screening> screenings) {
    this.screenings = screenings;
  }

  public Set<Room> getRooms() {
    return rooms;
  }

  public void setRooms(Set<Room> rooms) {
    this.rooms = rooms;
  }

//  public Set<Show> getShows() {
//    return shows;
//  }
//
//  public void setShows(Set<Show> shows) {
//    this.shows = shows;
//  }
}
