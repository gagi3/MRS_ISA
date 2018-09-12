package com.isamrst17.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
//@Table(name = "admin")
public abstract class Admin extends User {

  public enum Type {
    Theatre, FanZone, System
  }

  public Admin(String username, String password, Address address, String phoneNumber, Type type) {
    super(username, password, address, phoneNumber);
    this.type = type;
  }

  public Admin() {
  }

  public Admin(User user) {
    super();
  }

  //@Column(name="type")
  private Type type;

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }



}
