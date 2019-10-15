package com.casestudy.eCart.controller;

import com.casestudy.eCart.Modal.Items;
import com.casestudy.eCart.Modal.Users;
import com.casestudy.eCart.exception.ResourceNotFoundException;
import com.casestudy.eCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    UserRepository usr;
    @PostMapping(value = "/savedata", consumes = "application/json")
    public Users signup(@RequestBody Users user)
    {
        user.setActive(1);
        user.setAuthentication("basic ");
        usr.save(user);
        return user;
    }
    @GetMapping(path = "/getdata/{id}")
    public Users getuser(@PathVariable(value = "id") Long id)
    {
        return usr.findById(id).orElseThrow(()-> new ResourceNotFoundException("users","id",id));
    }
}
