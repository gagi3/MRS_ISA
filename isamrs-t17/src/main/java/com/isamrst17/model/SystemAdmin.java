package com.isamrst17.model;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class SystemAdmin extends Admin {

  public SystemAdmin(String username, String password, Address address, String phoneNumber, Type type) {
    super(username, password, address, phoneNumber, type);
    this.setType(Type.System);
  }

  public SystemAdmin() {
    this.setType(Type.System);
  }

  public SystemAdmin(User user) {
    super(user);
    this.setType(Type.System);
  }
}
