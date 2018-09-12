package com.isamrst17.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name = "city")
public class City {

  @Id
  @GeneratedValue
  //@Column(name="city_id")
  private Long id;

  //@Column(name="name")
  private String name;

  @OneToMany(mappedBy="city", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
  //@JoinTable(name = "city_address", joinColumns = @JoinColumn(name="city_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
  private Set<Address> addresses = new HashSet<>();

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

  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }

  public City() {
    super();
  }


}
