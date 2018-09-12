package com.isamrst17.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue
  //@Column(name="address_id")
  private Long id;

  //@Column(name="street_number")
  private String address;

  @ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
  //@JoinTable(name="address_city", joinColumns = @JoinColumn(name="address_id"), inverseJoinColumns = @JoinColumn(name="city_id"))
  private City city;

//  @OneToOne
//  private Theatre theatre;
//
//  public Theatre getTheatre() {
//    return theatre;
//  }
//
//  public void setTheatre(Theatre theatre) {
//    this.theatre = theatre;
//  }

  public Address() {
    super();
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


  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }



}
