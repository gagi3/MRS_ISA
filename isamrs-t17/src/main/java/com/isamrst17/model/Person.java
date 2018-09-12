package com.isamrst17.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Table(name = "person")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Person {

  @Id
  @GeneratedValue
  //@Column(name = "person_id")
  private Long id;
  //@Column(name="first_name")
  private String firstName;
  //@Column(name="last_name")
  private String lastName;

  public Person() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

