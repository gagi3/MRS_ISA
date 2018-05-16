package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
