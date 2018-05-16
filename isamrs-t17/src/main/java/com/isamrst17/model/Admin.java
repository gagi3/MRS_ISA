package com.isamrst17.model;

import javax.persistence.Entity;


@Entity
public class Admin extends User {

  public enum Type {
    Theatre, FanZone, System
  }

  private Type type;

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }



}
