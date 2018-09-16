package com.isamrst17.dto;

import com.isamrst17.model.Show;
import java.util.HashMap;

public class BusinessReportDTO {

  private Double sales;
  private Integer sold;
  private HashMap<ShowDTO, Double> showRatings = new HashMap<>();
  private Double theatreRating;

  public Double getSales() {
    return sales;
  }

  public void setSales(Double sales) {
    this.sales = sales;
  }

  public Integer getSold() {
    return sold;
  }

  public void setSold(Integer sold) {
    this.sold = sold;
  }

  public HashMap<ShowDTO, Double> getShowRatings() {
    return showRatings;
  }

  public void setShowRatings(HashMap<ShowDTO, Double> showRatings) {
    this.showRatings = showRatings;
  }

  public Double getTheatreRating() {
    return theatreRating;
  }

  public void setTheatreRating(Double theatreRating) {
    this.theatreRating = theatreRating;
  }
}
