package com.isamrst17.model;

import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.*;

@Entity
//@Table(name = "ticket")
public class Ticket {

  public enum Type {
    Regular, Discounted
  }

  @Id
  @GeneratedValue
  //@Column(name = "ticket_id")
  private Long id;

  private boolean sold;

  //@Column(name = "number")
  private String number;
  //@Column(name = "issue_date")
  private Date issueDate;
  //@Column(name = "price")
  private Double price;
  @OneToOne
  //@JoinTable(name = "ticket_seat", joinColumns = @JoinColumn(name = "ticket_id"), inverseJoinColumns = @JoinColumn(name = "seat_id"))
  private Seat seat;

  //@Column(name = "type")
  private Type type;

  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  //@JoinTable(name = "ticket_screening", joinColumns = @JoinColumn(name = "ticket_id"), inverseJoinColumns = @JoinColumn(name = "screening_id"))
  private Screening screening;

  public Ticket() {
  }

  public boolean isSold() {
    return sold;
  }

  public void setSold(boolean sold) {
    this.sold = sold;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Date getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(Date issueDate) {
    this.issueDate = issueDate;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public Screening getScreening() {
    return screening;
  }

  public void setScreening(Screening screening) {
    this.screening = screening;
  }
}
