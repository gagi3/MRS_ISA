package com.isamrst17.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class TheatreAdmin extends Admin {

  @OneToMany(mappedBy = "theatreAdmin", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  private Set<Theatre> theatres = new HashSet<>();

  public TheatreAdmin make(User user, Set<Theatre> theatres) {
    this.setUsername(user.getUsername());
    this.setPassword(user.getPassword());
    this.setAddress(user.getAddress());
    this.setPhoneNumber(user.getPhoneNumber());
    this.setFirstName(user.getFirstName());
    this.setLastName(user.getLastName());
    this.setId(user.getId());
    if (user.getActive() == null) {
      this.setActive(Boolean.TRUE);
    } else {
      this.setActive(user.getActive());
    }
    if (user.getLink() == null) {
      this.setLink("0x0x0");
    } else {
      this.setLink(user.getLink());
    }
    this.setLink(user.getLink());
    if (user.getTickets().isEmpty()) {
      this.setTickets(new HashSet<>());
    } else {
      this.setTickets(user.getTickets());
    }
    this.setType(Type.Theatre);
    this.setTheatres(theatres);
    return this;
  }

  public TheatreAdmin(String username, String password, Address address, String phoneNumber, Type type, Set<Theatre> theatres) {
    super(username, password, address, phoneNumber, type);
    this.setType(Type.Theatre);
    this.theatres = theatres;
  }

  public TheatreAdmin() {
    this.setType(Type.Theatre);
  }

  public TheatreAdmin(User user) {
    super(user);
    this.setType(Type.Theatre);
  }

  public Set<Theatre> getTheatres() {
    return theatres;
  }

  public void setTheatres(Set<Theatre> theatres) {
    this.theatres = theatres;
  }
}
