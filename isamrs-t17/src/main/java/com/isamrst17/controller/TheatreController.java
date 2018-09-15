package com.isamrst17.controller;

import com.isamrst17.dto.TheatreDTO;
import com.isamrst17.model.Theatre;
import com.isamrst17.model.Theatre.TheatreType;
import com.isamrst17.service.TheatreService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/theatre")
public class TheatreController {

  @Autowired
  public TheatreService theatreService;

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

}
