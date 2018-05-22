package com.isamrst17.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Room;
import com.isamrst17.model.Theatre;
import com.isamrst17.repository.RoomRepository;

@Service
public class RoomService {

  @Autowired
  private RoomRepository repository;

  public Room find(Long id) {
    return repository.getOne(id);
  }

  public List<Room> findAll() {
    return repository.findAll();
  }

  public Page<Room> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Room save(Room room) {
    return repository.save(room);
  }

  public void delete(Long id) {
    repository.delete(id);
  }

  public List<Room> findByTheatre(Theatre theatre) {
    return repository.findByTheatre(theatre);
  }


}
