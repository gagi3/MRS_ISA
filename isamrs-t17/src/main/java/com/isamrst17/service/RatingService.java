package com.isamrst17.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Rating;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.User;
import com.isamrst17.repository.RatingRepository;

@Service
public class RatingService {

  @Autowired
  private RatingRepository repository;

  public Rating findOne(Long id) {
    return repository.getOne(id);
  }

  public List<Rating> findAll() {
    return repository.findAll();
  }

  public Page<Rating> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Rating save(Rating rating) {
    return repository.save(rating);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public List<Rating> findByPublicationDate(Date publicationDate) {
    return repository.findByPublicationDate(publicationDate);
  }

  public List<Rating> findByShow(Show show) {
    return repository.findByShow(show);
  }
  public List<Rating> findByScreening(Screening screening) {
    return repository.findByScreening(screening);
  }
  public List<Rating> findByUser(User user) {
    return repository.findByUser(user);
  }
}
