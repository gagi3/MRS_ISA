package com.isamrst17.dto;

import com.isamrst17.model.Show;

public class ShowDTO {

  private Long id;
  private String name;
  private String desc;

  public ShowDTO() {
  }

  public ShowDTO(Show show) {
    this.id = show.getId();
    this.name = show.getName();
    this.desc = show.getDesc();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
