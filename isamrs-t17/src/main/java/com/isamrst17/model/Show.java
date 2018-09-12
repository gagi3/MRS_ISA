package com.isamrst17.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "show_t")
public class Show {

  public enum ShowType {
    MOVIE, PLAY
  }

  @Id
  @GeneratedValue
  //@Column(name = "show_id")
  private Long id;

  //@Column(name = "name")
  private String showName;
  //@Column(name = "desc")
  private String showDesc;

//  @Enumerated(EnumType.STRING)
  private ShowType showType;

  private String genre;
  private String director;
//  @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  @ElementCollection(targetClass=String.class)
  private Set<String> actors = new HashSet<>();
  private Integer length;

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

  public ShowType getShowType() {
    return showType;
  }

  public void setShowType(ShowType showType) {
    this.showType = showType;
  }
  //  @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//  //@JoinTable(name="show_theatres", joinColumns = @JoinColumn(name="show_id"), inverseJoinColumns = @JoinColumn(name="theatre_id"))
//  private Set<Theatre> theatres = new HashSet<>();

  @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  //@JoinTable(name="show_ratings", joinColumns = @JoinColumn(name="show_id"), inverseJoinColumns = @JoinColumn(name="rating_id"))
  private Set<Rating> ratings = new HashSet<>();

  @OneToMany(mappedBy = "show", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  //@JoinTable(name="show_screenings", joinColumns = @JoinColumn(name="show_id"), inverseJoinColumns = @JoinColumn(name="screening_id"))
  private Set<Screening> screenings = new HashSet<>();

  public Show() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getShowName() {
    return showName;
  }

  public void setShowName(String showName) {
    this.showName = showName;
  }

  public String getShowDesc() {
    return showDesc;
  }

  public void setShowDesc(String showDesc) {
    this.showDesc = showDesc;
  }

//  public Set<Theatre> getTheatres() {
//    return theatres;
//  }
//
//  public void setTheatres(Set<Theatre> theatres) {
//    this.theatres = theatres;
//  }

  public Set<Rating> getRatings() {
    return ratings;
  }

  public void setRatings(Set<Rating> ratings) {
    this.ratings = ratings;
  }

  public Set<Screening> getScreenings() {
    return screenings;
  }

  public void setScreenings(Set<Screening> screenings) {
    this.screenings = screenings;
  }
}

