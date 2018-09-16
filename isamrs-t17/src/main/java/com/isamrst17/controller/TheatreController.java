package com.isamrst17.controller;

import com.isamrst17.dto.BusinessReportDTO;
import com.isamrst17.dto.CityDTO;
import com.isamrst17.dto.MessageDTO;
import com.isamrst17.dto.RoomDTO;
import com.isamrst17.dto.ScreeningDTO;
import com.isamrst17.dto.ShowDTO;
import com.isamrst17.dto.TheatreDTO;
import com.isamrst17.dto.TicketDTO;
import com.isamrst17.model.Address;
import com.isamrst17.model.Admin;
import com.isamrst17.model.City;
import com.isamrst17.model.Rating;
import com.isamrst17.model.Room;
import com.isamrst17.model.Screening;
import com.isamrst17.model.Seat;
import com.isamrst17.model.Seat.Segment;
import com.isamrst17.model.Show;
import com.isamrst17.model.Show.ShowType;
import com.isamrst17.model.SystemAdmin;
import com.isamrst17.model.Theatre;
import com.isamrst17.model.Theatre.TheatreType;
import com.isamrst17.model.TheatreAdmin;
import com.isamrst17.model.Ticket;
import com.isamrst17.model.Ticket.Type;
import com.isamrst17.model.User;
import com.isamrst17.service.AddressService;
import com.isamrst17.service.AdminService;
import com.isamrst17.service.CityService;
import com.isamrst17.service.RoomService;
import com.isamrst17.service.ScreeningService;
import com.isamrst17.service.SeatService;
import com.isamrst17.service.ShowService;
import com.isamrst17.service.TheatreService;
import com.isamrst17.service.TicketService;
import com.isamrst17.service.UserService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
  private RoomService roomService;

  @Autowired
  private SeatService seatService;

  @Autowired
  private UserService userService;

  @Autowired
  private AddressService addressService;

  @Autowired
  private ScreeningService screeningService;

  @Autowired
  private TicketService ticketService;

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

  @RequestMapping(value = "/screenings/{theatreID}/{showID}", method = RequestMethod.GET)
  public ResponseEntity<List<ScreeningDTO>> getTheatreAndShowScreenings(@PathVariable Long theatreID, @PathVariable Long showID){
    Theatre theatre = theatreService.find(theatreID);
    List<ScreeningDTO> screeningDTO = new ArrayList<>();
    for (Screening screening : theatre.getScreenings()) {
      Show show = screening.getShow();
      if (show.equals(showService.find(showID)) && showService.findAll().contains(show)) {
        screeningDTO.add(new ScreeningDTO(screening));
      }
    }
    return new ResponseEntity<>(screeningDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/screenings/add/{username}/{theatreID}/{showID}/{roomID}/{regularPrice}/{VIPPrice}", method = RequestMethod.POST)
  public ResponseEntity<MessageDTO> getTheatreAndShowScreenings(@PathVariable String username, @PathVariable Long theatreID, @PathVariable Long showID,
      @PathVariable Long roomID, @PathVariable Double regularPrice, @PathVariable Double VIPPrice, @RequestBody ScreeningDTO screeningDTO) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to add screenings.");
      return new ResponseEntity<>(messageDTO, HttpStatus.UNAUTHORIZED);
    }
    Theatre t1 = theatreService.find(theatreID);
    if (!theatreService.findAll().contains(t1)) {
      messageDTO.setError("Theatre doesn't exist!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    }
    Show s1 = showService.find(showID);
    if (!showService.findAll().contains(s1)) {
      messageDTO.setError("Show doesn't exist!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    }
    Room room = roomService.find(roomID);
    if (! roomService.findAll().contains(room) || !t1.getRooms().contains(room)) {
      messageDTO.setError("Room doesn't exist!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    }
    Screening screening = new Screening();
    screening.setDate(screeningDTO.getDate());
    screening.setShow(s1);
    screening.setTheatre(t1);
    screening.setTickets(new HashSet<>());
    for (Seat seat : room.getSeats()) {
      Ticket ticket = new Ticket();
      ticket.setIssueDate(new Date());
      ticket.setNumber("R:" + String.valueOf(seat.getSeatRow()+1) + "-" + "C:" + String.valueOf(seat.getSeatColumn()+1) + "-" + "D:" + String.valueOf(ticket.getIssueDate()));
      if (seat.getSegment().equals(Segment.Regular)) {
        ticket.setPrice(regularPrice);
      } else if (seat.getSegment().equals(Segment.VIP)) {
        ticket.setPrice(VIPPrice);
      }
      ticket.setSeat(seat);
      ticket.setScreening(screening);
      ticket.setType(Ticket.Type.Regular);
      ticket.setSold(false);
      screening.getTickets().add(ticket);
      screeningService.save(screening);
      ticketService.save(ticket);
    }
    screeningService.save(screening);
    return new ResponseEntity<>(messageDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/tickets/set/discount/{username}/{ticketID}/{discount}", method = RequestMethod.POST)
  public ResponseEntity<MessageDTO> setDiscount(@PathVariable String username, @PathVariable Long ticketID, @PathVariable Double discount) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to set discounted tickets.");
      return new ResponseEntity<>(messageDTO, HttpStatus.UNAUTHORIZED);
    }
    Ticket t = ticketService.find(ticketID);
    if (!ticketService.findAll().contains(t)) {
      messageDTO.setError("Ticket with this ID doesn't exist!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    } else {
      t.setType(Ticket.Type.Discounted);
      t.setPrice(t.getPrice() - discount);
      ticketService.save(t);
    }
    return new ResponseEntity<>(messageDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "tickets/discounted/{username}/{theatreID}", method = RequestMethod.GET)
  public ResponseEntity<List<TicketDTO>> getDiscountedTickets(@PathVariable String username, @PathVariable Long theatreID) {
    List<TicketDTO> tickets = new ArrayList<>();
    User u = userService.findByUsername(username);
    if (!userService.findAll().contains(u)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Theatre t = theatreService.find(theatreID);
    if (!theatreService.findAll().contains(t)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    for (Screening s : t.getScreenings()) {
      for (Ticket ticket : s.getTickets()) {
        if (ticket.getType().equals(Type.Discounted)) {
          tickets.add(new TicketDTO(ticket));
        }
      }
    }
    return new ResponseEntity<>(tickets, HttpStatus.OK);
  }

  @RequestMapping(value = "tickets/discounted/reserve/{username}/{ticketID}", method = RequestMethod.POST)
  public ResponseEntity<MessageDTO> reserveDiscountedTicket(@PathVariable String username, @PathVariable Long ticketID) {
    MessageDTO messageDTO = new MessageDTO();
    User u = userService.findByUsername(username);
    if (!userService.findAll().contains(u)) {
      messageDTO.setError("User not found!");
      return new ResponseEntity<>(messageDTO, HttpStatus.NOT_FOUND);
    }
    Ticket t = ticketService.find(ticketID);
    if (!ticketService.findAll().contains(t) || t.isSold()) {
      messageDTO.setError("Ticket not found!");
      return new ResponseEntity<>(messageDTO, HttpStatus.NOT_FOUND);
    }
    if (t.getType().equals(Type.Regular)) {
      messageDTO.setError("Regular ticket can not be quick-reserved!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    }
    t.setSold(true);
    u.getTickets().add(t);
    ticketService.save(t);
    userService.save(u);
    return new ResponseEntity<>(messageDTO, HttpStatus.OK);
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

  @RequestMapping(value = "/rooms/add/{username}/{theatreID}/{row}/{col}", method = RequestMethod.POST)
  public ResponseEntity<MessageDTO> addRoom(@RequestBody RoomDTO roomDTO, @PathVariable String username, @PathVariable Long theatreID,
      @PathVariable int row, @PathVariable int col) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to add rooms.");
      return new ResponseEntity<>(messageDTO, HttpStatus.UNAUTHORIZED);
    }
    Theatre t = theatreService.find(theatreID);
    for (Theatre tr : theatreService.findAll()) System.out.println(tr.getTheatreName());
    if (!theatreService.findAll().contains(t)) {
      messageDTO.setError("Theatre doesn't exist!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    }
    Room r = roomService.find(roomDTO.getId());
    if (roomService.findAll().contains(r)) {
      messageDTO.setError("Room already exists!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    } else {
      Room room = new Room();
      room.setName(roomDTO.getName());
      room.setTheatre(t);
      t.getRooms().add(room);
      roomService.save(room);
      addSeats(roomDTO.getId(), username, row, col);
      theatreService.save(t);
    }
    return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/seats/add/{username}/{roomID}/{row}{col}", method = RequestMethod.POST)
  public ResponseEntity<MessageDTO> addSeats(@PathVariable Long roomID, @PathVariable String username, @PathVariable int row, @PathVariable int col) {
    // This adds a row*col number of seats.
    // Parameters row and col determine how many rows and columns there will be.
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to add seats.");
      return new ResponseEntity<>(messageDTO, HttpStatus.UNAUTHORIZED);
    }
    Room room = roomService.find(roomID);
    if (!roomService.findAll().contains(room)) {
      messageDTO.setError("Room with this ID doesn't exist!");
      return new ResponseEntity<>(messageDTO, HttpStatus.CONFLICT);
    } else {
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          Seat seat = new Seat();
          seat.setSeatRow(i);
          seat.setSeatColumn(j);
          seat.setRoom(room);
          if (seat.getSeatRow() == row || seat.getSeatRow() == row - 1) {
            seat.setSegment(Segment.VIP);
          } else {
            seat.setSegment(Segment.Regular);
          }
          room.getSeats().add(seat);
          seatService.save(seat);
        }
      }
    }
    roomService.save(room);
    return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
  }



  // Business reports.

  @RequestMapping(value = "/theatres/business-report/interval/{username}{theatreID}", method = RequestMethod.GET)
  public ResponseEntity<BusinessReportDTO> businessReport(@PathVariable String username, @PathVariable Long theatreID, @RequestBody Date startDate, @RequestBody Date endDate) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to see the business report.");
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    Theatre theatre = theatreService.find(theatreID);
    BusinessReportDTO businessReportDTO = new BusinessReportDTO();
    Double sales = 0.0;
    Integer sold = 0;
    Double showRating = 0.0;
    Double theatreRating = 0.0;
    if (!theatreService.findAll().contains(theatre)) {
      messageDTO.setError("Theatre doesn't exist!");
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    } else {
      for (Screening screening : theatre.getScreenings()) {
        if (screening.getDate().before(startDate) || screening.getDate().after(endDate)) {
//          messageDTO.setError("There are no screenings in the selected time period.");
//          return new ResponseEntity<>(HttpStatus.CONFLICT);
          sales = 0.0;
        } else {
          if (screening.getTickets().isEmpty()) {
//            messageDTO.setError("No tickets were sold in the selected time period.");
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
            sold = 0;
          } else {
            for (Ticket ticket : screening.getTickets()) {
              if (ticket.isSold()) {
                sales += ticket.getPrice();
                sold += 1;
              }
            }
          }
        }
        for (Rating rating : screening.getShow().getRatings()) {
          showRating += rating.getRating().getValue();
        }
        showRating = showRating/screening.getShow().getRatings().size();
        businessReportDTO.getShowRatings().put(new ShowDTO(screening.getShow()), showRating);
      }
      for (Rating rating : theatre.getRatings()) {
        theatreRating += rating.getRating().getValue();
      }
      theatreRating = theatreRating/theatre.getRatings().size();
    }
    businessReportDTO.setSales(sales);
    businessReportDTO.setSold(sold);
    businessReportDTO.setTheatreRating(theatreRating);
    return new ResponseEntity<>(businessReportDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/theatres/business-report/monthly/{username}/{theatreID}", method = RequestMethod.GET)
  public ResponseEntity businessReportMonthly(@PathVariable String username, @PathVariable Long theatreID) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to see the business report.");
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    HashMap<Integer, BusinessReportDTO> businessReportDTOHashMap = new HashMap<>();
    Calendar c = Calendar.getInstance();
    c.set(Calendar.YEAR, 2018);
    c.set(Calendar.MONTH, 0);
    for (int i = 0; i < 12; i++) {
      int start = 1;
      int end = c.getActualMaximum(Calendar.DAY_OF_MONTH);
      c.set(Calendar.DAY_OF_MONTH, start);
      Date startDate = c.getTime();
      c.set(Calendar.DATE, end);
      Date endDate = c.getTime();
      BusinessReportDTO businessReportDTO = businessReport(username, theatreID, startDate, endDate).getBody();
      businessReportDTOHashMap.put(i+1, businessReportDTO);
      c.add(Calendar.MONTH, 1);
    }
    return new ResponseEntity<>(businessReportDTOHashMap, HttpStatus.OK);
  }

  @RequestMapping(value = "/theatres/business-report/weekly/{username}/{theatreID}", method = RequestMethod.GET)
  public ResponseEntity businessReportWeekly(@PathVariable String username, @PathVariable Long theatreID) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to see the business report.");
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    HashMap<Integer, BusinessReportDTO> businessReportDTOHashMap = new HashMap<>();
    Calendar c = Calendar.getInstance();
    c.set(Calendar.YEAR, 2018);
    c.set(Calendar.MONTH, 0);
    c.set(Calendar.WEEK_OF_YEAR, 0);
    for (int i = 0; i < 52; i++) {
      c.add(Calendar.WEEK_OF_YEAR, 1);
      int start = c.getActualMinimum(Calendar.DAY_OF_WEEK);
      int end = c.getActualMaximum(Calendar.DAY_OF_WEEK);
      c.set(Calendar.DATE, start+i*7);
      Date startDate = c.getTime();
      c.set(Calendar.DATE, end+i*7);
      Date endDate = c.getTime();
      BusinessReportDTO businessReportDTO = businessReport(username, theatreID, startDate, endDate).getBody();
      businessReportDTOHashMap.put(i+1, businessReportDTO);
    }
    return new ResponseEntity<>(businessReportDTOHashMap, HttpStatus.OK);
  }

  @RequestMapping(value = "/theatres/business-report/daily/{username}/{theatreID}", method = RequestMethod.GET)
  public ResponseEntity businessReportDaily(@PathVariable String username, @PathVariable Long theatreID) {
    MessageDTO messageDTO = new MessageDTO();
    Admin u = adminService.findByUsername(username);
    if (!(u instanceof TheatreAdmin)) {
      messageDTO.setError("Only theatre admins are allowed to see the business report.");
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    HashMap<Integer, BusinessReportDTO> businessReportDTOHashMap = new HashMap<>();
    Calendar c = Calendar.getInstance();
    c.set(Calendar.YEAR, 2018);
    c.set(Calendar.MONTH, 0);
    c.set(Calendar.DAY_OF_YEAR, 1);
    for (int i = 0; i < 365; i++) {
      c.set(Calendar.HOUR_OF_DAY, 0);
      c.set(Calendar.MINUTE, 0);
      Date startDate = c.getTime();
      c.set(Calendar.HOUR_OF_DAY, 23);
      c.set(Calendar.MINUTE, 59);
      Date endDate = c.getTime();
      BusinessReportDTO businessReportDTO = businessReport(username, theatreID, startDate, endDate).getBody();
      businessReportDTOHashMap.put(i+1, businessReportDTO);
      c.add(Calendar.DAY_OF_YEAR, 1);
    }
    return new ResponseEntity<>(businessReportDTOHashMap, HttpStatus.OK);
  }

}
