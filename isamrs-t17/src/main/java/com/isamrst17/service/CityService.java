package com.isamrst17.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.City;
import com.isamrst17.repository.CityRepository;

@Service
public class CityService {

  @Autowired
  private CityRepository repository;

  public City find(Long id) {
    return repository.getOne(id);
  }

  public List<City> findAll() {
    return repository.findAll();
  }

  public Page<City> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public City save(City city) {
    return repository.save(city);
  }

  public void remove(Long id) {
    repository.delete(id);
  }

}
