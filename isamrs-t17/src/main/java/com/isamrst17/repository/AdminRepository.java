package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
