package com.isamrst17.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

  public enum UserState {
    Active, Reported, Blocked
  };

  @Id
  @GeneratedValue
  private Long id;
  private String username;
  private String password;
  private Date registrationDate;
  private UserState userState = UserState.Active;

//  @OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//  private Set<User> friends = new HashSet<>();

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public UserState getUserState() {
    return userState;
  }
  public void setUserState(UserState userState) {
    this.userState = userState;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Date getRegistrationDate() {
    return registrationDate;
  }
  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

}
