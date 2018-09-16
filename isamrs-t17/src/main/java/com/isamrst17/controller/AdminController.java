package com.isamrst17.controller;

import com.isamrst17.dto.MessageDTO;
import com.isamrst17.model.Admin;
import com.isamrst17.model.Admin.Type;
import com.isamrst17.model.SystemAdmin;
import com.isamrst17.model.Theatre;
import com.isamrst17.model.TheatreAdmin;
import com.isamrst17.model.User;
import com.isamrst17.service.AdminService;
import com.isamrst17.service.TheatreService;
import com.isamrst17.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/admin")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @Autowired
  private UserService userService;

  @Autowired
  private TheatreService theatreService;

  @RequestMapping(value = "/login/check/{username}", method = RequestMethod.GET)
  public Boolean loginCheck(@PathVariable String username) {
    Admin admin = adminService.findByUsername(username);
    return adminService.findAll().contains(admin);
  }

  @RequestMapping(value = "/appoint-admin/{adminUsername}/{userUsername}/{theatreID}", method = RequestMethod.POST)
  public ResponseEntity<MessageDTO> appointAdmin(@PathVariable String adminUsername, @PathVariable String userUsername, @PathVariable Long theatreID) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(adminUsername);
    if (!adminService.findAll().contains(u)) {
      messageDTO.setError("Admin doesn't exist.");
      return new ResponseEntity<>(messageDTO, HttpStatus.NOT_FOUND);
    }
    if (!(u instanceof SystemAdmin)) {
      messageDTO.setError("Only system admins are allowed to appoint theatre admins.");
      return new ResponseEntity<>(messageDTO, HttpStatus.UNAUTHORIZED);
    }
    User user = userService.findByUsername(userUsername);
    if (!userService.findAll().contains(user)) {
      messageDTO.setError("User doesn't exist.");
      return new ResponseEntity<>(messageDTO, HttpStatus.NOT_FOUND);
    }
    Set<Theatre> theatres = new HashSet<>();
    Theatre theatre = theatreService.find(theatreID);
    if (!theatreService.findAll().contains(theatre)) {
      messageDTO.setError("Theatre doesn't exist.");
      return new ResponseEntity<>(messageDTO, HttpStatus.NOT_FOUND);
    }
    theatres.add(theatre);
    Admin a = new TheatreAdmin(u.getUsername(), u.getPassword(), u.getAddress(), u.getPhoneNumber(), Type.Theatre, theatres);
    adminService.save(a);
    return new ResponseEntity<>(messageDTO, HttpStatus.OK);
  }

}
