package com.isamrst17.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Room;
import com.isamrst17.model.Seat;
import com.isamrst17.model.Seat.Segment;
import com.isamrst17.repository.SeatRepository;

@Service
public class SeatService {

  @Autowired
  private SeatRepository repository;

  public Seat find(Long id) {
    return repository.getOne(id);
  }

  public List<Seat> findAll() {
    return repository.findAll();
  }

  public Page<Seat> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Seat save(Seat seat) {
    return repository.save(seat);
  }

  public void remove(Long id) {
    repository.delete(id);
  }


  public List<Seat> findByRoom(Room room) {
    return repository.findByRoom(room);
  }

  public List<Seat> findBySegment(Segment segment) {
    return repository.findBySegment(segment);
  }
}
