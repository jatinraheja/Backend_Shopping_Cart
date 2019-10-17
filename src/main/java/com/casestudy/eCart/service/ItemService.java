package com.casestudy.eCart.service;

import com.casestudy.eCart.Modal.Items;
import com.casestudy.eCart.repository.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    itemRepository itemRepository;
    public ItemService()
    {

    }
//    public boolean addProduct(Items items)
//    {
//        itemRepository.save(items);
//        return true;
//    }
    public Items editItem(Items newitem,Long id)
    {
        Items olditem = itemRepository.findById(id).get();
        newitem.setProductid(olditem.getProductid());
        newitem.setActive(olditem.getActive());
        itemRepository.save(newitem);
        return newitem;
    }
}
