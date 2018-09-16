package com.isamrst17.service;

import java.util.List;

import com.isamrst17.model.Reservation;
import com.isamrst17.repository.ReservationRepository;

public class ReservationService {
	
		public ReservationRepository repository;
		
		public Reservation findById(Long id) {
		    return repository.getOne(id);
		}

		public List<Reservation> findAll() {
		    return repository.findAll();
		}

		public Reservation save(Reservation res) {
		    return repository.save(res);
		}

		public void delete(Long id) {
		    repository.delete(id);
		}
}
