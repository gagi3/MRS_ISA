package com.isamrst17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isamrst17.dto.MessageDTO;
import com.isamrst17.dto.RegisterDTO;
import com.isamrst17.model.Address;
import com.isamrst17.model.City;
import com.isamrst17.model.User;
import com.isamrst17.service.AddressService;
import com.isamrst17.service.CityService;
import com.isamrst17.service.UserService;



@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired
	AddressService addressService;

	@Autowired
	CityService cityService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<MessageDTO> register(@RequestBody RegisterDTO registerDTO) {
	    MessageDTO messageDTO = new MessageDTO();
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    User user = userService.findByUsername(registerDTO.getUsername());
	    if (user != null) {
	      messageDTO.setError("Username taken!");
	      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
	    } else {
	      User u = new User();
	      Address a = new Address();
	      a.setAddress(registerDTO.getAddress());
	      City c = new City();
	      c.setName(registerDTO.getCity());
	      u.setFirstName(registerDTO.getFirstName());
	      u.setLastName(registerDTO.getLastName());
	      u.setUsername(registerDTO.getUsername());
	      u.setPassword(encoder.encode(registerDTO.getPassword()));
	      u.setPhoneNumber(registerDTO.getPhoneNumber());
	      a.setCity(c);
	      u.setAddress(a);
	      c.getAddresses().add(a);
	      cityService.save(c);
	      addressService.save(a);
	      userService.save(u);
	    }
	    return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
	  }
}
