package com.casestudy.eCart.controller;

import com.casestudy.eCart.Modal.Users;
import com.casestudy.eCart.Modal.cart;
import com.casestudy.eCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository usr;
    @GetMapping("/allusers")
    public List<Users> getAllItems()
    {
        return usr.findAll();
    }
    @PostMapping
    public Users addUser(@Valid @RequestBody Users user)
    {
      return  usr.save(user);

    }
    @GetMapping("/users")
    public Optional<Users> getUser(Principal principal) {return usr.findByEmail(principal.getName());}
}
