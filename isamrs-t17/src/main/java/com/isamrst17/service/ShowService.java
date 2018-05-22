package com.isamrst17.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Show;
import com.isamrst17.repository.ShowRepository;

@Service
public class ShowService {

  @Autowired
  private ShowRepository repository;

  public Show find(Long id) {
    return repository.getOne(id);
  }

  public List<Show> findAll() {
    return repository.findAll();
  }

  public Page<Show> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Show save(Show show) {
    return repository.save(show);
  }

  public void remove(Long id) {
    repository.delete(id);
  }
}
