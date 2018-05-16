package com.isamrst17.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Ticket;
import com.isamrst17.model.Ticket.Type;
import com.isamrst17.repository.TicketRepository;

@Service
public class TicketService {

  @Autowired
  private TicketRepository repository;

  public Ticket findOne(Long id) {
    return repository.getOne(id);
  }

  public List<Ticket> findAll() {
    return repository.findAll();
  }

  public Page<Ticket> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Ticket save(Ticket ticket) {
    return repository.save(ticket);
  }

  public void remove(Long id) {
    repository.deleteById(id);
  }

  List<Ticket> findByPrice(Double price) {
    return repository.findByPrice(price);
  }

  List<Ticket> findByIssueDate(Date issueDate) {
    return repository.findByIssueDate(issueDate);
  }

  List<Ticket> findByType(Type type) {
    return repository.findByType(type);
  }

  List<Ticket> findByScreening(Screening screening) {
    return repository.findByScreening(screening);
  }

}
