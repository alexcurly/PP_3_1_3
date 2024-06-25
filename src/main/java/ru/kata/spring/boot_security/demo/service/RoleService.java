package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface RoleService {


    public List<Role> getAllUsers();

    public Role getUserById(long id);

    public void saveUser(Role role);



}
