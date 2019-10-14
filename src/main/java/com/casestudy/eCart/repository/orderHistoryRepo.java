package com.casestudy.eCart.repository;

import com.casestudy.eCart.Modal.orderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface orderHistoryRepo extends JpaRepository<orderHistory,Long> {
    List<orderHistory> findAllByUserId(Long id);
}
