package com.isamrst17.service;

import java.util.Date;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.isamrst17.model.Admin;
import com.isamrst17.repository.AdminRepository;


@Component
public class AppLoader implements ApplicationRunner {

  private AdminRepository adminRepository;

  public AppLoader(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  public void run(ApplicationArguments args) throws Exception {
    if(adminRepository.findAll().size() == 0) {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      Admin admin = new Admin();
      admin.setUsername("admin");
      admin.setPassword("admin");
      admin.setRegistrationDate(new Date());

      adminRepository.save(admin);
      System.out.println("Admin added to database.");
    }
  }
}
