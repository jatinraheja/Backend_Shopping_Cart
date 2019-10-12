package com.casestudy.eCart.service;

import com.casestudy.eCart.Modal.Items;
import com.casestudy.eCart.Modal.Users;
import com.casestudy.eCart.Modal.cart;
import com.casestudy.eCart.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@Service
public class cartService {
    @Autowired
    private itemRepository itemrepository;
    @Autowired
    private cartRepository cartrepository;
    @Autowired
    UserRepositoryClass userRepositoryClass;
    itemRepositoryclass itemRepositoryclass;
    private ArrayList<cart> getCartFrontUser(Principal principal)
    {
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
        ArrayList<cart> car = cartrepository.findAllByUsers(users);
        return car;

    }
    public ArrayList<cart> getEmail(Principal principal) {
        String email = principal.getName();
        Optional<Users> users= userRepositoryClass.getByEmail(email);
        return cartrepository.findAllByUsers(users);
    }
    public String additemstoCart(Principal principal, Long id) {
        Optional<Items> item = itemrepository.findById(id);
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
        ArrayList<cart> cart = getCartFrontUser(principal);
        for(int i = 0; i<cart.size(); i++)
        {
            cart cartObj = cart.get(i);
            if(cartObj.getItems() == item.get())
            {
                cartObj.setQuantity(cartObj.getQuantity() + 1);
                cartrepository.save(cartObj);
                return "\"Quantity++\"";
            }
        }
        cart cartObj = new cart();
        cartObj.setQuantity(1);
        cartObj.setItems(item.get());
        cartObj.setUsers(users.get());
        cartrepository.save(cartObj);
        return "\"Item added\"";
    }
    @Transactional
    public String deleteItemFromCart(Long id, Principal principal)
    {
        Optional<Items> items = itemrepository.findById(id);
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
        cartrepository.deleteByUsersAndItems(users,items);
        return "\"deletion completed\"";
    }
    public String increment(int value, Long productId, Principal principal)
    {
        ArrayList<cart> carts = getCartFrontUser(principal);
        Optional<Items> items=itemrepository.findById(productId);
        for(int i=0 ; i<carts.size() ; i++)
        {
            cart cartObj = carts.get(i);
            if(cartObj.getItems() == items.get())
            {
                cartObj.setQuantity(cartObj.getQuantity() + value);
                cartrepository.save(cartObj);
                return "Successful";
            }
        }
        return "Unsuccessful";
    }
    public String decrement(int value, Long productId ,Principal principal )
    {
        ArrayList<cart> cart = getCartFrontUser(principal);
        Optional<Items> items=itemrepository.findById(productId);
        for(int i=0 ; i<cart.size() ; i++)
        {
            cart cartObj = cart.get(i);
            if(cartObj.getItems() == items.get())
            {
                cartObj.setQuantity(cartObj.getQuantity() - value);
                cartrepository.save(cartObj);
                return "Successfull";
            }
        }
        return "Unsuccessfull";
    }


}
