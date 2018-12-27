package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Guest;
import pl.coderslab.entity.Reservation;
import pl.coderslab.repository.GuestRepository;
import pl.coderslab.repository.ReservationRepository;
import pl.coderslab.repository.RoomRepository;
import pl.coderslab.service.SMSService;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    SMSService smsService;




    @GetMapping("/add")
    public String showRegister( @RequestParam(required = false) Long id, Model model) {
        Guest guest = id == null ? new Guest() : guestRepository.findOne(id);
        model.addAttribute("guest", new Guest());
        return "guest/register";
    }

    @PostMapping("/add")
    public String showRegister(@Valid Guest guest, BindingResult result) {
        if (result.hasErrors()) {
            return "guest/register";
        }
        Guest existingGuest = guestRepository.findFirstByEmail(guest.getEmail());
        if (existingGuest != null) {
            FieldError error = new FieldError("guest", "email", "Email musi być unikalny");
            result.addError(error);
            return "guest/register";
        }
        guestRepository.save(guest);
        return "redirect:manage";
    }

  /*  @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("guest", new Guest());
        return "guest/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Guest guest, Model model, HttpSession session) {
        Guest existingUser = guestRepository.findFirstByEmail(guest.getEmail());
        if (existingUser != null && existingUser.getEmail().equals(guest.getEmail())
                && existingUser.getPassword().equals(guest.getPassword())) {
            session.setAttribute("email", existingUser.getEmail());
        } else {
            model.addAttribute("loginError", "Nieprawidłowy email lub hasło");
        }
        return "redirect:/";
    }

    @RequestMapping(path = "../logout")
    public String logout(HttpSession session) {
        session.removeAttribute("email");
        return "redirect:/";
    } */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGuest(@RequestParam Long id){
        Guest guest = guestRepository.findOne(id);
        guestRepository.delete(guest);
        return "redirect:manage";
    }
    @RequestMapping("/manage")
    public String showAllGuests(){
        return "guest/manage_guests";
    }
    @ModelAttribute("guests")
    public List<Guest> getGuest(){
        return guestRepository.findAll();
    }

    @RequestMapping(path = "/confirmDelete")
    public String confirmDelete() {
        return "guest/confirmDelete";
    }



    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        Guest guest = guestRepository.findOne(id);
        model.addAttribute("guest", guest);
        return "guest/editGuest";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String showForm(@Valid Guest guest, BindingResult result) {
        if (result.hasErrors()) {
            return "guest/editGuest";
        }
        guestRepository.save(guest);
        return "redirect:manage";
    }

    @RequestMapping(value = "/sendInfo", method = RequestMethod.GET)
    public String sendInfo (@RequestParam Long id, Model model) {
        if (id != null) {
        Guest guest  = guestRepository.findOne(id);
        Reservation reservation = reservationRepository.findFirstByGuestOrderByDateFrom(guest);
        String text = "Your reservation starts on: " +  reservation.getDateFrom().toString() + " please prepare " + reservation.getTotalPrice() + "PLN";
        String phoneNumber = guest.getPhoneNumber();
       boolean success = smsService.Send(phoneNumber, text);
       model.addAttribute("idSent", guest.getId());
            if (success) {
                model.addAttribute("operation", "Operacja zakończona powodzeniem");

            } else {
                model.addAttribute("operation", "Błąd operacji");
            }
        }
        return "guest/manage_guests";

    }



}





