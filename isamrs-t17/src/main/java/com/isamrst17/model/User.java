package com.isamrst17.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
//@Table(name = "user")
public class User extends Person {

  @Id
  @GeneratedValue
  //@Column(name = "user_id")
  private Long id;
  //@Column(name = "username")
  private String username;
  //@Column(name = "password")
  private String password;
  @OneToOne
  private Address address;
  //@Column(name = "phoneNumber")
  private String phoneNumber;
  private Boolean active;
  @OneToMany
  private Set<Ticket> tickets = new HashSet<>();
  

  public User(String username, String password, Address address, String phoneNumber) {
    this.username = username;
    this.password = password;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }


  public User() {
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  //  @OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//  private Set<User> friends = new HashSet<>();

  public Set<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
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


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


}
