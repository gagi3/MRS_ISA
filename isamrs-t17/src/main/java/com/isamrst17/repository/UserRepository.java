package com.isamrst17.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.User;
import com.isamrst17.model.User.UserState;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUsername(String username);
  public List<User> findByUserState(UserState userState);

}
