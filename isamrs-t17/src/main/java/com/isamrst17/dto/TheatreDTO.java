package com.isamrst17.dto;

import com.isamrst17.model.Theatre;

public class TheatreDTO {

  private Long id;

  private String name;
  private AddressDTO address;
  private String desc;

  public TheatreDTO() {
  }

  public TheatreDTO(Theatre theatre) {
    this.id = theatre.getId();
    this.name = theatre.getName();
    this.address = new AddressDTO(theatre.getAddress());
    this.desc = theatre.getDesc();
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

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
