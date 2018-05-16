package com.isamrst17.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.User;
import com.isamrst17.model.User.UserState;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
  List<User> findByUserState(UserState userState);

}
