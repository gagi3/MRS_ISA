package com.isamrst17.controller;

import com.isamrst17.dto.RatingDTO;
import com.isamrst17.dto.TheatreDTO;
import com.isamrst17.dto.UserDTO;
import com.isamrst17.model.Person;
import com.isamrst17.model.Rating;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.Theatre;
import com.isamrst17.model.User;
import com.isamrst17.service.PersonService;
import com.isamrst17.service.ScreeningService;
import com.isamrst17.service.ShowService;
import com.isamrst17.service.TheatreService;
import com.isamrst17.service.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

  @Autowired
  TheatreService theatreService;

  @Autowired
  ScreeningService screeningService;

  @Autowired
  ShowService showService;

  @Autowired
  UserService userService;

  @Autowired
  PersonService personService;

  @RequestMapping(value = "/theatres", method = RequestMethod.GET)
  public ResponseEntity<List<TheatreDTO>> searchTheatres() {
    List<Theatre> theatres = theatreService.findAll();
    List<TheatreDTO> theatreDTO = new ArrayList<>();

    for(Theatre theatre : theatres) {
      theatreDTO.add(new TheatreDTO(theatre));
    }

    return new ResponseEntity<>(theatreDTO, HttpStatus.FOUND);
  }

  @RequestMapping(value = "/rate/{showID}/{screeningID}", method = RequestMethod.POST)
  public ResponseEntity<RatingDTO> rate(Principal principal, @PathVariable Long showID, @PathVariable Long screeningID, @RequestBody RatingDTO ratingDTO) {
    Show show = showService.findOne(showID);
    Screening screening = screeningService.findOne(screeningID);

    if(show == null || screening == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    User user = userService.findByUsername(principal.getName());
    Rating rating = new Rating();
    rating.setShow(show);
    rating.setUser(user);
    rating.setShowRating(ratingDTO.getShowRating());
    rating.setScreening(screening);
    rating.setScreeningRating(ratingDTO.getScreeningRating());

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<UserDTO> edit(Principal principal, @RequestBody UserDTO userDTO) {
    User user = userService.findByUsername(principal.getName());

    if(user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Person person = (Person) user;
    person.setFirstName(userDTO.getFirstName());
    person.setLastName(userDTO.getLastName());

    if(userDTO.getPassword() != null) {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      person.setPassword(encoder.encode(userDTO.getPassword()));
    }

    person = personService.save(person);
    return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
  }

}
