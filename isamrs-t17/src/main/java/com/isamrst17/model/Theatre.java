package com.isamrst17.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Theatre {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  @OneToOne
  private Address address;
  private String desc;

  @OneToMany
  private Set<Screening> screenings = new HashSet<>();

  @OneToMany
  private Set<Room> rooms = new HashSet<>();

  @ManyToMany
  private Set<Show> shows = new HashSet<>();

  public Theatre() {
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

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
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

  public Set<Show> getShows() {
    return shows;
  }

  public void setShows(Set<Show> shows) {
    this.shows = shows;
  }
}
