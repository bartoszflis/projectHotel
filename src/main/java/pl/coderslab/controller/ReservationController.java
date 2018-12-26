package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Guest;
import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.Room;
import pl.coderslab.repository.GuestRepository;
import pl.coderslab.repository.ReservationRepository;
import pl.coderslab.repository.RoomRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;


    @GetMapping("/makeReservation")
    public String showRes(@RequestParam(required = false) Long id,  Model model) {
        Guest guest = new Guest();
        model.addAttribute("guest", guest);


        return "reservation/makeReservation";
    }


    @PostMapping(value = "/makeReservation")
    public String addUser(@Valid Guest guest, BindingResult result, @RequestParam long roomId, HttpSession session) {
        if (result.hasErrors()) {
            return "reservation/makeReservation";
        }

        guestRepository.save(guest);
        Reservation reservation = (Reservation)session.getAttribute("reservation");
        reservation.setGuest(guest);

        reservation.setRoom(roomRepository.getOne(roomId));
        reservationRepository.save(reservation);
        return "redirect:manage";
    }


    @RequestMapping("/all")
    public String showAll(){
        return "admin/show_reservations";
    }
    @ModelAttribute("reservations")
    public List<Reservation> getReservation(){
        return reservationRepository.findAll();
    }



    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String simple() {
        return "reservation/manage_reservations";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showForm(@RequestParam Long id){
        Reservation reservation = reservationRepository.findOne(id);
        reservationRepository.delete(reservation);
        return "redirect:manage";
    }
    @RequestMapping(path = "/confirmDelete")
    public String confirmDelete() {
        return "reservation/confirmDelete";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        Reservation reservation = reservationRepository.findOne(id);
        model.addAttribute("reservation", reservation);
        return "reservation/editReservation";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String showForm(@Valid Reservation reservation, BindingResult result) {
        if (result.hasErrors()) {
            return "reservation/editReservation";
        }
        reservationRepository.save(reservation);
        return "redirect:manage";
    }
}
