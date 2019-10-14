package com.casestudy.eCart.repository;

import com.casestudy.eCart.Modal.User;
import com.casestudy.eCart.Modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryClass {
    @Autowired
    UserRepository UserRepository;
    public void add(Users users) {
        System.out.println("Adding  a value");
        UserRepository.save(users);
    }
    public Optional<Users> getByEmail(String email)
    {
        System.out.println("Getting by email");
        return UserRepository.findByEmail(email);
    }
    public Optional<Users> getById (Long id) { return UserRepository.findById(id);}


}
