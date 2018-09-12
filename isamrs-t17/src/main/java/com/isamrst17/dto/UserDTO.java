package com.isamrst17.dto;

import com.isamrst17.model.Person;
import com.isamrst17.model.User;

public class UserDTO {

  private Long id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  

  public UserDTO() {
  }

  public UserDTO(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.firstName = ((Person) user).getFirstName();
    this.lastName = ((Person) user).getLastName();
    this.phoneNumber = user.getPassword();
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
  
  public String getPhoneNumber() {
	  return phoneNumber;
  }
  
  public void setPhoneNumber(String phoneNumber) {
	  this.phoneNumber = phoneNumber;
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