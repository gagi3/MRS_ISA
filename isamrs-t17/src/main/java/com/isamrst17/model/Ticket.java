package com.isamrst17.model;

import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Ticket {

  public enum Type {
    Regular, Discounted
  }

  @Id
  @GeneratedValue
  private Long id;

  private String number;
  private Date issueDate;
  private Double price;
  @OneToOne
  private Seat seat;
  private Type type;

  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  private Screening screening;

  public Ticket() {
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