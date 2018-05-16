package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Show;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

}
