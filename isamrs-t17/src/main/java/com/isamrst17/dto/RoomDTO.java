package com.isamrst17.dto;

import com.isamrst17.model.Room;

public class RoomDTO {

  private Long id;
  private String name;
  private TheatreDTO theatre;

  public RoomDTO() {
  }

  public RoomDTO(Room room) {
    this.id = room.getId();
    this.name = room.getName();
    this.theatre = new TheatreDTO(room.getTheatre());
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

  public TheatreDTO getTheatre() {
    return theatre;
  }

  public void setTheatre(TheatreDTO theatre) {
    this.theatre = theatre;
  }
}
