package com.casestudy.eCart.repository;

import com.casestudy.eCart.Modal.Items;
import com.casestudy.eCart.Modal.Users;
import com.casestudy.eCart.Modal.cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface cartRepository extends CrudRepository<cart,Long> {
    public ArrayList<cart> findAllByUsers(Optional<Users> users);
    void deleteByUsersAndItems(Optional<Users> users, Optional <Items> items);

}
