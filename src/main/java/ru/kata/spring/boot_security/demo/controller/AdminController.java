package ru.kata.spring.boot_security.demo.controller;

import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService  roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }


    @GetMapping("")
    public String getAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/adduser")
    public String createUserForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("role", roleService.getAllUsers());
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }


    @GetMapping("/updateuser/{id}")
    public String getEditUserForm(@PathVariable("id") Long id, Model model) {
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        model.addAttribute("roles", roleService.getAllUsers());
        return "updateuser";
    }
    @PutMapping("/updateuser/{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/admin";
    }


    @PostMapping("/users")
    public String deleteUser(@RequestParam(value = "id", required = false) Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}