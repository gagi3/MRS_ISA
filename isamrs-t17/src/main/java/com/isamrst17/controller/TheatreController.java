package com.isamrst17.controller;

import com.isamrst17.dto.MessageDTO;
import com.isamrst17.dto.ScreeningDTO;
import com.isamrst17.dto.ShowDTO;
import com.isamrst17.dto.TheatreDTO;
import com.isamrst17.model.Admin;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Show;
import com.isamrst17.model.Show.ShowType;
import com.isamrst17.model.Theatre;
import com.isamrst17.model.Theatre.TheatreType;
import com.isamrst17.model.TheatreAdmin;
import com.isamrst17.service.AdminService;
import com.isamrst17.service.ShowService;
import com.isamrst17.service.TheatreService;
import java.util.ArrayList;
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

  @RequestMapping(value = "/screening/{theatreID}", method = RequestMethod.GET)
  public ResponseEntity<List<ScreeningDTO>> getTheatreScreenings(@PathVariable Long theatreID){
    Theatre theatre = theatreService.find(theatreID);
    List<ScreeningDTO> screeningDTO = new ArrayList<>();
    for (Screening screening : theatre.getScreenings()) {
      screeningDTO.add(new ScreeningDTO(screening));
    }
    return new ResponseEntity<>(screeningDTO, HttpStatus.OK);
  }

}
