package com.casestudy.eCart.controller;

import com.casestudy.eCart.Modal.Users;
import com.casestudy.eCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
}
