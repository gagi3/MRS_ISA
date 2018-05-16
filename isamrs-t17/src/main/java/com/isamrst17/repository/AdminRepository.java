package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
