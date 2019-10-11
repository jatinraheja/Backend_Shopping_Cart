package com.casestudy.eCart.repository;

import com.casestudy.eCart.Modal.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface itemRepository extends JpaRepository<Items, Long> {


    @Override
    List<Items> findAll();
    List<Items> findByProductid(Long id);
    List<Items> findAllByCategory(String category);

    List<Items> findByPriceBetween(Double price1, Double price2);


}
