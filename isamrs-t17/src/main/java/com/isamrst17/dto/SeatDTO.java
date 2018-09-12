package com.isamrst17.dto;

import com.isamrst17.model.Seat;
import com.isamrst17.model.Seat.Segment;

public class SeatDTO {

  private Long id;
  private Integer row;
  private Integer column;
  private Segment segment;
  private RoomDTO room;

  public SeatDTO() {
  }

  public SeatDTO(Seat seat) {
    this.id = seat.getId();
    this.row = seat.getSeatRow();
    this.column = seat.getSeatColumn();
    this.segment = seat.getSegment();
    this.room = new RoomDTO(seat.getRoom());
  }
}

