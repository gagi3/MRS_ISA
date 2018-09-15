package com.isamrst17.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isamrst17.dto.LoginDTO;
import com.isamrst17.dto.MessageDTO;
import com.isamrst17.dto.RegisterDTO;
import com.isamrst17.model.Address;
import com.isamrst17.model.City;
import com.isamrst17.model.User;
import com.isamrst17.security.TokenUtils;
import com.isamrst17.service.AddressService;
import com.isamrst17.service.CityService;
import com.isamrst17.service.EmailService;
import com.isamrst17.service.UserDetailsServiceImpl;
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
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	TokenUtils tokenUtils;

	@Autowired
	EmailService emailThread;
	
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	
	//Register
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
			u.setLink(UUID.randomUUID().toString());
			u.setActive(false);
			sendEmail(u.getUsername(), u.getLink());
			cityService.save(c);
			addressService.save(a);
			userService.save(u);
		}
		return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
	}
	
	private void sendEmail(String reciver, String link) {
		String header = "Confirm registration";
		String content = " Confirm registration by clicking on the link:\nhttp://localhost:8080/activate/"+ link;
		emailThread.setup(reciver, header, content);
		taskExecutor.execute(emailThread);
	}
	
	//Login
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<MessageDTO> login(@RequestBody LoginDTO loginDTO) {
	    try {
	      UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
	          loginDTO.getPassword());
	      Authentication authentication = authenticationManager.authenticate(token);
	      SecurityContextHolder.getContext().setAuthentication(authentication);

	      UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
	      User user = userService.findByUsername(details.getUsername());
	      System.out.println(user.getUsername());
	      MessageDTO m = new MessageDTO();
	      
	      if (user.getActive()) {
	    	  m.setError("User not active");
	    	  return new ResponseEntity<>(m, HttpStatus.BAD_REQUEST);
	      }

	      m.setId(user.getId());
	      m.setJwt(tokenUtils.generateToken(details));
	      m.setRola("USER");

	      System.out.println(user.getFirstName() +  user.getLastName() + user.getActive());
	      System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());

	      return new ResponseEntity<>(m, HttpStatus.OK);
	    } catch (Exception e) {
	      MessageDTO m = new MessageDTO();
	      m.setError("Wrong username/password!");
	      return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);
	    }
	  }
	
	//Activate user 
	@RequestMapping("/activate/{link}")
	public void activateUser(@PathVariable("link") String link, HttpServletResponse response) throws IOException {
		User u = userService.findByLink(link);
		if(u != null) {
			u.setActive(true);
			userService.save(u);
		}
		response.sendRedirect("/login");
	}
	
	//Login check
	@RequestMapping(value = "/login/check/{username}", method = RequestMethod.GET)
	public Boolean loginCheck(@PathVariable String username) {
		User user = userService.findByUsername(username);
		return userService.findAll().contains(user);
	}
}
