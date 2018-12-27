package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Guest;
import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.User;
import pl.coderslab.model.Offer;
import pl.coderslab.repository.GuestRepository;
import pl.coderslab.repository.ReservationRepository;
import pl.coderslab.repository.RoomRepository;
import pl.coderslab.repository.UserRepository;
import pl.smsapi.BasicAuthClient;
import pl.smsapi.api.SmsFactory;
import pl.smsapi.api.action.sms.SMSSend;
import pl.smsapi.api.response.MessageResponse;
import pl.smsapi.api.response.StatusResponse;
import pl.smsapi.exception.ClientException;
import pl.smsapi.exception.SmsapiException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userSession");

        if (userRepository.findAll().size()<1) {

            return "redirect:user/registerFirst";

        }

        if (user != null) {

       return  "home";}
        else {
            model.addAttribute("user", new User());
            return "homepage";


        }
    }



    @PostMapping("")
    public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User existingUser = userRepository.findFirstByEmail(user.getEmail());
        System.out.println("bla");
        if (existingUser != null && existingUser.getEmail().equals(user.getEmail())
                && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("userSession", existingUser);


        } else {
            model.addAttribute("loginError", "Invalid email or password");
            return "homepage";

        }
return "redirect:/";
    }


    @RequestMapping(path = "/logout")
    public String logout(HttpSession session) {


        session.removeAttribute("userSession");
        return "redirect:/";
    }




    @GetMapping("home")
    public String index() {
       return "home";

    }


    @ModelAttribute("reservationsFrom")
    public List<Reservation> getReservationFrom(){

        return reservationRepository.findByDatesFrom(new Date());
    }

    @ModelAttribute("reservationsTo")
    public List<Reservation> getReservationTo(){

        return reservationRepository.findByDatesTo(new Date());
    }
}


