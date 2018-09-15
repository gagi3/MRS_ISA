package com.isamrst17.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.isamrst17.dto.UserDTO;
import com.isamrst17.model.User;
import com.isamrst17.service.UserService;

@Controller
@RequestMapping(value = "/api/profile")
public class ProfilController {

	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/profil/show/{username}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> showData(@PathVariable String username) {
		User u = userService.findByUsername(username);
		if(!userService.findAll().contains(u))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new UserDTO(u), HttpStatus.OK);
	}
	
}
