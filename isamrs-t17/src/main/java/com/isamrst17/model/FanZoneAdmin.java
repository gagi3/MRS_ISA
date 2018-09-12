package com.isamrst17.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class FanZoneAdmin extends Admin {

//  @OneToMany(mappedBy = "admin", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//  private Set<Item> theatres = new HashSet<>();

  public FanZoneAdmin(String username, String password, Address address, String phoneNumber, Type type) {
    super(username, password, address, phoneNumber, type);
    this.setType(Type.FanZone);
  }

  public FanZoneAdmin() {
    this.setType(Type.FanZone);
  }

  public FanZoneAdmin(User user) {
    super(user);
    this.setType(Type.FanZone);
  }

  //  public Set<Item> getTheatres() {
//    return theatres;
//  }
//
//  public void setTheatres(Set<Item> theatres) {
//    this.theatres = theatres;
//  }
}
