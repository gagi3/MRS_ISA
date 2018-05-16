package com.isamrst17.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Room;
import com.isamrst17.model.Theatre;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

  List<Room> findByTheatre(Theatre theatre);

}
