package com.casestudy.eCart.repository;

import com.casestudy.eCart.Modal.Items;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class itemRepositoryclass {
    @Autowired
    itemRepository itemRepository;
    public boolean additems(Items item)
    {
        try{
            System.out.println("Adding a product");
            itemRepository.save(item);
            System.out.println("Product added");
            return true;
        }
        catch (Exception e) {

            return false;
        }
    }
    public ArrayList<Items> getAllProducts()
    {
        return (ArrayList<Items>)itemRepository.findAll();
    }
    public Optional<Items> getField(Long id) {
        return itemRepository.findById(id);
    }
    public Optional<Items> getById(Long id)
    {
        return itemRepository.findById(id);
    }


}
