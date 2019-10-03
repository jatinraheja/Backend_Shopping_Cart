package com.casestudy.eCart.repository;

import com.casestudy.eCart.Modal.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface itemRepository extends JpaRepository<Items, Long> {

    List<Items> findAllByCategory(String category);
}
