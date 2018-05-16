package com.isamrst17.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Address;
import com.isamrst17.model.City;
import com.isamrst17.repository.AddressRepository;

@Service
public class AddressService {

  @Autowired
  private AddressRepository repository;

  public Address findOne(Long id) {
    return repository.getOne(id);
  }

  public List<Address> findAll() {
    return repository.findAll();
  }

  public Page<Address> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Address save(Address address) {
    return repository.save(address);
  }

  public void remove(Long id) {
    repository.deleteById(id);
  }

  public List<Address> findByCity(City city) {
    return repository.findByCity(city);
  }

}
