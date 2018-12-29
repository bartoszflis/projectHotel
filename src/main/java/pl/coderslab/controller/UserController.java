package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Room;
import pl.coderslab.entity.RoomType;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserType;
import pl.coderslab.repository.GuestRepository;
import pl.coderslab.repository.ReservationRepository;
import pl.coderslab.repository.RoomRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;




    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showForm(@RequestParam(required = false) Long id, Model model){
        User user = null;
        if(id!=null&&id!=0){
            user = userRepository.findOne(id);
        } else {
            user = new User();
        }
        model.addAttribute("user",user);
        return "user/register";
    }




    @PostMapping("/register")
    public String showRegister(@Valid User user, BindingResult result) {
        User existingUser = userRepository.findFirstByEmail(user.getEmail());
        if (existingUser != null) {
            FieldError error = new FieldError("user", "email", "Taki email już istnieje w bazie danych");
            result.addError(error);
        }
        if (result.hasErrors()) {
            return "user/register";
        }

        userRepository.save(user);
        return "user/manage_users";
    }


    @RequestMapping(value = "/registerFirst", method = RequestMethod.GET)
    public String registerFirst(Model model){
        if (userRepository.findAll().size() >= 1) {
        return "redirect:/";

        }
        model.addAttribute("user", new User());
        return "user/registerFirst";
    }




    @PostMapping("/registerFirst")
    public String registerFirstPOST(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/registerFirst";
        }
        userRepository.save(user);
        return "redirect:/";
    }





    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String simple() {
        return "user/manage_users";
    }

    @ModelAttribute("users")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showForm(@RequestParam Long id){
        User user = userRepository.findOne(id);
        userRepository.delete(user);
        return "redirect:manage";
    }
    @RequestMapping(path = "/confirmDelete")
    public String confirmDelete() {
        return "user/confirmDelete";
    }

    @ModelAttribute("type")
    public List<UserType> utype()
    {
        return Arrays.asList(UserType.values());
    }

}
