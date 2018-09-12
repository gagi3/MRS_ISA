package com.isamrst17.model;

import javax.persistence.*;

@Entity
//@Table(name = "seat")
public class Seat {

  public enum Segment {
    Regular, VIP
  }

  @Id
  @GeneratedValue
  //@seatColumn(name = "seat_id")
  private Long id;

  //@seatColumn(name = "seatRow")
  private Integer seatRow;
  //@seatColumn(name = "seatColumn")
  private Integer seatColumn;
  //@seatColumn(name = "segment")
  @Enumerated(EnumType.STRING)
  private Segment segment;

  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  //@JoinTable(name="seat_room", joinColumns = @JoinColumn(name="seat_id"), inverseJoinColumns = @JoinColumn(name="room_id"))
  private Room room;

  public Seat() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getSeatRow() {
    return seatRow;
  }

  public void setSeatRow(Integer seatRow) {
    this.seatRow = seatRow;
  }

  public Integer getSeatColumn() {
    return seatColumn;
  }

  public void setSeatColumn(Integer seatColumn) {
    this.seatColumn = seatColumn;
  }

  public Segment getSegment() {
    return segment;
  }

  public void setSegment(Segment segment) {
    this.segment = segment;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }
}
