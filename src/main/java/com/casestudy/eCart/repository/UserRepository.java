package com.casestudy.eCart.repository;

import com.casestudy.eCart.Modal.Items;
import com.casestudy.eCart.Modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    public Optional<Users> findByEmail(String email);


}
