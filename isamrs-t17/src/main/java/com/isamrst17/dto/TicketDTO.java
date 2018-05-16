package com.isamrst17.dto;

import java.util.Date;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Seat;
import com.isamrst17.model.Ticket;
import com.isamrst17.model.Ticket.Type;

public class TicketDTO {

  private Long id;
  private String number;
  private Date issueDate;
  private Double price;
  private Seat seat;
  private Type type;
  private Screening screening;

  public TicketDTO() {
  }

  public TicketDTO(Ticket ticket) {
    this.id = ticket.getId();
    this.number = ticket.getNumber();
    this.issueDate = ticket.getIssueDate();
    this.price = ticket.getPrice();
    this.seat = ticket.getSeat();
    this.type = ticket.getType();
    this.screening = ticket.getScreening();
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
