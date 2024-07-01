package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping(value = "")
    public String showUserInfo(ModelMap modelMap, Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        modelMap.addAttribute("user", user);

        return "user";

    }
}



//package ru.kata.spring.boot_security.demo.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
//
//import java.security.Principal;
//
//
//@Controller
////@RequestMapping("/admin")
//public class UserController {
//    private final UserServiceImpl userService;
//    @Autowired
//    public UserController(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//    @GetMapping("/")
//    public String getAllUsers(Model model) {
//        userService.getAllUsers();
//        model.addAttribute("users", userService.getAllUsers());
//        return "index";
//    }
//    @GetMapping("/adduser")
//    public String createUserForm(User user) {
//        return "adduser";
//    }
//
//    @PostMapping("/adduser")
//    public String addUser(User user) {
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//    @GetMapping("/deleteUser")
//    public String deleteUser(@RequestParam("id") long id) {
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
//    @GetMapping("/updateuser")
//    public String getEditUserForm(Model model, @RequestParam("id") long id) {
//        User user = userService.getUser(id);
//        model.addAttribute("user", user);
//
//
//        return "updateuser";
//    }
//    @PostMapping("/updateuser")
//    public String updateUser(User user){
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//}