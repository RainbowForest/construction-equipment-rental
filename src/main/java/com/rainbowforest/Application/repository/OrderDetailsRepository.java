package com.rainbowforest.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.order.OrderDetails;

@Repository
@Transactional
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
