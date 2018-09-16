package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isamrst17.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
}
