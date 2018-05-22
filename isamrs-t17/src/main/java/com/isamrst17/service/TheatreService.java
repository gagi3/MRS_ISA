package com.isamrst17.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Theatre;
import com.isamrst17.repository.TheatreRepository;

@Service
public class TheatreService {

  @Autowired
  private TheatreRepository repository;

  public Theatre find(Long id) {
    return repository.getOne(id);
  }

  public List<Theatre> findAll() {
    return repository.findAll();
  }

  public Page<Theatre> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Theatre save(Theatre theatre) {
    return repository.save(theatre);
  }

  public void remove(Long id) {
    repository.delete(id);
  }
}
