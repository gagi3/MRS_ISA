package com.isamrst17.controller;

import com.isamrst17.dto.CityDTO;
import com.isamrst17.dto.MessageDTO;
import com.isamrst17.dto.ScreeningDTO;
import com.isamrst17.dto.ShowDTO;
import com.isamrst17.dto.TheatreDTO;
import com.isamrst17.model.Address;
import com.isamrst17.model.Admin;
import com.isamrst17.model.City;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.Show.ShowType;
import com.isamrst17.model.SystemAdmin;
import com.isamrst17.model.Theatre;
import com.isamrst17.model.Theatre.TheatreType;
import com.isamrst17.model.TheatreAdmin;
import com.isamrst17.service.AddressService;
import com.isamrst17.service.AdminService;
import com.isamrst17.service.CityService;
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
@RequestMapping(value = "api/theatre")
public class TheatreController {

  @Autowired
  public TheatreService theatreService;

  @Autowired
  public AdminService adminService;

  @Autowired
  public ShowService showService;

  @Autowired
  private CityService cityService;

  @Autowired
  private AddressService addressService;

  @RequestMapping(value = "/theatres", method = RequestMethod.GET)
  public ResponseEntity<List<TheatreDTO>> getAllTheatres() {
    List<Theatre> theatres = theatreService.findAll();
    List<TheatreDTO> theatreDTO = new ArrayList<>();

    for(Theatre theatre : theatres) {
      if (theatre.getTheatreType().equals(TheatreType.CINEMA)) {
        theatreDTO.add(new TheatreDTO(theatre));
        System.out.println(theatre.getTheatreName());
      }
    }

    return new ResponseEntity<>(theatreDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/playhouses", method = RequestMethod.GET)
  public ResponseEntity<List<TheatreDTO>> getAllPlayhouses() {
    List<Theatre> theatres = theatreService.findAll();
    List<TheatreDTO> theatreDTO = new ArrayList<>();

    for(Theatre theatre : theatres) {
      if (theatre.getTheatreType().equals(TheatreType.PLAYHOUSE)) {
        theatreDTO.add(new TheatreDTO(theatre));
        System.out.println(theatre.getTheatreName());
      }
    }

    return new ResponseEntity<>(theatreDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/movies/{theatreID}", method = RequestMethod.GET)
  public ResponseEntity<List<ShowDTO>> getTheatreMovies(@PathVariable Long theatreID){
    Theatre theatre = theatreService.find(theatreID);
    List<ShowDTO> showDTO = new ArrayList<>();
    for (Screening screening : theatre.getScreenings()) {
      if (screening.getShow().getShowType().equals(ShowType.MOVIE)) {
        showDTO.add(new ShowDTO(screening.getShow()));
      }
    }
    return new ResponseEntity<>(showDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/plays/{theatreID}", method = RequestMethod.GET)
  public ResponseEntity<List<ShowDTO>> getTheatrePlays(@PathVariable Long theatreID){
    Theatre theatre = theatreService.find(theatreID);
    List<ShowDTO> showDTO = new ArrayList<>();
    for (Screening screening : theatre.getScreenings()) {
      if (screening.getShow().getShowType().equals(ShowType.PLAY)) {
        showDTO.add(new ShowDTO(screening.getShow()));
      }
    }
    return new ResponseEntity<>(showDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/screenings/{theatreID}", method = RequestMethod.GET)
  public ResponseEntity<List<ScreeningDTO>> getTheatreScreenings(@PathVariable Long theatreID){
    Theatre theatre = theatreService.find(theatreID);
    List<ScreeningDTO> screeningDTO = new ArrayList<>();
    for (Screening screening : theatre.getScreenings()) {
      screeningDTO.add(new ScreeningDTO(screening));
    }
    return new ResponseEntity<>(screeningDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/theatres/add/{username}", method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<MessageDTO> addTheatre(@RequestBody TheatreDTO theatreDTO, @PathVariable String username) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof SystemAdmin)) {
      messageDTO.setError("Only system admins are allowed to add theatres.");
      return new ResponseEntity<>(messageDTO, HttpStatus.UNAUTHORIZED);
    }
    Theatre t1 = theatreService.find(theatreDTO.getId());
    if (theatreService.findAll().contains(t1)) {
      messageDTO.setError("Theatre with this ID already exists!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    } else {
      Theatre theatre = new Theatre();
      theatre.setTheatreName(theatreDTO.getName());
      theatre.setTheatreDesc(theatreDTO.getDesc());
      theatre.setTheatreType(theatreDTO.getTheatreType());
      theatre.setTheatreAdmin(null);
      theatre.setRatings(new HashSet<>());
      Address address = new Address();
      address.setAddress(theatreDTO.getAddress().getAddress());
      City city = new City();
      city.setName(theatreDTO.getAddress().getCity());
      city.getAddresses().add(address);
      address.setCity(city);
      cityService.save(city);
      addressService.save(address);
      theatre.setAddress(address);
      theatreService.save(theatre);
    }
    return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
  }

}
