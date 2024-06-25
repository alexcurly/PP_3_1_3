package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController("/index")
public class MainController {

    @GetMapping(value = "")
    public String showMainPage() {
        return "index";
    }

//    @GetMapping("/")
//    public String homePage() {
//        return "home";
//    }
//
//
//    @GetMapping("/authenticated")
//    public String pageForAuthenticatedUsers(Principal principal) {
//        return "secured part of web service: " + principal.getName();
//    }
//
//    @GetMapping("/admin")
//    public String pageForAdmin() {
//        return "admin" ;
////        return "ADMIN secured part of web service: " ;
//    }
//
//    @GetMapping("/read_profile")
//    public String pageForReadProfile() {
//        return "read_profile secured part of web service: " ;
//    }
}
