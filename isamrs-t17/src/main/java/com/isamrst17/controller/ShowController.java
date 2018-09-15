package com.isamrst17.controller;

import com.isamrst17.dto.MessageDTO;
import com.isamrst17.dto.ShowDTO;
import com.isamrst17.model.Admin;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.Show.ShowType;
import com.isamrst17.model.Theatre;
import com.isamrst17.model.TheatreAdmin;
import com.isamrst17.service.AdminService;
import com.isamrst17.service.ShowService;
import com.isamrst17.service.TheatreService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/show")
public class ShowController {

  @Autowired
  public TheatreService theatreService;

  @Autowired
  public AdminService adminService;

  @Autowired
  public ShowService showService;

  @RequestMapping(value = "/movie/add/{username}", method = RequestMethod.POST)
  public ResponseEntity<MessageDTO> addMovie(@RequestBody ShowDTO showDTO, @PathVariable String username) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to add shows.");
      return new ResponseEntity<>(messageDTO, HttpStatus.UNAUTHORIZED);
    }
    Show show = new Show();
    System.out.println(showDTO);
    Show show1 = showService.find(showDTO.getId());
    if (showService.findAll().contains(show1)) {
      messageDTO.setError("Show with this ID already exists!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    } else {
      show.setShowName(showDTO.getName());
      show.setShowDesc(showDTO.getDesc());
      show.setShowType(ShowType.MOVIE);
      show.setGenre(showDTO.getGenre());
      show.setDirector(showDTO.getDirector());
      show.setActors(showDTO.getActors());
      show.setLength(showDTO.getLength());
      showService.save(show);
    }
    return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/play/add/{username}", method = RequestMethod.POST)
  public ResponseEntity<MessageDTO> addPlay(@RequestBody ShowDTO showDTO, @PathVariable String username) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to add shows.");
      return new ResponseEntity<>(messageDTO, HttpStatus.UNAUTHORIZED);
    }
    Show show = new Show();
    Show show1 = showService.find(showDTO.getId());
    if (showService.findAll().contains(show1)) {
      messageDTO.setError("Show with this ID already exists!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    } else {
      show.setShowName(showDTO.getName());
      show.setShowDesc(showDTO.getDesc());
      show.setShowType(ShowType.PLAY);
      show.setGenre(showDTO.getGenre());
      show.setDirector(showDTO.getDirector());
      show.setActors(showDTO.getActors());
      show.setLength(showDTO.getLength());
      showService.save(show);
    }
    return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/movies", method = RequestMethod.GET)
  public ResponseEntity<List<ShowDTO>> getMovies(){
    List<ShowDTO> showDTO = new ArrayList<>();
    List<Show> shows = showService.findAll();
    for (Show show : shows) {
      if (show.getShowType().equals(ShowType.MOVIE)) {
        showDTO.add(new ShowDTO(show));
      }
    }
    return new ResponseEntity<>(showDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/plays", method = RequestMethod.GET)
  public ResponseEntity<List<ShowDTO>> getPlays(){
    List<ShowDTO> showDTO = new ArrayList<>();
    List<Show> shows = showService.findAll();
    for (Show show : shows) {
      if (show.getShowType().equals(ShowType.MOVIE)) {
        showDTO.add(new ShowDTO(show));
      }
    }
    return new ResponseEntity<>(showDTO, HttpStatus.OK);
  }

}
