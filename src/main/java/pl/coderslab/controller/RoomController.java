package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Occupants;
import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.Room;
import pl.coderslab.entity.RoomType;
import pl.coderslab.model.Offer;
import pl.coderslab.repository.GuestRepository;
import pl.coderslab.repository.ReservationRepository;
import pl.coderslab.repository.RoomRepository;
import pl.coderslab.service.OfferService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    private OfferService offerService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        Room room = null;
        if (id != null && id != 0) {
            room = roomRepository.findOne(id);
        } else {
            room = new Room();
        }
        model.addAttribute("room", room);
        return "room/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String showForm(@Valid Room room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "room/add";
        }

        if (roomRepository.findByNumber(room.getNumber()) != null) {
            model.addAttribute("error", "Chyba juz jest pokój o tym numerze");
            return "room/add";
        }

        roomRepository.save(room);
        return "redirect:manage";
    }






  /*  @RequestMapping(value = "/{roomId}", params="add", method = RequestMethod.GET)
    public String addReservation(@PathVariable("roomId") Long roomId, Model model) {
        Room room = roomRepository.findOne(roomId);
        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setCancelled(false);
        setMainAttributes(model);
        model.addAttribute("room", room);
        model.addAttribute("reservation", reservation);
        return "make";
    }
*/

    @ModelAttribute("rooms")
    public List<Room> getReservation() {
        return roomRepository.findAll();
    }

    @ModelAttribute("type")
    public List<RoomType> ptype() {
        return Arrays.asList(RoomType.values());
    }

    @ModelAttribute("occupants")
    public List<Occupants> ocu() {
        return Arrays.asList(Occupants.values());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showForm(@RequestParam Long id) {
        Room room = roomRepository.findOne(id);
        roomRepository.delete(room);
        return "redirect:manage";
    }


    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String simple() {
        return "room/manage_rooms";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String processSimple(@RequestParam String Start,
                                @RequestParam String End, @RequestParam RoomType roomType, @RequestParam Occupants occupants, Model model, HttpSession ses) {


        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date startDate = formatter.parse(Start);
            Date endDate = formatter.parse(End);


            if (startDate.compareTo(endDate) < 0) {


                Reservation reservation = (Reservation) ses.getAttribute("reservation");
                reservation.setDateFrom(startDate);
                reservation.setDateTo(endDate);
                //calculate days

                long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());


                List<Room> rooms = roomRepository.getAvailableRooms(roomType, occupants, startDate, endDate);
                List<Room> otherRooms = roomRepository.getOtherAvailableRooms(startDate, endDate);
                if (rooms.isEmpty() && !otherRooms.isEmpty()) {

                    rooms = otherRooms;
                    List<Offer> offers = offerService.getOffers(rooms, days);
                    model.addAttribute("offers", offers);
                    model.addAttribute("NoRoom", "Rooms with given parameters are no available in selected dates");
                    model.addAttribute("DatesInfo", "Other types of rooms available from " + Start + " to " + End);




                } else if (otherRooms.isEmpty()) {
                    model.addAttribute("DatesInfo", "No rooms available between " + Start + " and " + End);


                }



                else {


                    rooms = roomRepository.getAvailableRooms(roomType, occupants, startDate, endDate);
                    List<Offer> offers = offerService.getOffers(rooms, days);
                    model.addAttribute("offers", offers);
                    model.addAttribute("DatesInfo", "Rooms with given parameters available from " + Start + " to " + End);

                }

            } else {
                model.addAttribute("superError", "Enter correct date range");
                return "redirect:search";


            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "room/availableRooms";
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(HttpSession session) {
        session.setAttribute("reservation", new Reservation());


        return "room/search";
    }


    @RequestMapping(path = "/confirmDelete")
    public String confirmDelete() {
        return "room/confirmDelete";
    }

    @RequestMapping(path = "/availableRooms")
    public String AvailableRooms() {
        return "room/availableRooms";
    }

    @RequestMapping(value = "/availableRooms", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Room available) {


        return "reservation/makeReservation";
    }


    @RequestMapping(value = "/changePrice", method = RequestMethod.GET)
    public String changePriceGET(@RequestParam Long id, Model model) {
        Room room = roomRepository.findOne(id);
        model.addAttribute(room);
        return "room/changePrice";


    }

    @RequestMapping(value = "/changePrice", method = RequestMethod.POST)
    public String changePricePOST(@Valid Room room, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("eerr");
            return "room/changePrice";

        }
        roomRepository.save(room);
        return "redirect:manage";


    }

}
