package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
