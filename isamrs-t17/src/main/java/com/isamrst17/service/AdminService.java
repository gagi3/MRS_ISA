package com.isamrst17.service;

import com.isamrst17.model.Admin;
import com.isamrst17.model.Admin.Type;
import com.isamrst17.model.FanZoneAdmin;
import com.isamrst17.model.SystemAdmin;
import com.isamrst17.model.TheatreAdmin;
import com.isamrst17.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

  @Autowired
  private AdminRepository repository;

  public Admin find(Long id) {
    if (repository.getOne(id).getType().equals(Type.Theatre)) {
      return new TheatreAdmin(repository.getOne(id));
    } else if (repository.getOne(id).getType().equals(Type.System)) {
      return new SystemAdmin(repository.getOne(id));
    } else if (repository.getOne(id).getType().equals(Type.FanZone)) {
      return new FanZoneAdmin(repository.getOne(id));
    } else {
      return repository.getOne(id);
    }
  }

  public Admin findByUsername(String username) {
    if (repository.findByUsername(username).getType().equals(Type.Theatre)) {
      return new TheatreAdmin(repository.findByUsername(username));
    } else if (repository.findByUsername(username).getType().equals(Type.System)) {
      return new SystemAdmin(repository.findByUsername(username));
    } else if (repository.findByUsername(username).getType().equals(Type.FanZone)) {
      return new FanZoneAdmin(repository.findByUsername(username));
    } else {
      return repository.findByUsername(username);
    }
  }

  public List<Admin> findAll() {
    return repository.findAll();
  }

  public Page<Admin> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Admin save(Admin user) {
    return repository.save(user);
  }

  public void remove(Long id) {
    repository.delete(id);
  }

}
