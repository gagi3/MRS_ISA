package com.isamrst17.model;

import javax.persistence.*;

@Entity
public class Seat {

  public enum Segment {
    Center, Front, Back, Left, Right, VIP
  };

  @Id
  @GeneratedValue
  private Long id;

  private Integer row;
  private Integer column;
  private Segment segment;

  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  private Room room;

  public Seat() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getRow() {
    return row;
  }

  public void setRow(Integer row) {
    this.row = row;
  }

  public Integer getColumn() {
    return column;
  }

  public void setColumn(Integer column) {
    this.column = column;
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
