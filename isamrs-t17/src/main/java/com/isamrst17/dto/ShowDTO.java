package com.isamrst17.dto;

import com.isamrst17.model.Show;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ShowDTO {

  private Long id;
  private String name;
  private String desc;
  private String showType;
  private String genre;
  private String director;
  private Set<String> actors = new HashSet<>();
  private Integer length;

  public ShowDTO() {
  }

  public ShowDTO(Show show) {
    this.id = show.getId();
    this.name = show.getShowName();
    this.desc = show.getShowDesc();
    this.showType = show.getShowType().toString();
    this.genre = show.getGenre();
    this.director = show.getDirector();
    this.actors = show.getActors();
    this.length = show.getLength();
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public Set<String> getActors() {
    return actors;
  }

  public void setActors(Set<String> actors) {
    this.actors = actors;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public String getShowType() {
    return showType;
  }

  public void setShowType(String showType) {
    this.showType = showType;
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
