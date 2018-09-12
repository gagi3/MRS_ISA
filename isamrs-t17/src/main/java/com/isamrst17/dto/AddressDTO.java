package com.isamrst17.dto;

import com.isamrst17.model.Address;

public class AddressDTO {

  private Long id;
  private String address;
  private String city;

  public AddressDTO() {
  }

  public AddressDTO(Address address) {
    this.id = address.getId();
    this.address = address.getAddress();
    this.city = address.getCity().getName();
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
