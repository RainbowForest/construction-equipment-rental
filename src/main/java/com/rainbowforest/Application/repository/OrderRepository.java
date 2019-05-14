package com.rainbowforest.Application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.order.Order;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Modifying
	@Query("UPDATE Order o SET o.status = :newStatus WHERE o.id = :id")
	public void updateOrderStatus(@Param("newStatus") int newStatus, @Param("id") int id);
	
	@Query("Select o FROM Order o WHERE o.constructionSite.id = :csId")
	public List<Order> findAllOrderByConstructionSiteId(int csId);
	
	@Query("SELECT o FROM Order o WHERE o.orderingParty = :userName")
	public List<Order> getAllOrdersByUserName(@Param("userName") String userName);	
}
