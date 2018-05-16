package com.isamrst17.dto;

import com.isamrst17.model.Address;

public class AddressDTO {

  private Long id;
  private String address;
  private Integer postalCode;

  public AddressDTO() {
  }

  public AddressDTO(Address address) {
    this.id = address.getId();
    this.address = address.getAddress();
    this.postalCode = address.getPostalCode();
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

  public Integer getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Integer postalCode) {
    this.postalCode = postalCode;
  }
}
