package com.isamrst17.dto;

import java.util.Date;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.Theatre;

public class ScreeningDTO {

  private Long id;
  private ShowDTO show;
  private TheatreDTO theatre;
  private Date date;

  public ScreeningDTO() {
  }

  public ScreeningDTO(Screening screening) {
    this.id = screening.getId();
    this.show = new ShowDTO(screening.getShow());
    this.theatre = new TheatreDTO(screening.getTheatre());
    this.date = screening.getDate();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ShowDTO getShow() {
    return show;
  }

  public void setShow(ShowDTO show) {
    this.show = show;
  }

  public TheatreDTO getTheatre() {
    return theatre;
  }

  public void setTheatre(TheatreDTO theatre) {
    this.theatre = theatre;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}

