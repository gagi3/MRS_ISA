package com.isamrst17.dto;

import java.util.Date;
import com.isamrst17.model.Person;
import com.isamrst17.model.User;

public class UserDTO {

  private Long id;
  private String username;
  private String password;
  private Date registrationDate;
  private String firstName;
  private String lastName;

  public UserDTO() {
  }

  public UserDTO(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.registrationDate = user.getRegistrationDate();
    this.firstName = ((Person) user).getFirstName();
    this.lastName = ((Person) user).getLastName();
  }

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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}