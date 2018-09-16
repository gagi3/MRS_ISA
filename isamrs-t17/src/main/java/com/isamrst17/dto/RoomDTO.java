package com.isamrst17.dto;

import com.isamrst17.model.Room;

public class RoomDTO {

  private Long id;
  private String name;

  public RoomDTO() {
  }

  public RoomDTO(Room room) {
    this.id = room.getId();
    this.name = room.getName();
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

}
