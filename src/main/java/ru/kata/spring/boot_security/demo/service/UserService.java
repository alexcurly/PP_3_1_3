package ru.kata.spring.boot_security.demo.service;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;


import ru.kata.spring.boot_security.demo.model.User;
public interface UserService extends UserDetailsService {


    public User getUserById(long id);


    public List<User> getAllUsers();

    User findUserByUsername(String username);

    public void save(User user);

    User findByEmail(String email);
    public void deleteUserById(long id);

    public void update(User user);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

}
