package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Theatre;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

}
