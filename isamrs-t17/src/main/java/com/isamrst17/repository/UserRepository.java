package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isamrst17.model.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUsername(String username);
  public User findByLink(String link);
}
