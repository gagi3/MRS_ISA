package com.isamrst17.dto;

import java.util.Date;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Seat;
import com.isamrst17.model.Ticket;
import com.isamrst17.model.Ticket.Type;

public class TicketDTO {

  private Long id;
  private String showName;
  private String number;
  private Date issueDate;
  private Double price;
  private SeatDTO seat;
  private Type type;
  private ScreeningDTO screening;
  private boolean sold;

  public TicketDTO() {
  }

  public TicketDTO(Ticket ticket) {
    this.id = ticket.getId();
    this.showName = ticket.getScreening().getShow().getShowName();
    this.number = ticket.getNumber();
    this.issueDate = ticket.getIssueDate();
    this.price = ticket.getPrice();
    this.seat = new SeatDTO(ticket.getSeat());
    this.type = ticket.getType();
    this.screening = new ScreeningDTO(ticket.getScreening());
    this.sold = sold;
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

  public SeatDTO getSeat() {
    return seat;
  }

  public void setSeat(SeatDTO seat) {
    this.seat = seat;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public ScreeningDTO getScreening() {
    return screening;
  }

  public void setScreening(ScreeningDTO screening) {
    this.screening = screening;
  }

  public String getShowName() {
    return showName;
  }

  public void setShowName(String showName) {
    this.showName = showName;
  }
}
