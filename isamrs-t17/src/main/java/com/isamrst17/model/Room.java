package com.isamrst17.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
//@Table(name="room")
public class Room {

  @Id
  @GeneratedValue
  //@Column(name="room_id")
  private Long id;

  //@Column(name="room_name")
  private String name;

  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  //@JoinTable(name="room_theatre", joinColumns = @JoinColumn(name="room_id"), inverseJoinColumns = @JoinColumn(name="theatre_id"))
  private Theatre theatre;

  @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
  //@JoinTable(name="room_seat", joinColumns = @JoinColumn(name="room_id"), inverseJoinColumns = @JoinColumn(name="seat_id"))
  private Set<Seat> seats = new HashSet<>();

  public Room() {
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

  public Theatre getTheatre() {
    return theatre;
  }

  public void setTheatre(Theatre theatre) {
    this.theatre = theatre;
  }

  public Set<Seat> getSeats() {
    return seats;
  }

  public void setSeats(Set<Seat> seats) {
    this.seats = seats;
  }
}