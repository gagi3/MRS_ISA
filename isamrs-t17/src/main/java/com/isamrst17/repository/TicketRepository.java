package com.isamrst17.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Ticket;
import com.isamrst17.model.Ticket.Type;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

  List<Ticket> findByPrice(Double price);
  List<Ticket> findByIssueDate(Date issueDate);
  List<Ticket> findByType(Type type);
  List<Ticket> findByScreening(Screening screening);

}
