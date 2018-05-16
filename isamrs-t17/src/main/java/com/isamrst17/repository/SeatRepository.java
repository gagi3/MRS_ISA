package com.isamrst17.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Room;
import com.isamrst17.model.Seat;
import com.isamrst17.model.Seat.Segment;

public interface SeatRepository extends JpaRepository<Seat, Long> {

  public List<Seat> findByRoom(Room room);
  public List<Seat> findBySegment(Segment segment);

}
