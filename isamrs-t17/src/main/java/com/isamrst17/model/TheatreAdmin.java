package com.isamrst17.model;

import java.util.HashSet;
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
