package com.isamrst17.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Person;
import com.isamrst17.repository.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private PersonRepository repository;

  public Person find(Long id) {
    return repository.getOne(id);
  }

  public List<Person> findAll() {
    return repository.findAll();
  }

  public Page<Person> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Person save(Person user) {
    return repository.save(user);
  }

  public void remove(Long id) {
    repository.delete(id);
  }
}
