package com.isamrst17.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.Theatre;
import com.isamrst17.repository.ScreeningRepository;

@Service
public class ScreeningService {

  @Autowired
  private ScreeningRepository repository;

  public Screening findOne(Long id) {
    return repository.getOne(id);
  }

  public List<Screening> findAll() {
    return repository.findAll();
  }

  public Page<Screening> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Screening save(Screening screening) {
    return repository.save(screening);
  }

  public void remove(Long id) {
    repository.deleteById(id);
  }

  public List<Screening> findByShow(Show show) {
    return repository.findByShow(show);
  }
  public List<Screening> findByTheatre(Theatre theatre) {
    return repository.findByTheatre(theatre);
  }

}
