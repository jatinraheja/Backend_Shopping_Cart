package com.casestudy.eCart.controller;

import com.casestudy.eCart.Modal.cart;
import com.casestudy.eCart.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/carts")

public class CartController {
    @Autowired
    cartService cartService;

    @GetMapping("/allcart")
    public ArrayList<cart> getCart(Principal principal) {return cartService.getEmail(principal);}

    @GetMapping(path = "/cart/addItem/productId/{id}")
    public String addItemToCart(@PathVariable("id") Long productId, Principal principal) {
        return cartService.additemstoCart(principal,productId);
    }
    @GetMapping(path = "/cart/deleteItem/productId/{id}")
    public String deleteItemFromCart(@PathVariable("id") Long id,Principal principal)
    {
        return cartService.deleteItemFromCart(id,principal);
    }
    @GetMapping(path = "/cart/increment/{value}/product/{productId}")
    public String increment(@PathVariable("value") int value,
                            @PathVariable("productId") Long productId, Principal principal) {
        return cartService.increment(value,productId,principal);

    }
    @GetMapping(path = "/cart/decrement/{value}/product/{productId}")
    public String decrement(@PathVariable("value") int value,
                            @PathVariable("productId") Long productId, Principal principal) {
        return cartService.decrement(value,productId,principal);

    }





}
