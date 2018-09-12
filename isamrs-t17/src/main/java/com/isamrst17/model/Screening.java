package com.isamrst17.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
//@Table(name = "screening")
public class Screening {

  @Id
  @GeneratedValue
  //@Column(name="screening_id")
  private Long id;

  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  //@JoinTable(name="screening_show", joinColumns = @JoinColumn(name="screening_id"), inverseJoinColumns = @JoinColumn(name="show_id"))
  private Show show;

  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  //@JoinTable(name="screening_theatre", joinColumns = @JoinColumn(name="screening_id"), inverseJoinColumns = @JoinColumn(name="theatre_id"))
  private Theatre theatre;

  //@Column(name="screening_date")
  private Date date;

  @OneToMany(mappedBy = "screening", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  //@JoinTable(name="screening_tickets", joinColumns = @JoinColumn(name="screening_id"), inverseJoinColumns = @JoinColumn(name="ticket_id"))
  private Set<Ticket> tickets = new HashSet<>();

  public Screening() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Show getShow() {
    return show;
  }

  public void setShow(Show show) {
    this.show = show;
  }

  public Theatre getTheatre() {
    return theatre;
  }

  public void setTheatre(Theatre theatre) {
    this.theatre = theatre;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Set<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
  }
}

